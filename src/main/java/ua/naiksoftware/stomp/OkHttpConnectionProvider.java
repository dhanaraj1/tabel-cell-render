package ua.naiksoftware.stomp;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

class OkHttpConnectionProvider extends AbstractConnectionProvider {

	public static final String TAG = "OkHttpConnProvider";

	private final String mUri;
	@NonNull
	private final Map<String, String> mConnectHttpHeaders;
	private final OkHttpClient mOkHttpClient;

	@Nullable
	private WebSocket openSocket;

	OkHttpConnectionProvider(String uri, @Nullable Map<String, String> connectHttpHeaders, OkHttpClient okHttpClient) {
		super();
		mUri = uri;
		mConnectHttpHeaders = connectHttpHeaders != null ? connectHttpHeaders : new HashMap<>();
		mOkHttpClient = okHttpClient;
	}

	@Override
	public void rawDisconnect() {
		if (openSocket != null) {
			openSocket.close(1000, "");
		}
	}

	@Override
	void createWebSocketConnection() {
		final Request.Builder requestBuilder = new Request.Builder()
				.url(mUri);

		addConnectionHeadersToBuilder(requestBuilder, mConnectHttpHeaders);

		openSocket = mOkHttpClient.newWebSocket(requestBuilder.build(),
				new WebSocketListener() {
			@Override
			public void onOpen(WebSocket webSocket, @NonNull Response response) {
				final LifecycleEvent openEvent = new LifecycleEvent(LifecycleEvent.Type.OPENED);

				final TreeMap<String, String> headersAsMap = headersAsMap(response);

				openEvent.setHandshakeResponseHeaders(headersAsMap);
				emitLifecycleEvent(openEvent);
			}

			@Override
			public void onMessage(WebSocket webSocket, String text) {
				if (text.equals("\n")) {
					System.out.println("RECEIVED HEARTBEAT");
				} else {
					emitMessage(text);
				}
			}

			@Override
			public void onMessage(WebSocket webSocket, @NonNull ByteString bytes) {
				emitMessage(bytes.utf8());
			}

			@Override
			public void onClosed(WebSocket webSocket, int code, String reason) {
				openSocket = null;
				emitLifecycleEvent(new LifecycleEvent(LifecycleEvent.Type.CLOSED));
			}

			@Override
			public void onFailure(WebSocket webSocket, Throwable t, Response response) {
				// in OkHttp, a Failure is equivalent to a JWS-Error *and* a JWS-Close
				emitLifecycleEvent(new LifecycleEvent(LifecycleEvent.Type.ERROR, new Exception(t)));
				openSocket = null;
				emitLifecycleEvent(new LifecycleEvent(LifecycleEvent.Type.CLOSED));
			}

			@Override
			public void onClosing(final WebSocket webSocket, final int code, final String reason) {
				webSocket.close(code, reason);
			}
		}

				);
	}

	@Override
	void rawSend(String stompMessage) {
		openSocket.send(stompMessage);
	}

	@Nullable
	@Override
	Object getSocket() {
		return openSocket;
	}

	@NonNull
	private TreeMap<String, String> headersAsMap(@NonNull Response response) {
		final TreeMap<String, String> headersAsMap = new TreeMap<>();
		final Headers headers = response.headers();
		for (final String key : headers.names()) {
			headersAsMap.put(key, headers.get(key));
		}
		return headersAsMap;
	}

	private void addConnectionHeadersToBuilder(@NonNull Request.Builder requestBuilder, @NonNull Map<String, String> mConnectHttpHeaders) {
		for (final Map.Entry<String, String> headerEntry : mConnectHttpHeaders.entrySet()) {
			requestBuilder.addHeader(headerEntry.getKey(), headerEntry.getValue());
		}
	}
}

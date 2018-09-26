package com.test;

import java.util.Arrays;

import com.test.pojo.ClientRequest;
import com.test.util.ApplicationUtils;

import ua.naiksoftware.stomp.Stomp;
import ua.naiksoftware.stomp.client.StompClient;

public class StompTest {

	public static void main(String[] args) {
		final StompClient mStompClient = Stomp.over(Stomp.ConnectionProvider.OKHTTP, "ws://localhost:3030/liteapi/mlive-channel");
		mStompClient.connect();

		mStompClient.send("/app/topic/watch/5b94bf25afba640ed8070005",ApplicationUtils.generateJSONFromObject(new ClientRequest())).subscribe();
		try {
			Thread.sleep(1000);
		} catch (final InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//mStompClient.send("/app/topic/login", "zBnir85bs66xMTdZxzTKaXOwgf9+1HpIuc+AMCEVz40KW9/7k7+a4/vA60VEXQEaRh+p2S/FlYbgcwD2D+0kQQ==").subscribe();

		mStompClient.topic("/topic/watch/5b94bf25afba640ed8070005").subscribe(topicMessage -> {
			System.out.println("recived \n"+ topicMessage.getPayload());
		});

		final ClientRequest clientRequest=new ClientRequest();
		clientRequest.setIsMobile(Boolean.TRUE);
		clientRequest.setIsFirstTime(Boolean.TRUE);
		clientRequest.setScripts(Arrays.asList("NSE-ADANIENT-27/09/2018","NSE-AJANTPHARM-27/09/2018"));
		clientRequest.setWantToStart(Boolean.FALSE);
		clientRequest.setWantToStop(Boolean.FALSE);
		try {
			Thread.sleep(1000);
		} catch (final InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mStompClient.send("/app/topic/watch/5b94bf25afba640ed8070005",ApplicationUtils.generateJSONFromObject(clientRequest)).subscribe();
		try {
			Thread.sleep(2000);
		} catch (final InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		final ClientRequest clientRequest2=new ClientRequest();
		clientRequest2.setIsMobile(Boolean.TRUE);
		clientRequest2.setIsFirstTime(Boolean.FALSE);
		clientRequest2.setWantToStop(false);
		clientRequest2.setWantToStart(true);
		mStompClient.send("/app/topic/watch/5b94bf25afba640ed8070005",ApplicationUtils.generateJSONFromObject(clientRequest2)).subscribe();
		mStompClient.lifecycle().subscribe(lifecycleEvent -> {
			switch (lifecycleEvent.getType()) {

			case OPENED:
				System.out.println( "Stomp connection opened");
				break;

			case ERROR:
				System.out.println(  "Error" + lifecycleEvent.getException());
				break;

			case CLOSED:
				System.out.println( "Stomp connection closed");
				break;
			}
		});

		// ...

		//mStompClient.disconnect();

	}

}

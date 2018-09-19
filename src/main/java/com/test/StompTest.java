package com.test;

import ua.naiksoftware.stomp.Stomp;
import ua.naiksoftware.stomp.client.StompClient;

public class StompTest {

	public static void main(String[] args) {
		final StompClient mStompClient = Stomp.over(Stomp.ConnectionProvider.OKHTTP, "ws://localhost:3030/liteapi/mlive-channel");
		mStompClient.connect();

		mStompClient.topic("/user/topic/login").subscribe(topicMessage -> {
			System.out.println( topicMessage.getPayload());
		});

		mStompClient.send("/app/topic/login", "zBnir85bs66xMTdZxzTKaXOwgf9+1HpIuc+AMCEVz40KW9/7k7+a4/vA60VEXQEaRh+p2S/FlYbgcwD2D+0kQQ==").subscribe();

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

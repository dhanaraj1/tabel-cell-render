package com.test;

import java.util.Arrays;

import com.test.pojo.ClientRequest;
import com.test.util.ApplicationUtils;

import ua.naiksoftware.stomp.Stomp;
import ua.naiksoftware.stomp.client.StompClient;

public class StompTest {

	public static void main(String[] args) {
		//lite.bcommo.in
		final StompClient mStompClient = Stomp.over(Stomp.ConnectionProvider.OKHTTP, "ws://lite.bcommo.in:9090/liteapi/mlive-channel");
		mStompClient.connect();
		
		/*mStompClient.topic("/user/topic/login").subscribe(topicMessage -> {
			System.out.println("recived \n"+ topicMessage.getPayload());
		});
		//JwMgzrkg1wAv6By38dmVnS1498yOtbCINmfiBEGbZSKObnmFrxj7n5RdJ6CFSV+3DsOztNwc3wKE3yDy+wDpZg==
		//qLPt/S96jVRJIbCbB/yh/7jDDlOO+Egro0Z6oCNoBf8=
		mStompClient.send("/app/topic/login","qLPt/S96jVRJIbCbB/yh/7jDDlOO+Egro0Z6oCNoBf8=").subscribe();
		*/
		final ClientRequest onopenClientRequest =new ClientRequest();
		onopenClientRequest.setIsMobile(Boolean.TRUE);
		onopenClientRequest.setScripts(Arrays.asList("MCX-GOLD-05/12/2018","MCX-COPPER-28/02/2019"));
		mStompClient.topic("/topic/watch/5bbaee3cbdd9161790b96776").subscribe(topicMessage -> {
			System.out.println("recived \n"+ topicMessage.getPayload());
		});
		
		//mStompClient.send("/app/topic/watch/5b8a2e7df3391b75cb9441dd",ApplicationUtils.generateJSONFromObject(onopenClientRequest)).subscribe();

		//5b94bf25afba640ed8070005
		//5b8a2e7df3391b75cb9441dd

		final ClientRequest clientRequest=new ClientRequest();
		clientRequest.setIsMobile(Boolean.TRUE);
		clientRequest.setScripts(Arrays.asList("MCX-COPPER-28/02/2019"));
		clientRequest.setWantToRemoveScripts(Boolean.TRUE);
		
		try {
			Thread.sleep(10000);
		} catch (final InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mStompClient.send("/app/topic/watch/5bbaee3cbdd9161790b96776",ApplicationUtils.generateJSONFromObject(clientRequest)).subscribe();
		/*try {
			Thread.sleep(2000);
		} catch (final InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		/*final ClientRequest clientRequest2=new ClientRequest();
		clientRequest2.setIsMobile(Boolean.TRUE);
		clientRequest2.setIsFirstTime(Boolean.FALSE);
		clientRequest2.setWantToStop(false);
		clientRequest2.setWantToStart(true);
		mStompClient.send("/app/topic/watch/5b8a2e7df3391b75cb9441dd",ApplicationUtils.generateJSONFromObject(clientRequest2)).subscribe();
		 */
		
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

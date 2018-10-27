package jamshedpur.nit.culfest.com.culfest17;

import android.content.Context;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by Dell on 2/8/2018.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // TODO(developer): Handle FCM messages here.
        // If the application is in the foreground handle both data and notification messages here.
        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
        Log.d("from", "From: " + remoteMessage.getFrom());
        Log.d("body", "Notification Message Body: " + remoteMessage.getNotification().getBody());
        Log.d("notificationid",remoteMessage.getMessageId());
        //Context context=getApplication();

    }
}

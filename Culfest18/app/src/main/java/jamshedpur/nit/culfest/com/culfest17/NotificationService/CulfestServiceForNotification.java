package jamshedpur.nit.culfest.com.culfest17.NotificationService;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jamshedpur.nit.culfest.com.culfest17.Activity.NotificationActivity;
import jamshedpur.nit.culfest.com.culfest17.Activity.SplashScreenActivity;
import jamshedpur.nit.culfest.com.culfest17.R;
import jamshedpur.nit.culfest.com.culfest17.SQLite.DatabaseLRHandler;
import jamshedpur.nit.culfest.com.culfest17.Util.Notification;
import jamshedpur.nit.culfest.com.culfest17.Volley.MyVolleyClass;

public class CulfestServiceForNotification extends Service {
    public Context context = this;
    public Handler handler = null;
    public static Runnable runnable = null;
    DatabaseLRHandler db;
    public CulfestServiceForNotification() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");

    }
    @Override
    public void onCreate() {
        //Toast.makeText(this, "Service created!", Toast.LENGTH_LONG).show();
        Log.d("yeah","service is restarted");
        db=new DatabaseLRHandler(this);
        Log.d("yeah baby again","yeah beby");
        handler = new Handler();
        runnable = new Runnable() {
            public void run() {
               // Toast.makeText(this, "Service is still running", Toast.LENGTH_SHORT).show();

                String url="https://hackerex.pythonanywhere.com/notifications/pullall";//link will be provided
                StringRequest request=new StringRequest(Request.Method.POST,url,new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {
                        Log.d("response",response);
                        //Toast.makeText(context,"Data sent successfully!",Toast.LENGTH_SHORT).show();
                        List<Notification> notificationList=new ArrayList<>();
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            if(jsonObject.getInt("status")==200){
                                JSONArray notifications=jsonObject.getJSONArray("all_notifications");
                                for(int i=0;i<notifications.length();i++){
                                    JSONObject notification=notifications.getJSONObject(i);
                                    notificationList.add(new Notification(notification.getString("notification_id"),notification.getString("notification_type"),notification.getString("notification_head"),notification.getString("notification_body"),notification.getString("notification_push_time"),notification.getString("notification_by")));

                                }
                                for(int i=0;i<notificationList.size();i++)
                                {
                                    if(db.isNewNotification(notificationList.get(i))){
                                   /*     NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
                                        builder.setContentTitle("Culfest 18 "+notificationList.get(i).getNotificationHead());
                                        builder.setSmallIcon(R.drawable.applogo);
                                        builder.setContentText(notificationList.get(i).getNotificationBody());
                                        builder.setAutoCancel(true);
                                        builder.mNumber=1;
                                        Intent resultIntent = new Intent(context,SplashScreenActivity.class);
                                        PendingIntent resultPendingIntent =
                                                PendingIntent.getActivity(
                                                        context,
                                                        0,
                                                        resultIntent,
                                                        PendingIntent.FLAG_UPDATE_CURRENT
                                                );
                                        builder.setContentIntent(resultPendingIntent);

                                        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                                        notificationManager.notify(i,builder.build()); */
                                        Log.d("notification saved","notification saved");
                                    }
                                    else{
                                        Log.d("notification","notification not new");
                                    }


                                }
                                //add sqlite here DB(notificationList)
                                                      }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },new Response.ErrorListener(){

                    @Override
                    public void onErrorResponse(VolleyError error) {
                      //  Toast.makeText(context,"Something went wrong try again!",Toast.LENGTH_SHORT).show();
                        Log.d("error",error.toString());
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> params=new HashMap<>();
                        final SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("LoginCredentials", Context.MODE_PRIVATE);
                        params.put("requestType","POST");
                        params.put("token",sharedPreferences.getString("Madhukar",getResources().getString(R.string.madhukar)));
                        params.put("culfest",getResources().getString(R.string.madhukar));
                        Log.d("params",params.toString());
                        return params;
                    }
                };
                MyVolleyClass.getInstance(context).addToRequestQueue(request);
                Log.d("volley Request","request done");
                handler.postDelayed(runnable,600000);
            }
        };

        handler.postDelayed(runnable, 0);
    }

    @Override
    public void onDestroy() {
        /* IF YOU WANT THIS SERVICE KILLED WITH THE APP THEN UNCOMMENT THE FOLLOWING LINE */
        //Toast.makeText(this, "Service stopped", Toast.LENGTH_LONG).show();
        handler.removeCallbacks(runnable);
       super.onDestroy();
    }

    @Override
    public void onStart(Intent intent, int startid) {
        //Toast.makeText(this, "Service started by user.", Toast.LENGTH_SHORT).show();
    }
}

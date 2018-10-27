package jamshedpur.nit.culfest.com.culfest17;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jamshedpur.nit.culfest.com.culfest17.Util.Notification;
import jamshedpur.nit.culfest.com.culfest17.Volley.MyVolleyClass;

/**
 * Created by Dell on 2/7/2018.
 */

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("firebasetoken", "Refreshed token: " + refreshedToken);
        SharedPreferences sharedPreferences=this.getSharedPreferences("LoginCredentials", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Madhukar",refreshedToken);
        editor.commit();
        sendToken(refreshedToken);
    }
    //elcP1aA8ZX4:APA91bH3z8v27K2t5O57gsMMmFGMrHTFTC5HoRf49EX4iZWbKBTWzj1i-txtLSbRezpT5DHkA1tJZNj89SVXcm9IrCv0KnotKuX6Wkl53n9vAW3d8W8QCCQ6n1SihrKeJnQAjeaQ5F_3
    private void sendToken(String refreshedToken){
        final SharedPreferences sharedPreferences=this.getSharedPreferences("LoginCredentials", Context.MODE_PRIVATE);
        String url="https://hackerex.pythonanywhere.com/detailsfortoken";//link will be provided
        StringRequest request=new StringRequest(Request.Method.POST,url,new Response.Listener<String>(){

            @Override
            public void onResponse(String response) {

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
                params.put("requestType","POST");
                params.put("token",sharedPreferences.getString("Madhukar",getResources().getString(R.string.madhukar)));
                params.put("email",sharedPreferences.getString("userEmail",""));
                params.put("culfest",getResources().getString(R.string.madhukar));
                Log.d("params",params.toString());
                return params;
            }
        };
        MyVolleyClass.getInstance(this).addToRequestQueue(request);
    }
}

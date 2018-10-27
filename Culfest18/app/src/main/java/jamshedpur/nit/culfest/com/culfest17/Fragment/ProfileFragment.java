package jamshedpur.nit.culfest.com.culfest17.Fragment;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

import jamshedpur.nit.culfest.com.culfest17.R;
import jamshedpur.nit.culfest.com.culfest17.Volley.MyVolleyClass;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    Context con;
    TextView permanentIdTextView,tempId,name,institute,branch,email,contact,status,instituteId;
    ImageView profilePaidImage,profileUnpaidImage;
    TextView dueAmount,props;
    ProgressDialog progressDialog;
    public ProfileFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        progressDialog=new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setCancelable(false);
        View layout = inflater.inflate(R.layout.fragment_profile, container, false);
        permanentIdTextView = (TextView)layout.findViewById(R.id.profile_permanent_id);
        tempId =(TextView)layout.findViewById(R.id.profile_temp_id);
        name = (TextView)layout.findViewById(R.id.profile_name);
        institute = (TextView)layout.findViewById(R.id.profile_institute);
        instituteId = (TextView)layout.findViewById(R.id.profile_institute_id);
        branch = (TextView)layout.findViewById(R.id.profile_branch);
        email = (TextView)layout.findViewById(R.id.profile_email);
        contact = (TextView)layout.findViewById(R.id.profile_phone);
        status = (TextView)layout.findViewById(R.id.profile_status);
        props=(TextView)layout.findViewById(R.id.profile_props);
        dueAmount=(TextView)layout.findViewById(R.id.profile_amount_due);
        profilePaidImage=(ImageView)layout.findViewById(R.id.profile_paid_image);
        profileUnpaidImage=(ImageView)layout.findViewById(R.id.profile_unpaid_image);
        //if we don't have permanent id then call
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("LoginCredentials", Context.MODE_PRIVATE);
        String userEmail=sharedPreferences.getString("userEmail","");
        String permanentId=sharedPreferences.getString("permanentId","");
        String temporaryId=sharedPreferences.getString("tempId","");
        email.setText(sharedPreferences.getString("userEmail",""));
        name.setText(sharedPreferences.getString("userName",""));
        tempId.setText(sharedPreferences.getString("tempId",""));
        instituteId.setText(sharedPreferences.getString("userId",""));
        institute.setText(sharedPreferences.getString("userInstitute",""));
        contact.setText(sharedPreferences.getString("userPhone",""));
        branch.setText(sharedPreferences.getString("userBranch",""));
        dueAmount.setText(String.valueOf(sharedPreferences.getInt("participantToPay",0)));
        if(sharedPreferences.getBoolean("participantRecievedProps",false)){
            props.setText("Taken");
        }
        else{
            props.setText("Not Taken");
        }
        if(sharedPreferences.getBoolean("paymentStatus",false)==false){
            status.setText("Not Paid");
        }
        else{
            status.setText("Paid");
        }
        //if(permanentId.equals("")){
            getPermanentId(temporaryId,userEmail);


       /* else{
            status.setText("Paid");
            //
            tempId.setVisibility(View.INVISIBLE);
            permanentIdTextView.setVisibility(View.VISIBLE);
            permanentIdTextView.setText(permanentId);
            profilePaidImage.setVisibility(View.VISIBLE);
            profileUnpaidImage.setVisibility(View.INVISIBLE);
        }*/

        return layout;
    }
    public void getPermanentId(final String tempIdValue, final String email){
        progressDialog.show();
        String url="https://hackerex.pythonanywhere.com/provideid";//link will be provided for requesting permanent id
        StringRequest request=new StringRequest(Request.Method.POST,url,new Response.Listener<String>(){

            @Override
            public void onResponse(String response) {
                Log.d("response",response);
                //Toast.makeText(getActivity(),"Data sent successfully!",Toast.LENGTH_SHORT).show();
                //will get permanent id from server
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    int stats=jsonObject.getInt("status");
                    String statusText=jsonObject.getString("status_text");
                    if(stats==210){
                        progressDialog.dismiss();
                        Toast.makeText(getActivity(),"Payment is not done!",Toast.LENGTH_SHORT).show();
                        permanentIdTextView.setText("NA");
                        profileUnpaidImage.setVisibility(View.VISIBLE);
                        profilePaidImage.setVisibility(View.INVISIBLE);
                        permanentIdTextView.setVisibility(View.INVISIBLE);
                        tempId.setVisibility(View.VISIBLE);
                        //payment not done
                    }
                    if(stats==202){
                        //payment done
                        progressDialog.dismiss();
                        JSONObject object=jsonObject.getJSONObject("culfest_response_data");
                        String permanenId=jsonObject.getString("culfest_id");
                        int participantToRepay=object.getInt("participants_to_repay");
                        boolean participantRecievedProps=object.getBoolean("participants_received_props");
                        String instituteName=object.getString("participants_institute");
                        String branchName=object.getString("participants_branch");
                        String contactNumber=object.getString("participants_contact");
                        String collegeId=object.getString("participants_college_id");
                        institute.setText(instituteName);
                        branch.setText(branchName);
                        instituteId.setText(collegeId);
                        contact.setText(contactNumber);
                        permanentIdTextView.setText(permanenId);
                        status.setText("Paid");
                        tempId.setVisibility(View.INVISIBLE);
                        permanentIdTextView.setVisibility(View.VISIBLE);
                        profilePaidImage.setVisibility(View.VISIBLE);
                        profileUnpaidImage.setVisibility(View.INVISIBLE);
                        //todo settext two more data
                        SharedPreferences sharedPreferences=getActivity().getSharedPreferences("LoginCredentials", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("permanentId",permanenId);
                        editor.putBoolean("paymentStatus",true);
                        editor.putBoolean("participantRecievedProps",participantRecievedProps);
                        editor.putInt("participantToPay",participantToRepay);
                        editor.putString("userPhone",contactNumber);
                        editor.putString("userInstitute",instituteName);
                        editor.putString("userBranch",branchName);
                        editor.putString("userId",collegeId);
                        editor.commit();
                        dueAmount.setText(String.valueOf(sharedPreferences.getInt("participantToPay",0)));
                        if(sharedPreferences.getBoolean("participantRecievedProps",false)){
                            props.setText("Taken");
                        }
                        else{
                            props.setText("Not Taken");
                        }

                    }
                    else if(stats==206){
                        progressDialog.dismiss();
                        JSONObject object=jsonObject.getJSONObject("culfest_response_data");
                        String permanenId=object.getString("culfest_id");
                        JSONObject obj=object.getJSONObject("participant_data");
                        int participantToRepay=obj.getInt("participants_to_repay");
                        boolean participantRecievedProps=obj.getBoolean("participants_received_props");
                        String instituteName=obj.getString("participants_institute");
                        String branchName=obj.getString("participants_branch");
                        String contactNumber=obj.getString("participants_contact");
                        String collegeId=obj.getString("participants_college_id");
                        institute.setText(instituteName);
                        branch.setText(branchName);
                        instituteId.setText(collegeId);
                        contact.setText(contactNumber);
                        permanentIdTextView.setText(permanenId);
                        status.setText("Paid");
                        tempId.setVisibility(View.INVISIBLE);
                        permanentIdTextView.setVisibility(View.VISIBLE);
                        profilePaidImage.setVisibility(View.VISIBLE);
                        profileUnpaidImage.setVisibility(View.INVISIBLE);
                        //todo settext two more data
                        SharedPreferences sharedPreferences=getActivity().getSharedPreferences("LoginCredentials", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("permanentId",permanenId);
                        editor.putBoolean("paymentStatus",true);
                        editor.putBoolean("participantRecievedProps",participantRecievedProps);
                        editor.putInt("participantToPay",participantToRepay);
                        editor.putString("userPhone",contactNumber);
                        editor.putString("userInstitute",instituteName);
                        editor.putString("userBranch",branchName);
                        editor.putString("userId",collegeId);
                        editor.commit();
                        dueAmount.setText(String.valueOf(sharedPreferences.getInt("participantToPay",0)));
                        if(sharedPreferences.getBoolean("participantRecievedProps",false)){
                            props.setText("Taken");
                        }
                        else{
                            props.setText("Not Taken");
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(getActivity(),"Something went wrong try again!",Toast.LENGTH_SHORT).show();
                Log.d("error",error.toString());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                //params.put("email",email);
                final SharedPreferences sharedPreferences=getActivity().getSharedPreferences("LoginCredentials", Context.MODE_PRIVATE);
                params.put("culfest_id",tempIdValue);
                params.put("token",sharedPreferences.getString("Madhukar",getResources().getString(R.string.madhukar)));
                params.put("culfest",getResources().getString(R.string.madhukar));
                params.put("email",sharedPreferences.getString("userEmail",""));
                Log.d("params",params.toString());
                return params;
            }
        };
        MyVolleyClass.getInstance(getActivity()).addToRequestQueue(request);
    }
}

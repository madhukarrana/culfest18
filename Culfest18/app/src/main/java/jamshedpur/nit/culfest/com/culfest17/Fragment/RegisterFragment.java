package jamshedpur.nit.culfest.com.culfest17.Fragment;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import jamshedpur.nit.culfest.com.culfest17.Adapter.DrawerAdapter;
import jamshedpur.nit.culfest.com.culfest17.R;
import jamshedpur.nit.culfest.com.culfest17.Volley.MyVolleyClass;
import jamshedpur.nit.culfest.com.culfest17.Widget.DrawerRow;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {


    Button registerButton;
    public static final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );
   // Context con;
    EditText userName,userId,userBranch,userInstitute,userPhone,userEmail;
    public RegisterFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View layout = inflater.inflate(R.layout.fragment_register, container, false);
        registerButton=(Button)layout.findViewById(R.id.registerButton);
        userName = (EditText)layout.findViewById(R.id.userName);
        userId = (EditText)layout.findViewById(R.id.userId);
        userBranch = (EditText)layout.findViewById(R.id.userBranch);
        userInstitute = (EditText)layout.findViewById(R.id.userInstitute);
        userPhone = (EditText)layout.findViewById(R.id.userPhone);
        userEmail = (EditText)layout.findViewById(R.id.userEmail);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // send data to server

                // and wait for acknowledgement if the registration is successful then
                final ProgressDialog progressDialog=new ProgressDialog(getActivity());
                progressDialog.setMessage("Please Wait...");
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.setCancelable(false);
                final String name=userName.getText().toString().trim();
                final String email=userEmail.getText().toString().trim();
                final String collegeId=userId.getText().toString().trim();
                final String branch=userBranch.getText().toString().trim();
                final String phone=userPhone.getText().toString().trim();
                final String institute=userInstitute.getText().toString().trim();
                String url="https://hackerex.pythonanywhere.com/save_view";//link will be provided
                if(name.equals("")||email.equals("")||collegeId.equals("")||branch.equals("")||phone.equals("")||institute.equals("")){
                    Toast.makeText(getActivity(),"Fill every information!",Toast.LENGTH_SHORT).show();
                }
                else if(!isValidEmail(email)){
                    Toast.makeText(getActivity(),"Fill proper Email Address!",Toast.LENGTH_SHORT).show();
                }
                else if(phone.length()<10||phone.length()>=13){
                    Toast.makeText(getActivity(), "Fill proper Phone No!", Toast.LENGTH_SHORT).show();
                }
                else{
                    progressDialog.show();

                    StringRequest request=new StringRequest(Request.Method.POST,url,new Response.Listener<String>(){

                        @Override
                        public void onResponse(String response) {
                            Log.d("response",response);
                            progressDialog.dismiss();
                            //Toast.makeText(getActivity(),"Data sent successfully!",Toast.LENGTH_SHORT).show();
                            //{"status": 200, "status_text": "Saved Without Error", "participants_name": "ghjjabb", "participants_temporary_registration_id": "TEMCUL0002", "participants_email": "gy@gmail.com", "participants_payement_received": false, "participants_to_repay": 0, "participants_received_props": false}
                            //JSONArray responseJsonArray ;
                            String email,name,tempId,institute,branch,contact,userid;
                            boolean paymentStatus,participantsRecievedProps;
                            int status,participantToPay;
                            try {
                                JSONObject jsonObject=new JSONObject(response);
                                //JSONObject jsonObject ;



                                    try {
                                        //JSONObject jsonObject=responseJsonArray.getJSONObject(i);
                                        status=jsonObject.getInt("status");
                                        if(status==206){
                                            Toast.makeText(getActivity(),"Registration Successful!",Toast.LENGTH_SHORT).show();
                                            name=jsonObject.getString("participants_name");
                                            email=jsonObject.getString("participants_email");
                                            tempId=jsonObject.getString("participants_temporary_registration_id");
                                            paymentStatus=jsonObject.getBoolean("participants_payement_received");
                                            participantsRecievedProps=jsonObject.getBoolean("participants_received_props");
                                            participantToPay=jsonObject.getInt("participants_to_repay");
                                            institute=jsonObject.getString("participants_institute");
                                            branch=jsonObject.getString("participants_branch");
                                            userid=jsonObject.getString("participants_college_id");
                                            contact=jsonObject.getString("participants_contact");
                                            updateSharedPreference(name,email,tempId,paymentStatus,participantsRecievedProps,participantToPay,userid,institute,branch,contact);
                                            //intent to go back to profile layout

                                        }
                                        else if(status==200){
                                            JSONObject culfestResponseData=jsonObject.getJSONObject("culfest_response_data");
                                            JSONObject participantData=culfestResponseData.getJSONObject("participant_data");
                                            name=participantData.getString("participants_name");
                                            email=participantData.getString("participants_email");
                                            tempId=participantData.getString("participants_temporary_registration_id");
                                            paymentStatus=participantData.getBoolean("participants_payement_received");
                                            participantsRecievedProps=participantData.getBoolean("participants_received_props");
                                            participantToPay=participantData.getInt("participants_to_repay");
                                            institute=participantData.getString("participants_institute");
                                            branch=participantData.getString("participants_branch");
                                            contact=participantData.getString("participants_contact");
                                            userid=participantData.getString("participants_college_id");
                                            updateSharedPreference(name,email,tempId,paymentStatus,participantsRecievedProps,participantToPay,userid,institute,branch,contact);
                                            //intent to go back to profile layout
                                        }
                                        else if(status==202){
                                            JSONObject culfestResponseData=jsonObject.getJSONObject("culfest_response_data");
                                            JSONObject participantData=culfestResponseData.getJSONObject("participant_data");
                                            name=participantData.getString("participants_name");
                                            email=participantData.getString("participants_email");
                                            tempId=participantData.getString("participants_temporary_registration_id");
                                            paymentStatus=participantData.getBoolean("participants_payement_received");
                                            participantsRecievedProps=participantData.getBoolean("participants_received_props");
                                            participantToPay=participantData.getInt("participants_to_repay");
                                            institute=participantData.getString("participants_institute");
                                            branch=participantData.getString("participants_branch");
                                            contact=participantData.getString("participants_contact");
                                            userid=participantData.getString("participants_college_id");
                                            updateSharedPreference(name,email,tempId,paymentStatus,participantsRecievedProps,participantToPay,userid,institute,branch,contact);
                                            //intent to go back to profile layout
                                        }
                                        else{
                                            Toast.makeText(getActivity(),"Something went wrong try again!",Toast.LENGTH_LONG).show();

                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }



                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    },new Response.ErrorListener(){

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getActivity(),"Something went wrong try again!",Toast.LENGTH_SHORT).show();
                            Log.d("error",error.toString());
                            progressDialog.dismiss();
                        }
                    }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> params=new HashMap<>();
                            final SharedPreferences sharedPreferences=getActivity().getSharedPreferences("LoginCredentials", Context.MODE_PRIVATE);
                            params.put("email",email.toLowerCase());
                            params.put("phone",phone);
                            params.put("collegeId",collegeId);
                            params.put("branch",branch);
                            params.put("institute",institute);
                            params.put("name",name);
                            params.put("token",sharedPreferences.getString("Madhukar",getResources().getString(R.string.madhukar)));
                            params.put("culfest",getResources().getString(R.string.madhukar));
                            Log.d("params",params.toString());
                            return params;
                        }
                    };
                    MyVolleyClass.getInstance(getActivity()).addToRequestQueue(request);
                }
                //updateSharedPreference();


            }
        });

     return layout;
    }

    private void updateSharedPreference(String name, String email, String tempId, boolean paymentStatus, boolean participantsRecievedProps, int participantToPay, String collegeId, String institute, String branch, String phone)
    {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("LoginCredentials", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("IsRegistered",true);
        editor.putString("userName",name);
        editor.putString("userEmail",email);
        editor.putString("tempId",tempId);
        editor.putString("permanentId","");
        editor.putBoolean("paymentStatus",paymentStatus);
        editor.putBoolean("participantRecievedProps",participantsRecievedProps);
        editor.putInt("participantToPay",participantToPay);
        editor.putString("userPhone",phone);
        editor.putString("userInstitute",institute);
        editor.putString("userBranch",branch);
        editor.putString("userId",collegeId);
        editor.commit();

        //Toast.makeText(getActivity(), "Data saved", Toast.LENGTH_SHORT).show();
        // update data of navigation drawer
        NavigationDrawerFragment.drawerData.remove(11);
        NavigationDrawerFragment.drawerData.add(new DrawerRow(R.drawable.ic_account_circle_black_24dp,"Profile"));
        NavigationDrawerFragment.drawerAdapter.notifyDataSetChanged();

        // Redirect to profile
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.registration_layout,new ProfileFragment());
        fragmentTransaction.commit();

    }
    public final static boolean isValidEmail(String email) {
        return EMAIL_ADDRESS_PATTERN.matcher(email).matches();
    }

}

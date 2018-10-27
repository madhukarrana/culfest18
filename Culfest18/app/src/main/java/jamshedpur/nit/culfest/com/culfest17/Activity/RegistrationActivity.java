package jamshedpur.nit.culfest.com.culfest17.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import jamshedpur.nit.culfest.com.culfest17.Fragment.ProfileFragment;
import jamshedpur.nit.culfest.com.culfest17.Fragment.RegisterFragment;
import jamshedpur.nit.culfest.com.culfest17.R;

public class RegistrationActivity extends AppCompatActivity {


    private boolean isRegistered;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);



        SharedPreferences sharedPreferences= getApplication().getSharedPreferences("LoginCredentials", Context.MODE_PRIVATE);
        isRegistered = sharedPreferences.getBoolean("IsRegistered",false);
        if(isRegistered==false)
        {
            // call register fragment
            RegisterFragment registerFragment = new RegisterFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.registration_layout,registerFragment).commit();

        }
        else
        {
            // call profile fragment
            ProfileFragment profileFragment = new ProfileFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.registration_layout,profileFragment).commit();

        }
    }
}

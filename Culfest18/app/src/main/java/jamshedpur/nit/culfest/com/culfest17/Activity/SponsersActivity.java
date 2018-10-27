package jamshedpur.nit.culfest.com.culfest17.Activity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import jamshedpur.nit.culfest.com.culfest17.R;
public class SponsersActivity extends AppCompatActivity {
   private Toolbar toolbar;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsers);
        toolbar = (Toolbar) findViewById(R.id.sponsers_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Sponsors");
        toolbar.setTitleTextColor(Color.WHITE);

        t1=(TextView)findViewById(R.id.title_sponser);
        t2=(TextView)findViewById(R.id.cosponsor);
        t3=(TextView)findViewById(R.id.poweredby);
        t4=(TextView)findViewById(R.id.beverege);
        t5=(TextView)findViewById(R.id.csr_partner);
        t6=(TextView)findViewById(R.id.education);
        t7=(TextView)findViewById(R.id.workshop);
        t8=(TextView)findViewById(R.id.beauty_partner);
        t9=(TextView)findViewById(R.id.entertainment_part);
        t10=(TextView)findViewById(R.id.food_partner);
        t11=(TextView)findViewById(R.id.online_partner);
        t12=(TextView)findViewById(R.id.event_partner);
        t13=(TextView)findViewById(R.id.gift_partner);
        t14=(TextView)findViewById(R.id.media_partner);
        t15=(TextView)findViewById(R.id.previous_sponsor);

        Typeface typeface1 = Typeface.createFromAsset(this.getAssets(), "fonts/Gravity-Bold.otf");
        t1.setTypeface(typeface1);
        t2.setTypeface(typeface1);
        t3.setTypeface(typeface1);
        t4.setTypeface(typeface1);
        t5.setTypeface(typeface1);
        t6.setTypeface(typeface1);
        t7.setTypeface(typeface1);
        t8.setTypeface(typeface1);
        t9.setTypeface(typeface1);
        t10.setTypeface(typeface1);
        t11.setTypeface(typeface1);
        t12.setTypeface(typeface1);
        t13.setTypeface(typeface1);
        t14.setTypeface(typeface1);
        t15.setTypeface(typeface1);

    }
}

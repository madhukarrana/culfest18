package jamshedpur.nit.culfest.com.culfest17.Activity;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import jamshedpur.nit.culfest.com.culfest17.Fragment.NavigationDrawerFragment;
import jamshedpur.nit.culfest.com.culfest17.NotificationService.CulfestServiceForNotification;

import jamshedpur.nit.culfest.com.culfest17.R;
import jamshedpur.nit.culfest.com.culfest17.Util.SocialConnections;
import jamshedpur.nit.culfest.com.culfest17.Volley.MyVolleyClass;

public class MainActivity extends AppCompatActivity {

    TextView homePageWriteUp1, homePageWriteUp2, homePageWriteUp3;
    String writeup1 = "Culfest -  A name having its own euphoric charm, spotless aura and still Arcadian in its root . All combining to give rousing atmosphere amidst the tranquil and nebulous Indian spring time emanating vivacity of NIT Jamshedpur in India having blissful heart's welcoming talents across the culture rich nation.";
    String writeup2 = "Culfest - The cultural fest of NIT Jamshedpur scheduled from 16-18th of February is one of the highly anticipated events of the year .The virtue of it resonates with the idea of creativity, enthusiasm ,ambition ,passion and an ocean of unfettered energy waiting to exude.Year after year ,it has gone bigger and better in terms of skill, participation and grandeur and this year it seems to take a step ahead witnessing a footfall of over 6000 since the last few editions it is consistently attracting a demographic diversity that few can boast of, Culfest remains an unrivalled platform for showcasing the energy and creativity of the youth.";
    String writeup3 = "This year culfest promises to be bigger and better ,set to encompass a wider array of glamorous events and reach new heights of hysteria ! With the theme being Tryst With Telly watch us bring the best of everything arround the globe under the 350 acre campus !!! Show if you proclaim yourself as a TV enthusiast ...then gear up.! This one's just for you!!";

    private static MainActivity mainActivity;
    private Toolbar toolbar;
    private NavigationDrawerFragment drawerFragment;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawableToggle;

    private GestureDetector mGestureDetector;
    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private int[] images;
    private int NO_OF_SLIDES;
    private int currentPage;
    private TextView homeTitle;
    Timer timer;
    String anthemUrl,madhukar;
    FloatingActionMenu rightLowerMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();
        SharedPreferences sharedPreferences = getApplication().getSharedPreferences("LoginCredentials", Context.MODE_PRIVATE);
        anthemUrl=sharedPreferences.getString("CulfestAnthemUrl","null");
        //sendFirstRequest(sharedPreferences.getString("userEmail",""),sharedPreferences.getString("Madhukar",""));
        //anthemUrlShow=sharedPreferences.getString("CulfestAnthemFlag",null);
        //madhukar=sharedPreferences.getString("Madhukar","36cc25b39078dd2326c887c0919c7bf5e6241fe0");
        if(anthemUrl.equals("null"))
            setAnthemUrl();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 3000);



        startService(new Intent(this, CulfestServiceForNotification.class));

    /*    BroadcastReceiver br = new MyReceiver(this);
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_TIME_TICK);
        registerReceiver(br, filter); */

    }




    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(Color.TRANSPARENT);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        setHomePageWriteUp();

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        drawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_appdrawer);
        drawerFragment.setUp((DrawerLayout) findViewById(R.id.drawerLayout), toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        dotsLayout = (LinearLayout) findViewById(R.id.indiCatorLayout);
        NO_OF_SLIDES = 4;
        images = new int[]{
                R.drawable.image4,
                R.drawable.image1,
                R.drawable.image2,
                R.drawable.image3,
                R.drawable.image4,
                R.drawable.image1
        };

        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                viewPager.setPressed(true);
                return false;
            }
        });


        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
        viewPager.setCurrentItem(1);
        currentPage = 1;
        addBottomDots(0);

        // set social buttons
        DrawSocialButton();

    }

    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {


        @Override
        public void onPageSelected(int position) {
            currentPage = position;
            if (position > 0 && position < (images.length - 1))
                addBottomDots(position - 1);

         /*   final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //Do something after 100ms
                    viewPager.setCurrentItem((currentPage+1), true);
                }
            },3000);
          */
        }

        @Override
        public void onPageScrolled(int position, float positionOfffset, int positionOffsetPixel) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

            if (currentPage == 0) {
                viewPager.setCurrentItem(images.length - 2, false);
            } else if (currentPage == images.length - 1) {
                viewPager.setCurrentItem(1, false);
            }
        }
    };


    public void setHomePageWriteUp() {


        homePageWriteUp1 = (TextView) findViewById(R.id.homePageWriteUpText1);
        homePageWriteUp2 = (TextView) findViewById(R.id.homePageWriteUpText2);
        homePageWriteUp3 = (TextView) findViewById(R.id.homePageWriteUpText3);
        homeTitle = (TextView) findViewById(R.id.home_title);
        Typeface typeface1 = Typeface.createFromAsset(getAssets(), "fonts/Gravity-Regular.otf");
       Typeface typeface2 =  Typeface.createFromAsset(getAssets(), "fonts/BebasNeue.otf");

        SpannableString ss1 = new SpannableString(writeup1);
        ss1.setSpan(new RelativeSizeSpan(1.3f), 0, 10, 0);
        ss1.setSpan(new StyleSpan(Typeface.BOLD), 0, 10, 0);
        homePageWriteUp1.setText(ss1);
        homePageWriteUp2.setText(writeup2);
        homePageWriteUp3.setText(writeup3);
        homeTitle.setTypeface(typeface2);
        homePageWriteUp1.setTypeface(typeface1);
        homePageWriteUp2.setTypeface(typeface1);
        homePageWriteUp3.setTypeface(typeface1);

    }


    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(R.layout.imagelayout, container, false);
            ImageView imageView = (ImageView) view.findViewById(R.id.image);
            imageView.setImageResource(images[position]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);

            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }

    private void addBottomDots(int currentPage) {
        dots = new TextView[NO_OF_SLIDES];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }

    private int getItem() {
        return viewPager.getCurrentItem();
    }

    private void DrawSocialButton() {
        final ImageView fabIconNew = new ImageView(this);
        fabIconNew.setImageDrawable(getResources().getDrawable(R.drawable.culfest_icon));
        final FloatingActionButton rightLowerButton = new FloatingActionButton.Builder(this)
                .setContentView(fabIconNew)
                .build();
        int blueSubActionButtonSize = getResources().getDimensionPixelSize(R.dimen.blue_sub_action_button_size);
        SubActionButton.Builder rLSubBuilder = new SubActionButton.Builder(this);
        FrameLayout.LayoutParams blueParams = new FrameLayout.LayoutParams(blueSubActionButtonSize, blueSubActionButtonSize);
        rLSubBuilder.setLayoutParams(blueParams);

        ImageView rlIcon1 = new ImageView(this);
        ImageView rlIcon2 = new ImageView(this);
        ImageView rlIcon3 = new ImageView(this);
        ImageView rlIcon4 = new ImageView(this);
        ImageView rlIcon5 = new ImageView(this);

        rlIcon1.setImageDrawable(getResources().getDrawable(R.drawable.ic_facebook)); //facebook
        rlIcon2.setImageDrawable(getResources().getDrawable(R.drawable.ic_youtube));  //youtube
        rlIcon3.setImageDrawable(getResources().getDrawable(R.drawable.website));  //twitter
        rlIcon4.setImageDrawable(getResources().getDrawable(R.drawable.ic_instagram));  //instagram
        rlIcon5.setImageDrawable(getResources().getDrawable(R.drawable.wink_music));
        // Build the menu with default options: light theme, 90 degrees, 72dp radius.
        // Set 4 default SubActionButtons
               rightLowerMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(rLSubBuilder.setContentView(rlIcon1).build())
                .addSubActionView(rLSubBuilder.setContentView(rlIcon2).build())
                .addSubActionView(rLSubBuilder.setContentView(rlIcon3).build())
                .addSubActionView(rLSubBuilder.setContentView(rlIcon4).build())
                       .addSubActionView(rLSubBuilder.setContentView(rlIcon5).build())
                       .setRadius(getResources().getDimensionPixelSize(R.dimen.floating_action_menu_radius))
                .attachTo(rightLowerButton)
                .build();

        // Listen menu open and close events to animate the button content view
        rightLowerMenu.setStateChangeListener(new FloatingActionMenu.MenuStateChangeListener() {
            @Override
            public void onMenuOpened(FloatingActionMenu menu) {
                // Rotate the icon of rightLowerButton 45 degrees clockwise
                fabIconNew.setRotation(0);
                PropertyValuesHolder pvhR = PropertyValuesHolder.ofFloat(View.ROTATION, 45);
                ObjectAnimator animation = ObjectAnimator.ofPropertyValuesHolder(fabIconNew, pvhR);
                animation.start();
            }

            @Override
            public void onMenuClosed(FloatingActionMenu menu) {
                // Rotate the icon of rightLowerButton 45 degrees counter-clockwise
                fabIconNew.setRotation(45);
                PropertyValuesHolder pvhR = PropertyValuesHolder.ofFloat(View.ROTATION, 0);
                ObjectAnimator animation = ObjectAnimator.ofPropertyValuesHolder(fabIconNew, pvhR);
                animation.start();
            }
        });
        rlIcon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //facebook
                Intent facebookIntent = SocialConnections.getOpenFacebookIntent(MainActivity.this);
                rightLowerMenu.close(true);
                startActivity(facebookIntent);

            }
        });
        rlIcon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //youtube
                Intent youtubeIntent = SocialConnections.getOpenYouTubeIntent(MainActivity.this);
                rightLowerMenu.close(true);
                startActivity(youtubeIntent);

            }
        });
        rlIcon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // twitter
                Intent websiteIntent = SocialConnections.getOpenWebsiteIntent(MainActivity.this);
                rightLowerMenu.close(true);
                startActivity(websiteIntent);

            }
        });
        rlIcon4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // instagram
                Intent instagramIntent = SocialConnections.getOpenInstagramIntent(MainActivity.this);
                rightLowerMenu.close(true);
                startActivity(instagramIntent);

            }
        });
        rlIcon5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // wink music
                if (!anthemUrl.equals("null")){
                    Intent wynkIntent = SocialConnections.getAnthemIntent(MainActivity.this, anthemUrl);
                    rightLowerMenu.close(true);
                    startActivity(wynkIntent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Will be updated soon", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public class MyTimerTask extends TimerTask {
        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (!viewPager.isPressed() && !drawerFragment.isOpen()) {
                        if (viewPager.getCurrentItem() != images.length - 1) {
                            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                        } else {
                            viewPager.setCurrentItem(0);
                        }
                    } else {
                        viewPager.setPressed(false);
                    }
                }
            });
        }
    }


    @Override
    public void onBackPressed() {

        if (this.mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.mDrawerLayout.closeDrawer(GravityCompat.START);
        }

        else {
                if (rightLowerMenu.isOpen()) {
                        rightLowerMenu.close(true);
                }
                else {

                          new AlertDialog.Builder(this)
                            .setMessage("Are you sure you want to exit?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    MainActivity.this.finish();
                                }
                            })
                            .setNegativeButton("No", null)
                            .show();


                 }
         }
    }
    private void setAnthemUrl(){
        String url="http://hackerex.pythonanywhere.com/getculfestanthem";
        StringRequest request=new StringRequest(Request.Method.POST,url,new Response.Listener<String>(){

            @Override
            public void onResponse(String response) {
                Log.d("response",response);
                try {
                    JSONObject object=new JSONObject(response);
                    int status;
                    status=object.getInt("status");
                    if(status==200){
                        anthemUrl=object.getString("anthem_url");
                        //anthemUrlShow=object.getString("anthem_url_show");
                        SharedPreferences sharedPreferences = getApplication().getSharedPreferences("LoginCredentials", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("CulfestAnthemUrl",anthemUrl);
                        //editor.putString("CulfestAnthemFlag",anthemUrlShow);
                        editor.commit();

                        //todo set intent here because url is achieved in background process
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //Toast.makeText(getApplicationContext(),"Data sent successfully! "+anthemUrl,Toast.LENGTH_SHORT).show();
            }
        },new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(getApplicationContext(),"Something went wrong try again!",Toast.LENGTH_SHORT).show();
                Log.d("error",error.toString());
            }
        });
        MyVolleyClass.getInstance(getApplicationContext()).addToRequestQueue(request);
    }
}
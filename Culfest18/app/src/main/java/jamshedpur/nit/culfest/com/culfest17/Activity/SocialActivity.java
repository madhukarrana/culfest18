package jamshedpur.nit.culfest.com.culfest17.Activity;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import jamshedpur.nit.culfest.com.culfest17.R;
public class SocialActivity extends AppCompatActivity {

    TextView socialWriteUp;
    TextView socialTitle;
    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private int[] images;
    private int NO_OF_SLIDES;
    private int currentPage;
    String writeUp = "We are not here to judge you. Every smoker knows what smoking does to his/her body. The problem is how much of a thought they give to it. Just had an exhaustive work-day? A cigarette will help, a joint might be heaven. It's exactly when it seeps into \"I'm stressed and could kind of go for a puff\" that is when you need to start worrying, other wise it becomes a go-to for stress, worry, hunger, boredom, eating, everything. We are not telling you what to do or what habits to acquire or stay away from. It is when they slowly drip into your life, they become a danger.\n\n" +
            "For details, contact\n" +
            "Poras Thavnani: 8797361542\nSundeep Kss: 8142127781\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social);
        Typeface typeface1 = Typeface.createFromAsset(getAssets(), "fonts/Gravity-Regular.otf");
        Typeface typeface2 =  Typeface.createFromAsset(getAssets(), "fonts/BebasNeue.otf");


        socialWriteUp =(TextView)findViewById(R.id.socialPageWriteUp);
        socialTitle = (TextView)findViewById(R.id.social_title);
        socialTitle.setTypeface(typeface2);
        socialWriteUp.setText(writeUp);
        socialWriteUp.setTypeface(typeface1);
        viewPager = (ViewPager) findViewById(R.id.socialViewPager);
        dotsLayout = (LinearLayout) findViewById(R.id.socialIndiCatorLayout);
        NO_OF_SLIDES = 4;
        images = new int[]{
                R.drawable.social_image4,
                R.drawable.social_image1,
                R.drawable.social_image2,
                R.drawable.social_image3,
                R.drawable.social_image4,
                R.drawable.social_image1
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


    }

    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {


        @Override
        public void onPageSelected(int position) {
            currentPage = position;
            if (position > 0 && position < (images.length - 1))
                addBottomDots(position - 1);

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


}

package jamshedpur.nit.culfest.com.culfest17.Activity;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import jamshedpur.nit.culfest.com.culfest17.Fragment.FirstDayFragment;
import jamshedpur.nit.culfest.com.culfest17.Fragment.Informals;
import jamshedpur.nit.culfest.com.culfest17.Fragment.SecondDayFragment;
import jamshedpur.nit.culfest.com.culfest17.Fragment.ThirdDayFragment;
import jamshedpur.nit.culfest.com.culfest17.Fragment.Workshops;
import jamshedpur.nit.culfest.com.culfest17.R;

public class ScheduleActivity extends AppCompatActivity {

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        toolbar = (Toolbar) findViewById(R.id.schedule_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Schedule");
        toolbar.setTitleTextColor(Color.WHITE);



        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),ScheduleActivity.this);
        viewPager.setAdapter(pagerAdapter);

        TabLayout tabLayout=(TabLayout)findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        for(int i=0;i< tabLayout.getTabCount();i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(pagerAdapter.getTabView(i));
        }

    }
    class PagerAdapter extends FragmentPagerAdapter {

        String tabTitles[] = new String[]{"Day 1", "Day 2", "Day 3","Informals","Workshops"};
        Context context;

        public PagerAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;

        }

        @Override
        public int getCount() {

            return tabTitles.length;
        }

        @Override
        public Fragment getItem(int position) {



            switch (position) {
                case 0:
                    return new FirstDayFragment();
                case 1:
                    return new SecondDayFragment();
                case 2:
                    return new ThirdDayFragment();
                case 3:
                    return new Informals();
                case 4:
                    return new Workshops();

            }
            return null;
        }


        @Override
        public CharSequence getPageTitle(int position) {

            return tabTitles[position];
        }

        public View getTabView(int position) {

            View tab = LayoutInflater.from(ScheduleActivity.this).inflate(R.layout.custom_tab, null);
            TextView tv = (TextView) tab.findViewById(R.id.custom_text);
            tv.setText(tabTitles[position]);
            return tab;


        }

    }
}

package jamshedpur.nit.culfest.com.culfest17.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.load.model.Headers;
import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;
//import com.github.florent37.materialviewpager.sample.fragment.RecyclerViewFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import jamshedpur.nit.culfest.com.culfest17.Fragment.RecyclerViewFragment;
import jamshedpur.nit.culfest.com.culfest17.R;

public class EventActivity extends AppCompatActivity {

    @BindView(R.id.materialViewPager)
    MaterialViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        setTitle("");
        ButterKnife.bind(this);

        final Toolbar toolbar = mViewPager.getToolbar();
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        mViewPager.getToolbar().setNavigationIcon(null);
        mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position % 9) {
                    /*case 0:
                        return RecyclerViewFragment.newInstance();
                    case 1:
                        return RecyclerViewFragment.newInstance();
                    case 2:
                        return RecyclerViewFragment.newInstance();
                    case 3:
                        return RecyclerViewFragment.newInstance();
                    case 4:
                        return RecyclerViewFragment.newInstance();
                    case 5:
                        return RecyclerViewFragment.newInstance();
                    case 6:
                        return RecyclerViewFragment.newInstance();
                    case 7:
                        return RecyclerViewFragment.newInstance();
                    case 8:
                        return RecyclerViewFragment.newInstance();
*/                   default:
                        return RecyclerViewFragment.newInstance(position);
                }
            }

            @Override
            public int getCount() {
                return 9;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position % 9) {
                    case 0:
                        return "MEGA EVENTS";
                    case 1:
                        return "DANCE";
                    case 2:
                        return "DRAMATICS";
                    case 3:
                        return "QUIZZING";
                    case 4:
                        return "LITERARY";
                    case 5:
                        return "VOCALS";
                    case 6:
                        return "FINE ARTS";
                    case 7:
                        return "PHOCUS";
                    case 8:
                        return "INFORMALS";
                }
                return "";
            }
        });

        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page) {
                    case 0:
                        return HeaderDesign.fromColorResAndDrawable(
                                R.color.green,
                                getResources().getDrawable(R.drawable.fashion));
                    case 1:
                        return HeaderDesign.fromColorResAndDrawable(
                            R.color.blue,
                           getResources().getDrawable(R.drawable.dance));
                    case 2:
                        return HeaderDesign.fromColorResAndDrawable(
                            R.color.cyan,
                            getResources().getDrawable(R.drawable.dramatics));
                    case 3:
                        return HeaderDesign.fromColorResAndDrawable(
                            R.color.red,
                            getResources().getDrawable(R.drawable.quiz));  //
                    case 4:
                        return HeaderDesign.fromColorResAndDrawable(
                                R.color.pink,
                                getResources().getDrawable(R.drawable.lds));  //
                    case 5:
                        return HeaderDesign.fromColorResAndDrawable(
                                R.color.lime,
                                getResources().getDrawable(R.drawable.vocals));

                    case 6:
                        return HeaderDesign.fromColorResAndDrawable(
                                R.color.green,
                                getResources().getDrawable(R.drawable.faces));
                    case 7:
                        return HeaderDesign.fromColorResAndDrawable(
                                R.color.blue,
                                getResources().getDrawable(R.drawable.phocus));

                    case 8:
                        return HeaderDesign.fromColorResAndDrawable(
                                R.color.red,
                                getResources().getDrawable(R.drawable.informals)); //
                }

                //execute others actions if needed (ex : modify your header logo)

                return null;
            }
        });

        mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());

        final View logo = findViewById(R.id.logo_white);
        if (logo != null) {
            logo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mViewPager.notifyHeaderChanged();
                    Toast.makeText(getApplicationContext(), "Yes, the title is clickable", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}

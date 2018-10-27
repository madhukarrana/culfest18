package jamshedpur.nit.culfest.com.culfest17.Fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import jamshedpur.nit.culfest.com.culfest17.Adapter.DrawerAdapter;
import jamshedpur.nit.culfest.com.culfest17.R;
import jamshedpur.nit.culfest.com.culfest17.Widget.DrawerRow;

/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationDrawerFragment extends Fragment {

    private ActionBarDrawerToggle mDrawerToggel;
    private DrawerLayout mDrawerLayout;
    private RecyclerView recyclerView;
    public static DrawerAdapter drawerAdapter;
    private ImageButton backButton;
    public Context activityRef;
    public static List<DrawerRow> drawerData;

    private Boolean isDrawerOpen=false;
    public NavigationDrawerFragment() {
        // Required empty public constructor
    }

    public Boolean isOpen()
    {
        return isDrawerOpen;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.drawerList);
        mDrawerLayout = (DrawerLayout) getActivity().findViewById(R.id.drawerLayout);
        backButton = (ImageButton) layout.findViewById(R.id.navDrawerBackButton);
        //     fb_text=layout.findViewById(R.id.fb_text)

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.closeDrawers();
            }
        });

         activityRef = getActivity();

         return layout;
    }

    public List<DrawerRow> getRowData() {
        List<DrawerRow> drawerData = new ArrayList<>();
        int[] icons = {R.drawable.ic_home_black_24dp,R.drawable.ic_event_black_24dp,
                R.drawable.ic_schedule_black_24dp,R.drawable.ic_notifications_black_24dp,R.drawable.ic_location_on_black_24dp,
                R.drawable.celebrity,R.drawable.ic_people_black_24dp,R.drawable.sponser,R.drawable.ic_code_black_24dp,R.drawable.ic_live_help_black_24dp,R.drawable.nosmoking};
        String[] titles = {"Home","Events","Schedule","Notification","Institute Map","Pronite","Core Team","Sponsors","Developers","FAQ","Social Cause"};
    // ev,sc,noti,map,celeb,core,spo,dev,faq
         for (int i = 0; i < titles.length; i++) {
            DrawerRow drawerRow = new DrawerRow(icons[i], titles[i]);
            drawerData.add(drawerRow);
        }

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("LoginCredentials",Context.MODE_PRIVATE);
        boolean deflt = false;
        boolean isRegistered;

        isRegistered = sharedPreferences.getBoolean("IsRegistered",deflt);
        if(isRegistered==false)
        {
            DrawerRow drawerRow = new DrawerRow(R.drawable.ic_person_add_black_24dp,"Register");
            drawerData.add(drawerRow);
        }
        else
        {
            DrawerRow drawerRow = new DrawerRow(R.drawable.ic_account_circle_black_24dp,"Profile");
            drawerData.add(drawerRow);
        }

        return drawerData;
    }

    public void setUp(DrawerLayout drawerLayout, Toolbar toolbar) {

        final Toolbar mToolbar = toolbar;
        mDrawerLayout = drawerLayout;

        initNavDrawer();


        mDrawerToggel = new ActionBarDrawerToggle(getActivity(), mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                isDrawerOpen=true;
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                isDrawerOpen=false;
                super.onDrawerClosed(drawerView);
            }

         /*   @Override
         Too make that Dim Effect but this mess up the animation
            public void onDrawerSlide(View drawerView, float slideOffset) {
                if(slideOffset<0.6){
                mToolbar.setAlpha(1-slideOffset);
            }} */
        };
        mDrawerLayout.addDrawerListener(mDrawerToggel);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggel.syncState();
            }
        });

    }

    private void initNavDrawer() {
        drawerData=getRowData();
        drawerAdapter = new DrawerAdapter(mDrawerLayout, getActivity(),drawerData);
        recyclerView.setAdapter(drawerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }


}

package jamshedpur.nit.culfest.com.culfest17.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import jamshedpur.nit.culfest.com.culfest17.Adapter.NotificationAdapter;
import jamshedpur.nit.culfest.com.culfest17.Model.TitleCreater;
import jamshedpur.nit.culfest.com.culfest17.Model.TitleChild;
import jamshedpur.nit.culfest.com.culfest17.Model.TitleParent;

import java.util.ArrayList;
import java.util.List;

import jamshedpur.nit.culfest.com.culfest17.Adapter.NotificationAdapter;
import jamshedpur.nit.culfest.com.culfest17.R;
import jamshedpur.nit.culfest.com.culfest17.SQLite.DatabaseLRHandler;
import jamshedpur.nit.culfest.com.culfest17.Util.Notification;

public class NotificationActivity extends AppCompatActivity {

    private Toolbar toolbar;
    RecyclerView recyclerView;
    List<Notification> notificationList;
    DatabaseLRHandler db;
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ((NotificationAdapter)recyclerView.getAdapter()).onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        toolbar = (Toolbar)findViewById(R.id.notification_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Notification");
        toolbar.setTitleTextColor(Color.WHITE);

        notificationList=new ArrayList<>();
        db=new DatabaseLRHandler(getApplicationContext());
        notificationList=db.getNotifications();


        recyclerView=(RecyclerView) findViewById(R.id.myRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        NotificationAdapter adapter=new NotificationAdapter(this,initData(notificationList));
        adapter.setParentClickableViewAnimationDefaultDuration();
        adapter.setParentAndIconExpandOnClick(true);
        recyclerView.setAdapter(adapter);



    }


    private List<ParentObject> initData(List<Notification> notificationList) {
        TitleCreater titlecreator=TitleCreater.get(this);
        List<TitleParent> titles=titlecreator.getAll();
        List<ParentObject> parentobject= new ArrayList<>();
        int i=0;
        for(TitleParent title:titles)
        {
            List<Object> childList =new ArrayList<>();
            childList.add(new TitleChild(notificationList.get(i).getNotificationBody()));
            title.setChildObjectList(childList);
            parentobject.add(title);
            i++;
        }
        return parentobject;

    }

}

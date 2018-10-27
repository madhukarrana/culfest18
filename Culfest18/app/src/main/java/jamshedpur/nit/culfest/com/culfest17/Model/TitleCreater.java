package jamshedpur.nit.culfest.com.culfest17.Model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import jamshedpur.nit.culfest.com.culfest17.SQLite.DatabaseLRHandler;
import jamshedpur.nit.culfest.com.culfest17.Util.Notification;

/**
 * Created by gourav on 1/2/2018.
 */

public class TitleCreater {
    static TitleCreater _titlecreater;
    List<TitleParent> _titleParents;
    DatabaseLRHandler db;
    public TitleCreater(Context context) {
        List<Notification> notifications=new ArrayList<>();
        db=new DatabaseLRHandler(context);
        notifications=db.getNotifications();
        _titleParents=new ArrayList<>();
        for(int i=0;i<notifications.size();i++){
            _titleParents.add(new TitleParent(notifications.get(i).getNotificationHead()));
        }
       /* _titleParents.add(new TitleParent("What is Culfest"));
        _titleParents.add(new TitleParent("What is Culfest"));
        _titleParents.add(new TitleParent("What is Culfest"));
        _titleParents.add(new TitleParent("What is Culfest"));
        _titleParents.add(new TitleParent("What is Culfest"));
        _titleParents.add(new TitleParent("What is Culfest"));
        _titleParents.add(new TitleParent("What is Culfest"));
        _titleParents.add(new TitleParent("What is Culfest"));
        _titleParents.add(new TitleParent("What is Culfest"));
        _titleParents.add(new TitleParent("What is Culfest"));
        _titleParents.add(new TitleParent("What is Culfest"));
        _titleParents.add(new TitleParent("What is Culfest"));*/
    }

    public static TitleCreater get(Context context)
    {
        if(_titlecreater==null)
            _titlecreater=new TitleCreater(context);
        return _titlecreater;
    }

    public List<TitleParent> getAll() {
        return _titleParents;
    }
}

package jamshedpur.nit.culfest.com.culfest17.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import jamshedpur.nit.culfest.com.culfest17.Util.Notification;

/**
 * Created by admin on 24-01-2018.
 */

public class DatabaseLRHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Culfest2018";
    Context c;
    private final String TABLE_NOTIFICATION="notificationTable";
    private final String NOTIFICATION_ID="notificationId",NOTIFICATION_TYPE="notificationType",NOTIFICATION_HEAD="notificationHead",NOTIFICATION_BODY="notificationBody",NOTIFICATION_TIME="notificationTime",NOTIFICATION_BY="notificationBy";

    public DatabaseLRHandler(Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
        c=context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_NOTIFICATION_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_NOTIFICATION+"("+NOTIFICATION_ID+" TEXT NOT NULL,"+NOTIFICATION_HEAD+" TEXT NOT NULL,"+NOTIFICATION_BODY+" TEXT NOT NULL,"+NOTIFICATION_TYPE+" TEXT NOT NULL,"+NOTIFICATION_TIME+" TEXT NOT NULL,"+NOTIFICATION_BY+" TEXT NOT NULL)";
        db.execSQL(CREATE_NOTIFICATION_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NOTIFICATION);
        onCreate(db);
    }

    public boolean isNewNotification(Notification notification) {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.query(TABLE_NOTIFICATION, new String[]{NOTIFICATION_ID},NOTIFICATION_ID+"=?", new String[]{notification.getNotificationId()},null,null,null);
        if(cursor.moveToNext()){
            return false;
        }
        else{
            ContentValues cv=new ContentValues();
            cv.put(NOTIFICATION_ID,notification.getNotificationId());
            cv.put(NOTIFICATION_BODY,notification.getNotificationBody());
            cv.put(NOTIFICATION_BY,notification.getNotificationBy());
            cv.put(NOTIFICATION_HEAD,notification.getNotificationHead());
            cv.put(NOTIFICATION_TYPE,notification.getNotificationType());
            cv.put(NOTIFICATION_TIME,notification.getNotificationTime());
            db.insert(TABLE_NOTIFICATION,null,cv);
            db.close();
            return true;
        }
    }

    public List<Notification> getNotifications() {
        List<Notification> notifications=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(TABLE_NOTIFICATION,new String[]{NOTIFICATION_ID,NOTIFICATION_BODY,NOTIFICATION_BY,NOTIFICATION_TIME,NOTIFICATION_TYPE,NOTIFICATION_HEAD},null,null,null,null,null);
        while(cursor.moveToNext()){
            notifications.add(0,new Notification(cursor.getString(cursor.getColumnIndex(NOTIFICATION_ID)),cursor.getString(cursor.getColumnIndex(NOTIFICATION_TYPE)),cursor.getString(cursor.getColumnIndex(NOTIFICATION_HEAD)),cursor.getString(cursor.getColumnIndex(NOTIFICATION_BODY)),cursor.getString(cursor.getColumnIndex(NOTIFICATION_TIME)),cursor.getString(cursor.getColumnIndex(NOTIFICATION_BY))));
        }
        return notifications;
    }
}

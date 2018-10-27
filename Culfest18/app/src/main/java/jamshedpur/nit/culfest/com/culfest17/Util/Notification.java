package jamshedpur.nit.culfest.com.culfest17.Util;

/**
 * Created by admin on 24-01-2018.
 */

public class Notification {
    public String notificationId,notificationType,notificationHead,notificationBody,notificationDate,notificationBy,notificationTime;
    public Notification(String notificationId,String notificationType,String notificationHead,String notificationBody,String notificationTime,String notificationBy){
        this.notificationBody=notificationBody;
        this.notificationBy=notificationBy;
        //this.notificationDate=notificationDate;
        this.notificationHead=notificationHead;
        this.notificationId=notificationId;
        this.notificationTime=notificationTime;
        this.notificationType=notificationType;
    }
    public String getNotificationId(){
        return notificationId;
    }
    public String getNotificationType(){
        return notificationType;
    }
    public String getNotificationHead(){
        return notificationHead;
    }
    public String getNotificationBody(){
        return notificationBody;
    }

    public String getNotificationBy(){
        return notificationBy;
    }
    public String getNotificationTime(){
        return notificationTime;
    }
}

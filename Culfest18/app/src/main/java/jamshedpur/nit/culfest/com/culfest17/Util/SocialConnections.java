package jamshedpur.nit.culfest.com.culfest17.Util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by Dell on 1/13/2018.
 */

public class SocialConnections {

    public static Intent getOpenFacebookIntent(Context context) {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("fb://page/260118660758335"));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/utk.nitjsr"));
        }
    }


    public static Intent getOpenWebsiteIntent(Context context) {

        try {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.culfest.co.in"));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.culfest.co.in"));
        }
    }

    public static Intent getAnthemIntent(Context context,String url) {

        try {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse(url));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse(url));
        }
    }

    public static Intent getOpenInstagramIntent(Context context) {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.instagram.android", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.instagram.com/_u/culfest.nitjsr"));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.instagram.com/culfest.nitjsr"));
        }
    }

    public static Intent getOpenYouTubeIntent(Context context) {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.google.android.youtube", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.youtube.com/user/CulfestNitJSR"));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.youtube.com/user/CulfestNitJSR")); //catches and opens a url to the desired page
        }
    }

}

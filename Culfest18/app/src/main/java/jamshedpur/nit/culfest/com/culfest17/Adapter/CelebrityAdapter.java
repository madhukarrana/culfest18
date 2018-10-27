package jamshedpur.nit.culfest.com.culfest17.Adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alexvasilkov.android.commons.adapters.ItemsAdapter;
import com.alexvasilkov.android.commons.ui.Views;

import jamshedpur.nit.culfest.com.culfest17.Activity.CelebrityActivity;
import jamshedpur.nit.culfest.com.culfest17.R;
import jamshedpur.nit.culfest.com.culfest17.Util.GlideHelper;
import jamshedpur.nit.culfest.com.culfest17.Util.Celebrity;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

//import static jamshedpur.nit.culfest.com.culfest17.R.id.imageView;
//import static jamshedpur.nit.culfest.com.culfest17.R.id.url;

public class CelebrityAdapter extends ItemsAdapter<Celebrity, CelebrityAdapter.ViewHolder>
        implements View.OnClickListener {
    private CelebrityActivity celebrityActivity;
    Bitmap bmp=null;

    public CelebrityAdapter(CelebrityActivity celebrityActivity, List<Celebrity> celebrityList) {
        this.celebrityActivity=celebrityActivity;
        setItemsList(celebrityList);
    }

    @Override
    protected ViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        final ViewHolder holder = new ViewHolder(parent);
        holder.image.setOnClickListener(this);
        return holder;
    }

    @Override
    protected void onBindHolder(ViewHolder holder, int position) {
        final Celebrity item = getItem(position);

        holder.image.setTag(R.id.list_item_image, item);
       // GlideHelper.loadPaintingImage(holder.image, item);


        new DownloadImageTask(holder.image).execute(item.getImageLink(), String.valueOf(holder.image), String.valueOf(bmp));
        holder.image.setImageBitmap(bmp);
       // holder.image.setImageResource(item.getImageId());
        holder.title.setText(item.getName());
    }



    @Override
    public void onClick(View view) {
        final Celebrity item = (Celebrity) view.getTag(R.id.list_item_image);
        celebrityActivity.openDetails(view,item);

    }

    static class ViewHolder extends ItemsAdapter.ViewHolder {
        final ImageView image;
        final TextView title;

        ViewHolder(ViewGroup parent) {
            super(Views.inflate(parent, R.layout.list_item));
            image = Views.find(itemView, R.id.list_item_image);
            title = Views.find(itemView, R.id.list_item_title);
        }
    }
    private class DownloadImageTask extends AsyncTask<String, ImageView, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            //this.bmImage=(ImageView) urls[1];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}

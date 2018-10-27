package jamshedpur.nit.culfest.com.culfest17.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alexvasilkov.android.commons.texts.SpannableBuilder;
import com.alexvasilkov.android.commons.ui.Views;
import com.alexvasilkov.foldablelayout.UnfoldableView;
import com.alexvasilkov.foldablelayout.shading.GlanceFoldShading;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jamshedpur.nit.culfest.com.culfest17.Adapter.CelebrityAdapter;
import jamshedpur.nit.culfest.com.culfest17.R;
import jamshedpur.nit.culfest.com.culfest17.Util.GlideHelper;
import jamshedpur.nit.culfest.com.culfest17.Util.Celebrity;
import jamshedpur.nit.culfest.com.culfest17.Volley.MyVolleyClass;

public class CelebrityActivity extends AppCompatActivity {
    private View listTouchInterceptor;
    private View detailsLayout;
    private UnfoldableView unfoldableView;
    public static CelebrityAdapter celebrityAdapter;
    public List<Celebrity> celebrityList;
    public ListView listView;
    public static Bitmap bmp=null;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celebrity);

         listView = Views.find(this, R.id.list_view);
        // progressBar=(ProgressBar)findViewById(R.id.progress_bar);
         progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading..."); // Setting Message
      //  progressDialog.setTitle("ProgressDialog"); // Setting Title
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
        progressDialog.show(); // Display Progress Dialog
        //progressDialog.setCancelable(true);
       progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setCancelable(false);
        //Fetch celevrity
        celebrityList=new ArrayList<>();
         getAllPaintings();
       /* celebrityAdapter = new CelebrityAdapter(CelebrityActivity.this,celebrityList);


        listView.setAdapter(celebrityAdapter);
       // FetchCelebrity.addCelebrity(getApplicationContext());
        for(int i=0;i<celebrityList.size();i++){
            Log.d("celebrity data",celebrityList.get(i).getName());
        }
        listTouchInterceptor = Views.find(this, R.id.touch_interceptor_view);
        listTouchInterceptor.setClickable(false);

        detailsLayout = Views.find(this, R.id.details_layout);
        detailsLayout.setVisibility(View.INVISIBLE);

        unfoldableView = Views.find(this, R.id.unfoldable_view);

        Bitmap glance = BitmapFactory.decodeResource(getResources(), R.drawable.unfold_glance);
        unfoldableView.setFoldShading(new GlanceFoldShading(glance));

        unfoldableView.setOnFoldingListener(new UnfoldableView.SimpleFoldingListener() {
            @Override
            public void onUnfolding(UnfoldableView unfoldableView) {
                listTouchInterceptor.setClickable(true);
                detailsLayout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onUnfolded(UnfoldableView unfoldableView) {
                listTouchInterceptor.setClickable(false);
            }

            @Override
            public void onFoldingBack(UnfoldableView unfoldableView) {
                listTouchInterceptor.setClickable(true);
            }

            @Override
            public void onFoldedBack(UnfoldableView unfoldableView) {
                listTouchInterceptor.setClickable(false);
                detailsLayout.setVisibility(View.INVISIBLE);
            }
        });*/
    }



    public  void openDetails(View coverView, Celebrity celebrity) {
        final ImageView image = Views.find(detailsLayout, R.id.details_image);
        final TextView title = Views.find(detailsLayout, R.id.details_title);
        final TextView description = Views.find(detailsLayout, R.id.details_text);

        //GlideHelper.loadPaintingImage(image, celebrity);
        if(bmp==null){
            new DownloadImageTask(image).execute(celebrity.getImageLink(), String.valueOf(image), String.valueOf(bmp));
        }

        image.setImageBitmap(bmp);

       // image.setImageResource(celebrity.getImageId());
        title.setText(celebrity.getName());

        SpannableBuilder builder = new SpannableBuilder(this);
        builder
                .createStyle().setFont(Typeface.DEFAULT_BOLD).setSize(16).apply()
                .append(R.string.date).append(" : ")
                .clearStyle()
                .append(celebrity.getDate()).append("\n")
                .createStyle().setFont(Typeface.DEFAULT_BOLD).apply()
                .append(R.string.time).append(" : ")
                .clearStyle()
                .append(celebrity.getTime()).append("\n")
                .createStyle().setFont(Typeface.DEFAULT_BOLD).apply()
                .append(R.string.venue).append(" : ")
                .clearStyle()
                .append(celebrity.getVenue()).append("\n")
                .createStyle().setFont(Typeface.DEFAULT_BOLD).apply()
                .append(R.string.description).append(" : ")
                .clearStyle()
                .append(celebrity.getDescription());
        description.setText(builder.build());

        unfoldableView.unfold(coverView, detailsLayout);
    }

    @Override
    public void onBackPressed() {

        if ((unfoldableView != null)
                && (unfoldableView.isUnfolded() || unfoldableView.isUnfolding())) {
                unfoldableView.foldBack();
        }
        else
        {
            super.onBackPressed();
        }
       // progressDialog.dismiss();
    }

    private void getAllPaintings() {
         final List<Celebrity> celebrityList1=new ArrayList<>();
        String url="https://hackerex.pythonanywhere.com/pronites";//link will be provided
        StringRequest request=new StringRequest(Request.Method.POST,url,new Response.Listener<String>(){


            @Override
            public void onResponse(String response) {
                Log.d("response",response);
                //Toast.makeText(getApplicationContext(),"Data sent successfully!",Toast.LENGTH_SHORT).show();
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    int stats=jsonObject.getInt("status");
                    if(stats==200){
                        JSONArray responseData=jsonObject.getJSONArray("response_data");
                        boolean locked=true;
                        for(int i=0;i<responseData.length();i++){
                            JSONObject celebrityData=responseData.getJSONObject(i);
                            Log.d("data",celebrityData.getString("celebrity_name"));

                                Celebrity celebrity = new Celebrity(R.drawable.blue,celebrityData.getString("celebrity_name"),celebrityData.getString("celebrity_date"),celebrityData.getString("celebrity_time"),celebrityData.getString("celebrity_venue"),celebrityData.getString("celebrity_description"),celebrityData.getString("celebrity_image_url"));
                                celebrityList1.add(celebrity);
                                locked=false;



                                Log.d("celebrity Data",celebrityList1.get(i).getName());

                        }
                        Log.d("exit","true");
                        //return celebrityList1;
                        celebrityList=celebrityList1;

                            populateList();
                           // progressBar.setVisibility(View.GONE);
                         progressDialog.dismiss();

                           // Toast.makeText(getApplicationContext(),"celebrity locked!",Toast.LENGTH_SHORT).show();

                          //  progressBar.setVisibility(View.GONE);
                            //give dialogue box
                            //showAlertDialog();





                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Something went wrong!",Toast.LENGTH_SHORT).show();
                Log.d("error",error.toString());
                progressDialog.dismiss();
                finish();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("requestType","POST");
                final SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("LoginCredentials", Context.MODE_PRIVATE);
                params.put("culfest",getResources().getString(R.string.madhukar));
                params.put("token",sharedPreferences.getString("Madhukar",getResources().getString(R.string.madhukar)));
                Log.d("params",params.toString());
                return params;
            }
        };
        MyVolleyClass.getInstance(getApplicationContext()).addToRequestQueue(request);

        // if there is new celebrity then retrive data and add it to the list

        //Celebrity celebrity = new Celebrity(R.drawable.blue,"Culfest 18","18 feb","20:30 hrs","Main Stage","qwertyuio","imagelink");
        //CelebrityActivity.celebrityList.add(celebrity);

            Log.d("celebrity data 1","himanshu");

        //CelebrityActivity.celebrityAdapter.setItemsList(celebrityList1);
        //CelebrityActivity.celebrityAdapter.notifyDataSetChanged();

         //return celebrityList1;
    }

    public void showAlertDialog()
    {
       /* new AlertDialog.Builder(this)
                .setMessage("Celebrity is not available")
                .setCancelable(false)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No",null)
                .show();
  */
        Toast.makeText(this,"celebrity not found",Toast.LENGTH_SHORT).show();
    }

    private void populateList(){
        celebrityAdapter = new CelebrityAdapter(CelebrityActivity.this,celebrityList);


        listView.setAdapter(celebrityAdapter);
        for(int i=0;i<celebrityList.size();i++){
            Log.d("celebrity data",celebrityList.get(i).getName());
        }
        listTouchInterceptor = Views.find(this, R.id.touch_interceptor_view);
        listTouchInterceptor.setClickable(false);

        detailsLayout = Views.find(this, R.id.details_layout);
        detailsLayout.setVisibility(View.INVISIBLE);

        unfoldableView = Views.find(this, R.id.unfoldable_view);

        Bitmap glance = BitmapFactory.decodeResource(getResources(), R.drawable.unfold_glance);
        unfoldableView.setFoldShading(new GlanceFoldShading(glance));

        unfoldableView.setOnFoldingListener(new UnfoldableView.SimpleFoldingListener() {
            @Override
            public void onUnfolding(UnfoldableView unfoldableView) {
                listTouchInterceptor.setClickable(true);
                detailsLayout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onUnfolded(UnfoldableView unfoldableView) {
                listTouchInterceptor.setClickable(false);
            }

            @Override
            public void onFoldingBack(UnfoldableView unfoldableView) {
                listTouchInterceptor.setClickable(true);
            }

            @Override
            public void onFoldedBack(UnfoldableView unfoldableView) {
                listTouchInterceptor.setClickable(false);
                detailsLayout.setVisibility(View.INVISIBLE);
            }
        });
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

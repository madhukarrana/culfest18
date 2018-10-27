package jamshedpur.nit.culfest.com.culfest17.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.provider.CalendarContract;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.GregorianCalendar;
import jamshedpur.nit.culfest.com.culfest17.R;

/**
 * Created by skshubhamiitkmr on 11-11-2017.
 */

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.MyViewHolder> {

    private String[] mDataset;
    private String[] place,time;
    private int a,b=0,c=0,d=0,e=0,f=0;
    GregorianCalendar calDate = null;
    private Context context;
    public ScheduleAdapter(String[] myDataset, String[] plac, String[] tim, int a, Context context)
    {
        this.mDataset=myDataset;
        this.place=plac;
        this.time=tim;
        this.a=a;
        this.context=context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,int viewType)
    {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule_item_layout,parent,false);
        MyViewHolder vh=new MyViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position)
    {
        //Typeface typeface1 = Typeface.createFromAsset(context.getAssets(), "fonts/Gravity-Bold.otf");
        Typeface typeface2 = Typeface.createFromAsset(context.getAssets(), "fonts/Gravity-Regular.otf");
        Typeface typeface3 = Typeface.createFromAsset(context.getAssets(), "fonts/Gravity-Light.otf");
        //holder.mTextView.setTypeface(typeface1);
        holder.tv1.setTypeface(typeface2);
        holder.tv2.setTypeface(typeface3);
        holder.mTextView.setText(mDataset[position]);
        holder.tv1.setText(place[position]);
        holder.tv2.setText(time[position]);


        if(a==0)
            b=16;
        else if(a==1)
            b=17;
        else if(a==2)
            b=18;
        else if(a==3)
            holder.iv_image.setVisibility(View.INVISIBLE);
        else if(a==4)
            holder.iv_image.setVisibility(View.INVISIBLE);





        holder.iv_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String[] splits=time[position].split("-");
                String s1=splits[0];
                String s2=splits[1];

                String[] splits1=s1.split(":");
                String[] splits2=s2.split(":");

                c=Integer.parseInt(splits1[0]);
                d=Integer.parseInt(splits1[1]);
                e=Integer.parseInt(splits2[0]);
                f=Integer.parseInt(splits2[1]);


                Calendar beginTime=Calendar.getInstance();
                beginTime.set(2018,1,b,c,d);
                Calendar endTime=Calendar.getInstance();
                endTime.set(2018,1,b,e,f);

                Intent intent =new Intent(Intent.ACTION_INSERT)
                        .setData(CalendarContract.Events.CONTENT_URI)
                        .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,beginTime.getTimeInMillis())
                        .putExtra(CalendarContract.EXTRA_EVENT_END_TIME,endTime.getTimeInMillis())
                        .putExtra(CalendarContract.Events.TITLE,mDataset[position]);

                v.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount()
    {
        return mDataset.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

         CardView mCardView;
         TextView mTextView;
         TextView tv1,tv2;
         ImageView iv_image;

        public MyViewHolder(View v){
            super(v);

           mCardView=(CardView)v.findViewById(R.id.card_view);
           mTextView=(TextView)v.findViewById(R.id.tv_text);
           tv1=(TextView)v.findViewById(R.id.tv1);
           tv2=(TextView)v.findViewById(R.id.tv2);
           iv_image=(ImageView)v.findViewById(R.id.iv_image);

        }

    }

}

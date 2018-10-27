package jamshedpur.nit.culfest.com.culfest17.Adapter;

import android.content.Context;
import android.content.Intent;

import android.graphics.Typeface;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import jamshedpur.nit.culfest.com.culfest17.Activity.CelebrityActivity;
import jamshedpur.nit.culfest.com.culfest17.Activity.CoreTeamActivity;
import jamshedpur.nit.culfest.com.culfest17.Activity.Developer;
import jamshedpur.nit.culfest.com.culfest17.Activity.EventActivity;
//import jamshedpur.nit.culfest.com.culfest17.Activity.EventsActivity;
import jamshedpur.nit.culfest.com.culfest17.Activity.FAQActivity;
import jamshedpur.nit.culfest.com.culfest17.Activity.MapLocationActivity;
import jamshedpur.nit.culfest.com.culfest17.Activity.NotificationActivity;
import jamshedpur.nit.culfest.com.culfest17.Activity.RegistrationActivity;
import jamshedpur.nit.culfest.com.culfest17.Activity.ScheduleActivity;
import jamshedpur.nit.culfest.com.culfest17.Activity.SocialActivity;
import jamshedpur.nit.culfest.com.culfest17.Activity.SponsersActivity;
import jamshedpur.nit.culfest.com.culfest17.Widget.DrawerRow;
import jamshedpur.nit.culfest.com.culfest17.R;

import java.util.Collections;
import java.util.List;


public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.MyViewHolder> {
    private LayoutInflater inflator;
    private List<DrawerRow> rowData = Collections.emptyList();
    private DrawerLayout drawerLayout;
    private Context context;

    public DrawerAdapter(DrawerLayout drawerLayout, Context context, List<DrawerRow> drawerData) {
        inflator = LayoutInflater.from(context);
        rowData = drawerData;
        this.drawerLayout = drawerLayout;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflator.inflate(R.layout.drawer_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

      @Override

      public void onBindViewHolder(MyViewHolder viewHolder, int position) {

        DrawerRow current = rowData.get(position);
          Typeface typeface1 = Typeface.createFromAsset(context.getAssets(), "fonts/Gravity-Bold.otf");
         viewHolder.title.setText(current.title);
         viewHolder.title.setTypeface(typeface1);
         viewHolder.icon.setImageResource(current.iconId);
//        viewHolder.itemView.setTag(rowData.get(position).categoryId);
      }

 /*   @Override
    public void onBindViewHolder(MyViewHolder holder, int position, List<Object> payloads) {
        if(!payloads.isEmpty())
        {
            holder.title.setText((String)payloads.get(0));
        }
        else
         super.onBindViewHolder(holder, position, payloads);
    }
    */

    @Override
    public int getItemCount() {
        return rowData.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        ImageView icon;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.listText);
            icon = (ImageView) itemView.findViewById(R.id.listIcon);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
             Intent drawerActivity = null;
             if (getAdapterPosition() == 0) {
            }
             else if (getAdapterPosition() == 1) {
                drawerActivity = new Intent(context, EventActivity.class);
                context.startActivity(drawerActivity);
            }
            else if (getAdapterPosition()==2)
            {
                drawerActivity=new Intent(context,ScheduleActivity.class);
                context.startActivity(drawerActivity);
            }
            else if (getAdapterPosition() == 3) {
                drawerActivity = new Intent(context, NotificationActivity.class);
                context.startActivity(drawerActivity);
            }
            else if (getAdapterPosition() == 4) {
                drawerActivity = new Intent(context,MapLocationActivity.class);
                context.startActivity(drawerActivity);
            }
             else if (getAdapterPosition() == 5) {
                drawerActivity = new Intent(context,CelebrityActivity.class);
                context.startActivity(drawerActivity);
            }
            else if (getAdapterPosition() == 6) {
                drawerActivity = new Intent(context,CoreTeamActivity.class);
                context.startActivity(drawerActivity);
            }
              else if (getAdapterPosition() == 7) {
                drawerActivity = new Intent(context,SponsersActivity.class);
                context.startActivity(drawerActivity);
            }
            else if (getAdapterPosition() == 8) {
                drawerActivity = new Intent(context,Developer.class);
                context.startActivity(drawerActivity);
            }
            else if (getAdapterPosition() == 9) {
                drawerActivity = new Intent(context,FAQActivity.class);
                context.startActivity(drawerActivity);
            }
            else if(getAdapterPosition()==10)
             {
                 drawerActivity = new Intent(context, SocialActivity.class);
                 context.startActivity(drawerActivity);
             }
             else if(getAdapterPosition()==11)
             {
                 drawerActivity = new Intent(context, RegistrationActivity.class);
                 context.startActivity(drawerActivity);
             }

            drawerLayout.closeDrawers();
        }
     }

 }


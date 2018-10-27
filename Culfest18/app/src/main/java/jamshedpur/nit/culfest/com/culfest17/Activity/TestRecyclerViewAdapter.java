package jamshedpur.nit.culfest.com.culfest17.Activity;

import android.app.usage.UsageEvents;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import jamshedpur.nit.culfest.com.culfest17.R;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class TestRecyclerViewAdapter extends RecyclerView.Adapter<TestRecyclerViewAdapter.MyViewHolder> {


     List<String> contents;
    private Context context;
    public TestRecyclerViewAdapter(List<String> contents, Context context) {
        this.context=context;
        this.contents = contents;
    }

    @Override
    public int getItemCount() {
        return contents.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_item_card_small, parent, false);
                return new MyViewHolder(view) {
                };
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
                holder.title.setText(contents.get(position));
               // Typeface typeface1 = Typeface.createFromAsset(context.getAssets(), "fonts/BEBAS.ttf");
              //  holder.title.setTypeface(typeface1);
    }
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView title;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView)view.findViewById(R.id.eventName);
            title.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            Toast.makeText(context,contents.get(getAdapterPosition()),Toast.LENGTH_SHORT).show();
            Intent i=new Intent(context, EventDescriptionActivity.class);
            i.putExtra("EventName",contents.get(getAdapterPosition()));
            context.startActivity(i);
        }
    }
}
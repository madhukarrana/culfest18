package jamshedpur.nit.culfest.com.culfest17.Adapter;

/**
 * Created by aditya314 on 12/30/2017.
 */

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import jamshedpur.nit.culfest.com.culfest17.Model.DataModel;
import jamshedpur.nit.culfest.com.culfest17.R;

public class FaqItemAdapter extends ArrayAdapter<DataModel> {
    Context context;

    public FaqItemAdapter(Context context, ArrayList<DataModel> users)
    {
        super(context, 0, users);
        this.context =context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.faq_item_layout, parent, false);
        }

        // Get the data item for this position
        DataModel data = getItem(position);

        // Lookup view for data population
        TextView tvQuestion = (TextView) convertView.findViewById(R.id.textViewQuestion);
        TextView tvAnswer = (TextView) convertView.findViewById(R.id.textViewAnswer);
        // Populate the data into the template view using the data object
        Typeface typeface1 = Typeface.createFromAsset(context.getAssets(), "fonts/Gravity-Bold.otf");
        Typeface typeface2 =  Typeface.createFromAsset(context.getAssets(), "fonts/Gravity-Regular.otf");
        tvQuestion.setText(data.getQuestion());
        tvAnswer.setText(data.getAnswer());
        // Return the completed view to render on screen
        return convertView;
    }
}
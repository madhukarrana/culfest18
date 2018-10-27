package jamshedpur.nit.culfest.com.culfest17.Activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import jamshedpur.nit.culfest.com.culfest17.R;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class TestListViewAdapter extends ArrayAdapter<Object> {

    static final int TYPE_HEADER = 0;
    static final int TYPE_CELL = 1;

    public TestListViewAdapter(Context context, List<Object> objects) {
        super(context, 0, objects);
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
                    convertView = LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.tools_list_item_card_small, parent, false);
        }
        return convertView;
    }
}
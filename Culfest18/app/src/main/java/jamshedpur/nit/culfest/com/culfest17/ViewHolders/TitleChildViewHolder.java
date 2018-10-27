package jamshedpur.nit.culfest.com.culfest17.ViewHolders;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import jamshedpur.nit.culfest.com.culfest17.R;

/**
 * Created by gourav on 1/2/2018.
 */

public class TitleChildViewHolder extends ChildViewHolder {
    public TextView option1;
    public TitleChildViewHolder(View itemView) {
        super(itemView);
        option1=(TextView)itemView.findViewById(R.id.childTitle);
    }
}

package jamshedpur.nit.culfest.com.culfest17.ViewHolders;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;
import jamshedpur.nit.culfest.com.culfest17.R;

/**
 * Created by gourav on 1/2/2018.
 */

public class TitleParentViewHolder extends ParentViewHolder {
    public TextView _textview;

    public TitleParentViewHolder(View itemView) {
        super(itemView);
        _textview = (TextView) itemView.findViewById(R.id.parentTitle);


    }
}

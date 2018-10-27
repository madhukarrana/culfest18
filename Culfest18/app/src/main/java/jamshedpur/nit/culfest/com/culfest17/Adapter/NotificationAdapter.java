package jamshedpur.nit.culfest.com.culfest17.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import jamshedpur.nit.culfest.com.culfest17.Model.TitleChild;
import jamshedpur.nit.culfest.com.culfest17.Model.TitleParent;
import jamshedpur.nit.culfest.com.culfest17.R;
import jamshedpur.nit.culfest.com.culfest17.ViewHolders.TitleParentViewHolder;
import jamshedpur.nit.culfest.com.culfest17.ViewHolders.TitleChildViewHolder;

import java.util.List;

/**
 * Created by gourav on 1/2/2018.
 */

public class NotificationAdapter extends ExpandableRecyclerAdapter<TitleParentViewHolder,TitleChildViewHolder> {

    LayoutInflater Inflator;
    Context context;
    public NotificationAdapter(Context context, List<ParentObject> parentItemList) {
        super(context, parentItemList);
        Inflator = LayoutInflater.from(context);
        this.context=context;
    }

    @Override

    public TitleParentViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {
        View view = Inflator.inflate(R.layout.list_parent, viewGroup, false);
        return new TitleParentViewHolder(view);
    }

    @Override
    public TitleChildViewHolder onCreateChildViewHolder(ViewGroup viewGroup) {
        View view = Inflator.inflate(R.layout.list_child, viewGroup, false);
        return new TitleChildViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(TitleParentViewHolder titleParentViewHolder, int i, Object o) {
        TitleParent title=(TitleParent)o;
        titleParentViewHolder._textview.setText(title.getTitle());
        Typeface typeface1 = Typeface.createFromAsset(context.getAssets(), "fonts/Gravity-Bold.otf");
        titleParentViewHolder._textview.setTypeface(typeface1);
    }

    @Override
    public void onBindChildViewHolder(TitleChildViewHolder titleChildViewHolder, int i, Object o) {
        TitleChild title=(TitleChild)o;
        titleChildViewHolder.option1.setText(title.getOption1());
        Typeface typeface1 = Typeface.createFromAsset(context.getAssets(), "fonts/Gravity-Regular.otf");
        titleChildViewHolder.option1.setTypeface(typeface1);
    }
}

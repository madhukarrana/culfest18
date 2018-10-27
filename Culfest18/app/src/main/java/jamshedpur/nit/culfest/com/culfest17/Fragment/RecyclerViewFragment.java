package jamshedpur.nit.culfest.com.culfest17.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;
//import com.github.florent37.materialviewpager.sample.AllEvents;
//import com.github.florent37.materialviewpager.sample.R;
//import com.github.florent37.materialviewpager.sample.TestRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jamshedpur.nit.culfest.com.culfest17.Activity.AllEvents;
import jamshedpur.nit.culfest.com.culfest17.Activity.TestRecyclerViewAdapter;
import jamshedpur.nit.culfest.com.culfest17.R;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class RecyclerViewFragment extends Fragment {

    private static final boolean GRID_LAYOUT = false;
    private static final int ITEM_COUNT = 100;
    private String[] events=new String[100];
    private AllEvents allEvents=new AllEvents();
    public int index;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    public static RecyclerViewFragment newInstance(int pos) {
        RecyclerViewFragment recyclerViewFragment=new RecyclerViewFragment();
        recyclerViewFragment.index=pos;
        return recyclerViewFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recyclerview, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        final List<String> megaEvent = new ArrayList<>();
        events=allEvents.getEvent(index);
        for (int i = 0; i <events.length; ++i) {
            megaEvent.add(events[i]);
        }


        //setup materialviewpager

        if (GRID_LAYOUT) {
            mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        } else {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
        mRecyclerView.setHasFixedSize(true);

        //Use this now
        mRecyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
        mRecyclerView.setAdapter(new TestRecyclerViewAdapter(megaEvent,getActivity()));
    }
}

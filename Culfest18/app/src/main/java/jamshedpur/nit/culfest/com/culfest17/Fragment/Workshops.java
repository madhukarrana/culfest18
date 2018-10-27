package jamshedpur.nit.culfest.com.culfest17.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jamshedpur.nit.culfest.com.culfest17.Adapter.ScheduleAdapter;
import jamshedpur.nit.culfest.com.culfest17.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Workshops extends Fragment {


    public Workshops() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.schedule_fragment, container, false);
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        rv.setHasFixedSize(true);



        ScheduleAdapter adapter = new ScheduleAdapter(new String[]{"How To Pen Your Thoughts","Bollywood Dance","How To Market A Blog","Zumba Fitness","Learn To Make A Tattoo"},
                new String[]{
                        "212","222","212","212","212"},
                new String[]{"2:00-4:00 (Day 1)","3:00-5:00 (Day 1)","10:00-12:00 (Day 2)","9:00-11:00 (Day 3)","12:00-2:00 (Day 3)"},
                4,getActivity()

        );

        rv.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);


        return rootView;

    }

}

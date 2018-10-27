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
public class Informals extends Fragment {


    public Informals() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.schedule_fragment, container, false);
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        rv.setHasFixedSize(true);



        ScheduleAdapter adapter = new ScheduleAdapter(new String[]{"Paper Dance","KBF","Pillow Fight","Big Boss","KBF","Antakshari","Blind Date","LUDO","Make-a-wish","House of Cards","Be the Bean","Henna","Jumble ball"},
                new String[]{
                        "Cse Front Arena","Cse Front Arena","Cse Front Arena","Cse Front Arena","Cse Front Arena","222","Cse Front Arena","Cse Front Arena","Cse Front Arena","Cse Front Arena","Cse Front Arena","Cse Front Arena","Cse Front Arena"},
                new String[]{"1:30 -4:00 (Day 1)","4:00-5:00 (Day 1)","9:00-11:30 (Day 2)","11:30- 12:30 (Day 2)","12:30- 2:00 (Day 2)","3:00 -5:00 (Day 2)","2:00- 4:00 (Day 3)","All 3 days","All 3 days","All 3 days","All 3 days","All 3 days","All 3 days"},
                3,getActivity()

        );

        rv.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);


        return rootView;

    }

}

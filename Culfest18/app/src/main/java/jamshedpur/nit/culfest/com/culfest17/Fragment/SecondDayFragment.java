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
public class SecondDayFragment extends Fragment {


    public SecondDayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.schedule_fragment, container, false);
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        rv.setHasFixedSize(true);


        ScheduleAdapter adapter = new ScheduleAdapter(new String[]{"Halla Bol","Soap Carving","BizTech Quiz","Poetry Slam","Footloose (Finals)","Clay-Doh","English Potpourri","Dancing Duo","Culfest Idol (Finals)","Wit A Story","Jashn-e-India Quiz","Panch Parmeshwar (Pre)","Face Painting","Unplugged","Radiance","Fusion Nite"},
                new String[]{"VSG Arena","312","113","212","TSG","312","113","TSG","VSG Main Stage","212","113","CSE Front Arena","VSG Arena","VSG Main Stage","Pronites Ground","Pronites Ground"},
                new String[]{"9:00-2:00","9:00-11:00","9:00-12:00","10:00-12:00","10:00-12:00","11:00-2:00","12:00-2:00","1:00-4:00","1:303:00","2:00-4:00","2:00-5:00","2:00-5:00","2:00-5:00","3:00-5:00","6:00-7:30","8:00-10:00"},
                1,getActivity());

        rv.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);


        return rootView;

    }

}

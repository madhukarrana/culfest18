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
public class ThirdDayFragment extends Fragment {


    public ThirdDayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.schedule_fragment, container, false);
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        rv.setHasFixedSize(true);



        ScheduleAdapter adapter = new ScheduleAdapter(new String[]{"The Voice (Finals)","SSMQ","Shake on Beat","Poshak","RangManch (Pre + Finals)","Pitch Perfect","Panch Parmeshwar (Finals)","Hindi Potpourri","Finger Painting","Creative Writing","Tryst With Telly Quiz","Roadies Final","Choreo-Night","Bolly Nite",},
                new String[]{
                        "VSG Stage","113","CSE Front Arena","VSG Arena","TSG","VSG Arena","CSE Front Arena","113","312","212","113","VSG Arena","Pronites Ground","Pronites Ground"
                },
                new String[]{"9:00-11:00","9:00-12:00","9:00-11:30","10:00-12:30","11:00-4:00","11:00-2:00","11:30-1:00","12:00-2:00","1:00-:4:00","2:00-4:00","2:00-5:00","2:30-4:30","6:00-7:30","8:00-10:00"},
                2,getActivity()

        );

        rv.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);


        return rootView;

    }

}

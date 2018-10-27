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
public class FirstDayFragment extends Fragment {


    public FirstDayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.schedule_fragment, container, false);
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        rv.setHasFixedSize(true);
        ScheduleAdapter adapter = new ScheduleAdapter(new String[]{"Rangoli","Mono-Acting","Policy Debate","Culfest Idol (Prelims)","Footloose (Prelims)","Shades Gallery Opening","Instant-O-Graphy","48-Hours","Battle Of Bands (Prelims)","Face-Off","JAM","Duets","Triathlon","Mime","SLAMies","The Voice (Prelims)","Battle Of Bands (Finals)","Kavi Sammelan"},
                new String[]{"312","CSE Front Arena","113","VSG Stage","TSG","VSG Arena","222","222","Pronites Ground","CSE Front Arena","113","VSG Main Stage","312","TSG","113","VSG Main Stage","Pronites Ground","Pronites Ground"
                },
                new String[]{"9:00-12:30","9:00-12:00","9:00-12:00","9:00-12:30","9:00-12:00","10:00-11:00","10:00-12:00","10:00-12:00","10:00-4:30","12:00-2:00","12:00-2:00","12:30:2:30","12:30-4:00","1:00-4:00","2:00-4:00","2:30-4:30","5:00-7:00","8:00-10:00"},
                0,getActivity());


        rv.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);


        return rootView;

    }

}

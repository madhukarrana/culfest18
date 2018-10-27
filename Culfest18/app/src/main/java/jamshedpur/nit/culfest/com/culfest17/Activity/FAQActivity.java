package jamshedpur.nit.culfest.com.culfest17.Activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.util.ArrayList;

import jamshedpur.nit.culfest.com.culfest17.Adapter.FaqItemAdapter;
import jamshedpur.nit.culfest.com.culfest17.Model.DataModel;
import jamshedpur.nit.culfest.com.culfest17.R;

public class FAQActivity extends AppCompatActivity {

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        toolbar = (Toolbar) findViewById(R.id.faq_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("FAQ");
        toolbar.setTitleTextColor(Color.WHITE);
        populateUsersList();
    }

    private void populateUsersList() {
        // Construct the data source
        int i;
        ArrayList<DataModel> res = new ArrayList<DataModel>();


        res.add( new DataModel("Question : "+"How one can be the Campus Ambassador of Culfest?","Answer : "+"If you want to represent Culfest in your college and city, it is very simple through Campus Ambassdor Program. Be a part of it and bring more and more participation. Anyone with good communication and managerial skills can apply for this. For more details you may go through our guidelines in the website.\n" +
                "Register yourself at -\n" +
                "" +
                "http://ca.culfest.co.in"));
        res.add( new DataModel("Question : "+"Can people of any age-group attend Culfest?","Answer : "+"No, Only school or college students are allowed."));

        res.add( new DataModel("Question : "+"How do I register online for the  Culfest?","Answer : "+"Go to the Register tab to get your CF number. But offline registration needs to be done in order to participate in the events  "));

        res.add( new DataModel("Question : "+"What is the process of offline registration?","Answer : "+"Registration process will start from 16th February and will be open all the time during the fest except during the time of pronites. You need to show your CF number and pay thr required amount in order to confirm your registration."));
        res.add( new DataModel("Question : "+"What is the registration fee for Culfest?","Answer : "+"Registration fee for the students of NIT Jamshedpur is rupees 200 and for the students of other institutes is rupees 500."));

        res.add( new DataModel("Question : "+"How can I attend the concerts?","Answer : "+"NIT Jamshedpur students need to show their college id cards at the entry and for outsiders,  registration ticket is compulsory."));

        res.add( new DataModel("Question : "+"What type of accommodation will be provided?","Answer : "+"Accommodation will be provided to boys and girls in well secured separate residential complexes on the campus of NIT Jamshedpur."));

        res.add( new DataModel("Question : "+"Does accommodation fee include the food facility as well?","Answer : "+"No. The accommodation charges don’t include food. You need to pay seperately for mess coupons. However, there will be food courts operational during Culfest to cater to the food requirements."));

        res.add( new DataModel("Question : "+"Who can we contact in case of need of help/emergency?","Answer : "+"You can contact coordinators of events or any core team members."));

       // res.add( new DataModel("Question : "+"What all deliverables do we receive after registering?","Answer : "+"Registration fees include exclusive Culfest T-shirts and a kit of very useful and exciting goodies."));
        // Create the adapter to convert the array to views
        FaqItemAdapter adapter = new FaqItemAdapter(this, res);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.my_list_view);
        listView.setAdapter(adapter);
    }

}

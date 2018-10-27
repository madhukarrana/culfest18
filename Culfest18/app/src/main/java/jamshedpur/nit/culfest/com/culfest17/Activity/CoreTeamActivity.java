package jamshedpur.nit.culfest.com.culfest17.Activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import jamshedpur.nit.culfest.com.culfest17.Adapter.CoreTeamDataAdapter;
import jamshedpur.nit.culfest.com.culfest17.R;
import jamshedpur.nit.culfest.com.culfest17.Widget.SectionDataModel;
import jamshedpur.nit.culfest.com.culfest17.Widget.SingleItemModel;


public class CoreTeamActivity extends AppCompatActivity {

    private Toolbar toolbar;


    public int[] a={6,3,1,2,5,2,4,3,4,3,2,5,8};
    public int[] b={0,6,9,10,12,17,19,23,26,30,33,35,40};





    private int[] images= {R.drawable.susheel,R.drawable.nisha,R.drawable.chetan,R.drawable.rajeev,R.drawable.mohit,R.drawable.arun,
            R.drawable.sundeep,R.drawable.karunay, R.drawable.rajiv,
            R.drawable.akhil,
            R.drawable.anket, R.drawable.sneh,
            R.drawable.abishek_core, R.drawable.ambikesh, R.drawable.jayant, R.drawable.pranav, R.drawable.shilpa,
            R.drawable.aadersh, R.drawable.poras,
            R.drawable.amit, R.drawable.anmol, R.drawable.neeraj, R.drawable.sujata,
            R.drawable.akash, R.drawable.avinash, R.drawable.dinesh,
            R.drawable.manjeet, R.drawable.shivam, R.drawable.bibek, R.drawable.sushma,
            R.drawable.ayush_core, R.drawable.himanshu, R.drawable.madhukar,
            R.drawable.ajeet, R.drawable.raashish,
            R.drawable.akshay, R.drawable.avdhesh, R.drawable.goutham, R.drawable.kunal, R.drawable.prathip,
            R.drawable.abhijeet, R.drawable.anjalesh, R.drawable.anurag, R.drawable.kajal, R.drawable.neelam,
            R.drawable.priyanshu, R.drawable.sikha, R.drawable.vivek
    };




    private String[] events={"Convener & Secretaries","Post Holders","Corporate Affairs","Promotion & Social Media","Event Management","Planning","Hospitality","Web Development","Creative & Decoration","App Development","Public Relations","Logistics","Senior Cordinators"};


    private String[] subEvents={"Susheel Krishna","Nisha Sinha","Chetan Umrao","Rajiv Kumar","Mohit Agarwal","Arun Kumar Mishra",
            "Sundeep Kss","Karunay Anand", "Rajiv Ranjan",
            "Akhil Gupta",
            "Anket Ghosh","Sneh Sparsh",
            "Abhishek Nayek","Ambikesh Atul","Jayant Kumar", "Pranav Singh","Shilpa Kumari",
            "Aadersh Agarwal","Poras Thavnani",
            "Amit Singh","Anmol Shivam kaur","Neeraj Kumar Singh", "Sujata Jena",
            "Akash Kumar","Avinash Kumar","Dinesh Adigarla",
            "Manjeet Sinha","Shivam Goyal","Bivek Kumar","Sushma Sree",
            "Ayush Kumar","Himanshu Sharma","Madhukar Rana",
            "Ajeet Kumar","Raashish Prasad",
            "Akshay Mishra","Avdesh Singh","Gautam Singh","Kunal","Prathip Naik",
            "Abhijeet Chatterjee","Anjalesh Aman", "Anurag Rastogi","Kajal","Neelam Topno","Priyanshu Rastogi","Sikha Dwivedi","Vivek Das"};


    private String[] email={"culsec.sc@nitjsr.ac.in","jculsec.ac@nitjsr.ac.in","chetanu371@gmail.com","rajivkumar504@gmail.com","mohitagarwal8851@gmail.com","arun22mis@gmail.com",
            "sundeepkss32@outlook.com","singhkarunay21@gmail.com", "rajiv.vaio@gmail.com",
            "gunturuakhilgupta@gmail.com",
            "anket.ghosh@outlook.com","snehsparsh1996@gmail.com",
            "abhisheknayek008@gmail.com","ambikeshatul@gmail.com","jayantkumar281295@gmail.com","pranavnitjsr2016@gmail.com","shilpa.k.raj0595@gmail.com",
            "adershagarwal@gmail.com", "poras.thovnani@gmail.com",
            "nitamit3@gmail.com","anmolshivamkaur@gmail.com","1995913neerajks@gmail.com","sujatajena69@gmail.com",
            "akashrakshit401@gmail.com", "ak007avisonu@gmail.com","dineshadigarla@gmail.com",
            "sinhamanjeet018@gmail.com","shivamasn17@gmail.com","bivek2211@gmail.com","sushmasree28@gmail.com",
            "abhiayush.kumar19@gmail.com","kakadbest@gmail.com","madhukarrana1997@gmail.com",
            "iamajeetkr9@gmail.com","guptarashish78@gmail.com",
            "aksamilu@gmail.com","avdheshsinghsengar1@gmail.com", "iamgautamkumarsingh@gmail.com","kunalsuccess007@gmail.com","Prathipnaikkunoth@gmail.com",
            "abhijeetchatterjee789@gmail.com","amananjalesh@gmail.com","rastogianurag18@gmail.com","kajalkesharwani01@gmail.com","neelam.topno3@gmail.com","rastogi.fresh88@gmail.com","cadet.shikha29@gmail.com","me.vivek49@gmail.com"};


    private String[] phone={"9470918826","9155130039","9430363326","9570040029","9430166386","8581827829",
            "8142127781","9304253731","7277625030",
            "8986602872",
            "7856858527","9525072067",
            "9931670513","8409418859","7549088075","9472902028","8603807439",
            "7209891533","8797361542",
            "8092563146","8986828016","9453384431","7008333926",
            "8809545792","9304068137","8331917507",
            "8298171267","8092058734","8210982890","8877112069",
            "9661519804","8126769400","9955177725",
            "8578890673","8789040258",
            "8770469650","9471591154","8434121234","9631997429","8185869972",
            "7079910361","8083281656","7320954921","8709034858","8083969915", "9458668721","8299898024","7857032243"};


    private String[] post={"Convener","Joint Cultural Secretary","General Secretary","Joint Secretary","Finance Secretary","Executive Secretary","Spokesperson",
            "Chief coordinator","Inventory Manager","Corporate Affairs","Promotion","Social Media","","","","","","","","","","","","","","",
            "","","","","","","","","","","","","","","","","","","","","","",};







    ArrayList<SectionDataModel> allSampleData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_core_team);

        toolbar = (Toolbar)findViewById(R.id.coreTeam_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Core Team");
        toolbar.setTitleTextColor(Color.WHITE);

        allSampleData = new ArrayList<SectionDataModel>();

        createDummyData();


        RecyclerView my_recycler_view = (RecyclerView) findViewById(R.id.coreTeam_recycler_view);

        my_recycler_view.setHasFixedSize(true);

        CoreTeamDataAdapter adapter = new CoreTeamDataAdapter(this, allSampleData);

        my_recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        my_recycler_view.setAdapter(adapter);

    }
    public void createDummyData() {
        int j=0,k=0;
        for (int i = 0; i <=12; i++) {

            SectionDataModel dm = new SectionDataModel();

            dm.setHeaderTitle(events[i]);

            ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();
            for (j=b[k];j<(a[k]+b[k]); j++) {
                singleItem.add(new SingleItemModel(subEvents[j],images[j],email[j],phone[j],post[j]));

            }

            dm.setAllItemsInSection(singleItem);

            allSampleData.add(dm);
            k++;

        }
    }
}

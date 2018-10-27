package jamshedpur.nit.culfest.com.culfest17.Activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

import java.util.ArrayList;
import java.util.List;

import jamshedpur.nit.culfest.com.culfest17.Adapter.DeveloperAdapter;
import jamshedpur.nit.culfest.com.culfest17.R;

public class Developer extends AppCompatActivity {

    List<Integer> images=new ArrayList<>();
    List<String> names=new ArrayList<>();
    List<String> email=new ArrayList<>();
    List<String> phone=new ArrayList<>();
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);

        toolbar = (Toolbar) findViewById(R.id.developer_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Developers");
        toolbar.setTitleTextColor(Color.WHITE);

        initData();
        HorizontalInfiniteCycleViewPager pager=(HorizontalInfiniteCycleViewPager)findViewById(R.id.horizontal_cycle);
        DeveloperAdapter adapter=new DeveloperAdapter(images,names,email,phone,getBaseContext());
        pager.setAdapter(adapter);

    }
    private void initData() {
        images.add(R.drawable.aayush);names.add("Ayush Kumar");email.add("");phone.add("9661519804");
        images.add(R.drawable.kaka);names.add("Himanshu Sharma");email.add("");phone.add("8126769400");
        images.add(R.drawable.maddy);names.add("Madhukar Rana");email.add("");phone.add("9955177725");
        images.add(R.drawable.abhishek);names.add("Abhishek ");email.add("");phone.add("9031157026");
        images.add(R.drawable.aditya);names.add("Aditya Nihal");email.add("");phone.add("9534291132");
        images.add(R.drawable.manish);names.add("Manish");email.add("");phone.add("8757555614");
        images.add(R.drawable.ravi);names.add("Ravi Prakash");email.add("");phone.add("9771179116");
        images.add(R.drawable.shubham);names.add("Shubham Kumar");email.add("");phone.add("7004691916");
        images.add(R.drawable.gaurav);names.add("Gaurav Sethi ");email.add("");phone.add("7351530721");
        images.add(R.drawable.utkarsh);names.add("Utkarsh Kulshrestha");email.add("");phone.add("9430784173");
        images.add(R.drawable.naman);names.add("Kumar Naman");email.add("");phone.add("8102226243");
        images.add(R.drawable.anirudh);names.add("Anirudh Deep");email.add("");phone.add("8565950269");
    }
}

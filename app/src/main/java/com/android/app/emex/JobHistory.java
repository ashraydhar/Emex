package com.android.app.emex;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import layout.realJobHistory;
import layout.realMissedJobs;


public class JobHistory extends Fragment {


    public JobHistory() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_job_history, container, false);
        final Button btn1 = (Button) rootView.findViewById(R.id.jobHistory);
        final Button btn2 = (Button) rootView.findViewById(R.id.missedJobs);
        final ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.replace2);
        btn1.setBackgroundResource(R.drawable.on);

//       int x = viewPager.getCurrentItem();


        FragmentStatePagerAdapter fragmentStatePagerAdapter = new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if(position == 0){
                    return new realJobHistory();
                }
                return new realMissedJobs();
            }

            @Override
            public int getCount() {
                return 2;
            }
        };

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            btn2.setBackgroundResource(R.drawable.download);
            btn1.setBackgroundResource(R.drawable.on);

            }

        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
                btn1.setBackgroundResource(R.drawable.download);
                btn2.setBackgroundResource(R.drawable.on);
            }

        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if( position ==  0)
                {
                    btn2.setBackgroundResource(R.drawable.download);
                    btn1.setBackgroundResource(R.drawable.on);
                } else{
                    btn1.setBackgroundResource(R.drawable.download);
                    btn2.setBackgroundResource(R.drawable.on);
                }
            }
            public void onPageScrollStateChanged(int state) {

            }
        } );

        viewPager.setAdapter(fragmentStatePagerAdapter);
        return rootView;
}
}


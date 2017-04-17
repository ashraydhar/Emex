package com.android.app.emex;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import layout.RealJobHistory;
import layout.RealMissedJobs;

/**
 * takes care of job history section of Driver.
 */
public class JobHistory extends Fragment {

    /**
     * Required empty public constructor
     */
    public JobHistory() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                            final Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_job_history, container, false);
        final Button btn1 = (Button) rootView.findViewById(R.id.jobHistory);
        final Button btn2 = (Button) rootView.findViewById(R.id.missedJobs);
        final ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.replace2);
        btn1.setBackgroundResource(R.drawable.on);


        FragmentStatePagerAdapter fragmentStatePagerAdapter = new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(final int position) {
                if (position == 0) {
                    return new RealJobHistory();
                }
                return new RealMissedJobs();
            }

            @Override
            public int getCount() {
                return 2;
            }
        };

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                viewPager.setCurrentItem(0);
                btn2.setBackgroundResource(R.drawable.download);
                btn1.setBackgroundResource(R.drawable.on);

            }

        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                viewPager.setCurrentItem(1);
                btn1.setBackgroundResource(R.drawable.download);
                btn2.setBackgroundResource(R.drawable.on);
            }

        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {
                if (position == 0) {
                    btn2.setBackgroundResource(R.drawable.download);
                    btn1.setBackgroundResource(R.drawable.on);
                } else {
                    btn1.setBackgroundResource(R.drawable.download);
                    btn2.setBackgroundResource(R.drawable.on);
                }
            }

            public void onPageScrollStateChanged(final int state) {

            }
        });

        viewPager.setAdapter(fragmentStatePagerAdapter);
        return rootView;
    }
}


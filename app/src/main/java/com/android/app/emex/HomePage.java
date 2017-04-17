package com.android.app.emex;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomePage extends Fragment {

    /**
     * its just a required empty constructor for the fragment HomePage
     */
    public HomePage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                            final Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View rootView = inflater.inflate(R.layout.fragment_home_page, container, false);


        TextView textView = (TextView) rootView.findViewById(R.id.dropMenu);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {


                ImageView obj1 = (ImageView) rootView.findViewById(R.id.imageView3);
                obj1.setVisibility(View.VISIBLE);

                FrameLayout obj2 = (FrameLayout) rootView.findViewById(R.id.frameLayout3);
                obj2.setVisibility(View.VISIBLE);

                FrameLayout obj3 = (FrameLayout) rootView.findViewById(R.id.frameLayout4);
                obj3.setVisibility(View.VISIBLE);

                FrameLayout obj4 = (FrameLayout) rootView.findViewById(R.id.frameLayout5);
                obj4.setVisibility(View.VISIBLE);

                FrameLayout obj5 = (FrameLayout) rootView.findViewById(R.id.frameLayout6);
                obj5.setVisibility(View.VISIBLE);
            }

        });

        TextView text = (TextView) rootView.findViewById(R.id.invisible);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                ImageView obj1 = (ImageView) rootView.findViewById(R.id.imageView3);
                obj1.setVisibility(View.INVISIBLE);

                FrameLayout obj2 = (FrameLayout) rootView.findViewById(R.id.frameLayout3);
                obj2.setVisibility(View.INVISIBLE);

                FrameLayout obj3 = (FrameLayout) rootView.findViewById(R.id.frameLayout4);
                obj3.setVisibility(View.INVISIBLE);

                FrameLayout obj4 = (FrameLayout) rootView.findViewById(R.id.frameLayout5);
                obj4.setVisibility(View.INVISIBLE);

                FrameLayout obj5 = (FrameLayout) rootView.findViewById(R.id.frameLayout6);
                obj5.setVisibility(View.INVISIBLE);
            }
        });
        return rootView;
    }

}

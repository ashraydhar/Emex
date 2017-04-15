package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.app.emex.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class realMissedJobs extends Fragment {


    public realMissedJobs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView4 = inflater.inflate(R.layout.fragment_real_missed_jobs, container, false);

        return rootView4;
    }

}

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
public class RealJobHistory extends Fragment {

    /**
     * displays jobs undertaken by driver.
     */
    public RealJobHistory() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                            final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView3 =  inflater.inflate(R.layout.fragment_real_job_history, container, false);



        return rootView3;


    }



}

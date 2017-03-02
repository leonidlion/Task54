package com.boost.leonid.task54.fragments.host;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.boost.leonid.task54.BackPressedListener;
import com.boost.leonid.task54.R;
import com.boost.leonid.task54.fragments.SimpleFragment;

/**
 * Created by leonid on 28.02.17.
 */

public class SecondHostFragment extends Fragment {
    private static final int LAYOUT = R.layout.fragment_second_host;
    private static final String TAG = "SecondHostFragment";
    private SimpleFragment mSimpleFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(LAYOUT, container, false);

        mSimpleFragment = new SimpleFragment();

        getChildFragmentManager().beginTransaction()
                .add(R.id.fl_second_host, mSimpleFragment, SimpleFragment.class.getCanonicalName())
                .commit();

        return view;
    }

    public boolean onBackPressed(){
        BackPressedListener currentFragment = mSimpleFragment;
        if (currentFragment != null) {
            return currentFragment.onBackPressed();
        }
        return false;
    }

}

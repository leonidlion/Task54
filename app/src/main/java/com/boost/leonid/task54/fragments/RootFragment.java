package com.boost.leonid.task54.fragments;

import android.support.v4.app.Fragment;

import com.boost.leonid.task54.BackPressedImpl;
import com.boost.leonid.task54.BackPressedListener;

/**
 * Created by leonid on 28.02.17.
 */

public class RootFragment extends Fragment implements BackPressedListener {
    @Override
    public boolean onBackPressed() {
        return new BackPressedImpl(this).onBackPressed();
    }
}

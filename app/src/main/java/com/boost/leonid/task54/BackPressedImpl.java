package com.boost.leonid.task54;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by leonid on 28.02.17.
 */

public class BackPressedImpl implements BackPressedListener {
    private Fragment mParentFragment;

    public BackPressedImpl(Fragment fragment){
        mParentFragment = fragment;
    }

    @Override
    public boolean onBackPressed() {
        if (mParentFragment == null) return false;

        int childCount = mParentFragment.getChildFragmentManager().getBackStackEntryCount();

        if (childCount == 0) {
            return false;
        } else {
            FragmentManager childFragmentManager = mParentFragment.getChildFragmentManager();
            BackPressedListener childFragment = (BackPressedListener) childFragmentManager.getFragments().get(0);

            if (!childFragment.onBackPressed()) {
                childFragmentManager.popBackStackImmediate();
            }
            return true;
        }
    }
}

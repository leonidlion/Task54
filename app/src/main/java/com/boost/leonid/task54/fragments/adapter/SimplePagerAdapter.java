package com.boost.leonid.task54.fragments.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;

/**
 * Created by leonid on 28.02.17.
 */

public class SimplePagerAdapter extends PagerAdapter {

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }
}

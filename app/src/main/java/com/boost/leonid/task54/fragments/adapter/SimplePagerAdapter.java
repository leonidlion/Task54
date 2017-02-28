package com.boost.leonid.task54.fragments.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

import com.boost.leonid.task54.fragments.SimpleFragment;

/**
 * Created by leonid on 28.02.17.
 */

public class SimplePagerAdapter extends FragmentPagerAdapter {
    private static final int PAGE_COUNT = 3;

    private SparseArray<Fragment> mSimpleFragment = new SparseArray<>();

    public SimplePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        return new SimpleFragment();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        mSimpleFragment.put(position, fragment);
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        mSimpleFragment.remove(position);
        super.destroyItem(container, position, object);
    }

    public Fragment getSimpleFragments(int position){
        return mSimpleFragment.get(position);
    }
}

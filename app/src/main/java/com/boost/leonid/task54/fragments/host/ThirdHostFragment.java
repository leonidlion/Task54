package com.boost.leonid.task54.fragments.host;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.boost.leonid.task54.R;
import com.boost.leonid.task54.fragments.adapter.SimplePagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by leonid on 28.02.17.
 */

public class ThirdHostFragment extends Fragment {
    private static final int LAYOUT = R.layout.fragment_first_host;
    private SimplePagerAdapter mPagerAdapter;

    @BindView(R.id.vp_first_fragment)
    ViewPager mViewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(LAYOUT, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPagerAdapter = new SimplePagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
    }
}

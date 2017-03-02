package com.boost.leonid.task54.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.boost.leonid.task54.R;

import java.util.Random;

/**
 * Created by leonid on 28.02.17.
 */

public class RandomBgFragment extends RootFragment {
    private Random mRandom = new Random();
    private static final int LAYOUT = R.layout.fragment_random_rgb;
    private static final String KEY_NUMBER = "KEY_NUMBER";

    public RandomBgFragment(){}

    public static RandomBgFragment newInstance(int number) {
        Bundle args = new Bundle();
        args.putInt(KEY_NUMBER, number);
        RandomBgFragment fragment = new RandomBgFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_random_rgb, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        TextView text = (TextView) view.findViewById(R.id.tv_random_fragment);
        if (getArguments() != null){
            text.setText(String.valueOf(getArguments().getInt(KEY_NUMBER)));
        }
        view.setBackgroundColor(Color.argb(255, mRandom.nextInt(256), mRandom.nextInt(256), mRandom.nextInt(256)));
    }
}

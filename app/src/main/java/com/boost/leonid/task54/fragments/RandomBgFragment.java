package com.boost.leonid.task54.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import java.util.Random;

/**
 * Created by leonid on 28.02.17.
 */

public class RandomBgFragment extends SimpleFragment {
    private Random mRandom = new Random();

    public static RandomBgFragment newInstance(int number) {
        Bundle args = new Bundle();
        args.putInt(KEY_DEEP, number);
        RandomBgFragment fragment = new RandomBgFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        if (getArguments() != null){
            mTextView.setText(String.valueOf(getArguments().getInt(KEY_DEEP)));
        }
        view.setBackgroundColor(Color.argb(255, mRandom.nextInt(256), mRandom.nextInt(256), mRandom.nextInt(256)));
    }
}

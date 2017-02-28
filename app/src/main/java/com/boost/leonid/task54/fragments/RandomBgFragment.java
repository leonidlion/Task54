package com.boost.leonid.task54.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.boost.leonid.task54.R;

import java.util.Random;

/**
 * Created by leonid on 28.02.17.
 */

public class RandomBgFragment extends RootFragment {
    private Random mRandom = new Random();
    private static final int LAYOUT = R.layout.fragment_random_rgb;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(LAYOUT, container, false);
        view.setBackgroundColor(Color.argb(
                255,
                mRandom.nextInt(256),
                mRandom.nextInt(256),
                mRandom.nextInt(256)));
        return view;
    }
}

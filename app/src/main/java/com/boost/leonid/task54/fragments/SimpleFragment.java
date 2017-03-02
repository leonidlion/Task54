package com.boost.leonid.task54.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.boost.leonid.task54.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by leonid on 28.02.17.
 */

public class SimpleFragment extends RootFragment {
    private static final int LAYOUT = R.layout.fragment_simple;
    private static final String TAG = "SimpleFragment";

    @BindView(R.id.et_simple)
    EditText mEditText;
    @BindView(R.id.btn_save_simple)
    Button mBtnSave;
    @BindView(R.id.btn_random_simpl)
    Button mBtnRandom;

    @OnClick({R.id.btn_save_simple, R.id.btn_random_simpl})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_save_simple:
                onSaveBtnClick();
                break;
            case R.id.btn_random_simpl:
                onRandomBtnClick();
                break;
        }
    }

    private void onSaveBtnClick() {

    }

    private void onRandomBtnClick() {
        getChildFragmentManager().beginTransaction()
                .replace(R.id.fl_simple, new RandomBgFragment())
                .addToBackStack(null)
                .commit();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(LAYOUT, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}

package com.boost.leonid.task54.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.boost.leonid.task54.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by leonid on 28.02.17.
 */

public class SimpleFragment extends Fragment {
    private static final int LAYOUT = R.layout.fragment_simple;
    private FragmentNavigation mFragmentNavigation;

    protected int mDeepFragment = 0;
    protected static final String KEY_DEEP = "KEY_DEEP";

    @BindView(R.id.et_simple)
    EditText mEditText;
    @BindView(R.id.btn_save_simple)
    Button mBtnSave;
    @BindView(R.id.btn_random_simpl)
    Button mBtnRandom;
    @BindView(R.id.tv_simple)
    TextView mTextView;

    public interface FragmentNavigation {
        void pushFragment(Fragment fragment);
    }

    @OnClick({R.id.btn_save_simple, R.id.btn_random_simpl})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_save_simple:
                break;
            case R.id.btn_random_simpl:
                if (mFragmentNavigation != null) {
                    mFragmentNavigation.pushFragment(RandomBgFragment.newInstance(mDeepFragment + 1));
                }
                break;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null){
            mDeepFragment = args.getInt(KEY_DEEP);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentNavigation){
            mFragmentNavigation = (FragmentNavigation) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(LAYOUT, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}

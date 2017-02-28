package com.boost.leonid.task54;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.boost.leonid.task54.fragments.host.FirstHostFragments;
import com.boost.leonid.task54.fragments.host.SecondHostFragment;
import com.boost.leonid.task54.fragments.host.ThirdHostFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private FirstHostFragments mFirstHostFragments;
    private SecondHostFragment mSecondHostFragment;
    private ThirdHostFragment mThirdHostFragment;

    @BindView(R.id.main_frame)
    FrameLayout mFrameLayout;
    @BindView(R.id.btn_first_fragment)
    Button mFirstBtn;
    @BindView(R.id.btn_second_fragment)
    Button mSecondBtn;
    @BindView(R.id.btn_third_fragment)
    Button mThirdBtn;

    @OnClick({R.id.btn_first_fragment, R.id.btn_second_fragment, R.id.btn_third_fragment})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_first_fragment:
                onFirstClick();
                break;
            case R.id.btn_second_fragment:
                onSecondClick();
                break;
            case R.id.btn_third_fragment:
                onThirdClick();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @Override
    public void onBackPressed() {
        if (mFirstHostFragments != null && !mFirstHostFragments.onBackPressed()){
            super.onBackPressed();
        }
    }

    private void onFirstClick() {
        if (mFirstHostFragments == null)
            mFirstHostFragments = new FirstHostFragments();
        addOrReplaceFragment(mFirstHostFragments);
    }

    private void onSecondClick() {
        if (mSecondHostFragment == null)
            mSecondHostFragment = new SecondHostFragment();
        addOrReplaceFragment(mSecondHostFragment);
    }

    private void onThirdClick() {
        if (mThirdHostFragment == null)
            mThirdHostFragment = new ThirdHostFragment();
        addOrReplaceFragment(mThirdHostFragment);
    }

    private void addOrReplaceFragment(Fragment fragment){
        if (mFrameLayout == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.main_frame, fragment, fragment.getClass().getCanonicalName())
                    .commit();
        }else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_frame, fragment, fragment.getClass().getCanonicalName())
                    .commit();
        }
    }
}

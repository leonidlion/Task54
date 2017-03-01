package com.boost.leonid.task54;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
        hideFragmentIfExists();
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
        if (mFirstHostFragments == null){
            Log.d(TAG, "onFirstClick: new fragment");
            mFirstHostFragments = new FirstHostFragments();
            addFragment(mFirstHostFragments);
        }else {
            showFragment(mFirstHostFragments);
        }
    }

    private void onSecondClick() {
        if (mSecondHostFragment == null){
            Log.d(TAG, "onSecondClick: new fragment");
            mSecondHostFragment = new SecondHostFragment();
            addFragment(mSecondHostFragment);
        }else {
            showFragment(mSecondHostFragment);
        }
    }

    private void onThirdClick() {
        if (mThirdHostFragment == null){
            Log.d(TAG, "onThirdClick: new fragment");
            mThirdHostFragment = new ThirdHostFragment();
            addFragment(mThirdHostFragment);
        }else {
            showFragment(mThirdHostFragment);
        }
    }

    private void addFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_frame, fragment)
                .commit();
    }

    private void hideFragmentIfExists(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (mFirstHostFragments != null){
            transaction.hide(mFirstHostFragments);
        }
        if (mSecondHostFragment != null){
            transaction.hide(mSecondHostFragment);
        }
        if (mThirdHostFragment != null){
            transaction.hide(mThirdHostFragment);
        }
        transaction.commit();
    }

    private void showFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .show(fragment)
                .commit();
    }
}

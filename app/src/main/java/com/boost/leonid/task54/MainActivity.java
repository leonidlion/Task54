package com.boost.leonid.task54;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.boost.leonid.task54.fragments.host.FirstHostFragments;
import com.boost.leonid.task54.fragments.host.SecondHostFragment;
import com.boost.leonid.task54.fragments.host.ThirdHostFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String KEY_FIRST_FRAGMENT = "KEY_FIRST_FRAGMENT";
    private static final String KEY_SECOND_FRAGMENT = "KEY_SECOND_FRAGMENT";
    private static final String KEY_THIRD_FRAGMENT = "KEY_THIRD_FRAGMENT";
    private FirstHostFragments mFirstHostFragments;
    private SecondHostFragment mSecondHostFragment;
    private ThirdHostFragment mThirdHostFragment;
    private BottomBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null){
            Log.d(TAG, "onCreate: saved");
            mFirstHostFragments = (FirstHostFragments) getSupportFragmentManager()
                    .getFragment(savedInstanceState, KEY_FIRST_FRAGMENT);
            mSecondHostFragment = (SecondHostFragment) getSupportFragmentManager()
                    .getFragment(savedInstanceState, KEY_SECOND_FRAGMENT);
            mThirdHostFragment = (ThirdHostFragment) getSupportFragmentManager()
                    .getFragment(savedInstanceState, KEY_THIRD_FRAGMENT);
        }

        mBottomBar = (BottomBar) findViewById(R.id.main_bottom_bar);
        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                hideFragmentIfExists();
                switch (tabId){
                    case R.id.tab_first:
                        onFirstClick();
                        break;
                    case R.id.tab_second:
                        onSecondClick();
                        break;
                    case R.id.tab_third:
                        onThirdClick();
                        break;
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d(TAG, "onSaveInstanceState: ");
        if (mFirstHostFragments != null)
            getSupportFragmentManager().putFragment(outState, KEY_FIRST_FRAGMENT, mFirstHostFragments);
        if (mSecondHostFragment != null)
            getSupportFragmentManager().putFragment(outState, KEY_SECOND_FRAGMENT, mSecondHostFragment);
        if (mThirdHostFragment != null)
            getSupportFragmentManager().putFragment(outState, KEY_THIRD_FRAGMENT, mThirdHostFragment);

        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        switch (mBottomBar.getCurrentTabId()) {
            case R.id.tab_first:
                if (!mFirstHostFragments.onBackPressed()) {
                    Log.d(TAG, "onBackPressed: first");
                    super.onBackPressed();
                }
                break;
            case R.id.tab_second:
                if (!mSecondHostFragment.onBackPressed()) {
                    Log.d(TAG, "onBackPressed: second");
                    super.onBackPressed();
                }
                break;
            case R.id.tab_third:
                if (!mThirdHostFragment.onBackPressed()) {
                    Log.d(TAG, "onBackPressed: third");
                    super.onBackPressed();
                }
                break;
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
            Log.d(TAG, "hideFragmentIfExists: first");
            transaction.hide(mFirstHostFragments);
        }
        if (mSecondHostFragment != null){
            Log.d(TAG, "hideFragmentIfExists: second");
            transaction.hide(mSecondHostFragment);
        }
        if (mThirdHostFragment != null){
            Log.d(TAG, "hideFragmentIfExists: third");
            transaction.hide(mThirdHostFragment);
        }
        transaction.commit();
    }

    private void showFragment(Fragment fragment){
        Log.d(TAG, "showFragment: " + fragment.getClass().getCanonicalName());
        getSupportFragmentManager()
                .beginTransaction()
                .show(fragment)
                .commit();
    }
}

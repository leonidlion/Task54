package com.boost.leonid.task54;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.boost.leonid.task54.fragments.SimpleFragment;
import com.boost.leonid.task54.fragments.host.FirstHostFragments;
import com.boost.leonid.task54.fragments.host.SecondHostFragment;
import com.boost.leonid.task54.fragments.host.ThirdHostFragment;
import com.ncapdevi.fragnav.FragNavController;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity implements
        FragNavController.RootFragmentListener,
        SimpleFragment.FragmentNavigation{
    private static final String TAG = "MainActivity";
    private static final int INDEX_FIRST_HOST = FragNavController.TAB1;
    private static final int INDEX_SECOND_HOST = FragNavController.TAB2;
    private static final int INDEX_THIRD_HOST = FragNavController.TAB3;
    private FragNavController mFragNavController;
    private BottomBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFragmentController(savedInstanceState);

        initBottomBarButtons();
    }

    private void initFragmentController(Bundle savedInstanceState) {
        mFragNavController = new FragNavController(
                savedInstanceState,
                getSupportFragmentManager(),
                R.id.main_frame,
                this,
                3,
                INDEX_FIRST_HOST);
    }

    private void initBottomBarButtons() {
        mBottomBar = (BottomBar) findViewById(R.id.main_bottom_bar);
        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
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
        mBottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(@IdRes int tabId) {
                mFragNavController.clearStack();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d(TAG, "onSaveInstanceState: ");
        super.onSaveInstanceState(outState);
        if (mFragNavController != null){
            mFragNavController.onSaveInstanceState(outState);
        }
    }

    @Override
    public void onBackPressed() {
        if (!mFragNavController.isRootFragment()) {
            mFragNavController.popFragment();
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public Fragment getRootFragment(int i) {
        switch (i){
            case INDEX_FIRST_HOST:
                return new FirstHostFragments();
            case INDEX_SECOND_HOST:
                return new SecondHostFragment();
            case INDEX_THIRD_HOST:
                return new ThirdHostFragment();
            default: return null;
        }
    }

    private void onFirstClick() {
        mFragNavController.switchTab(INDEX_FIRST_HOST);
    }

    private void onSecondClick() {
        mFragNavController.switchTab(INDEX_SECOND_HOST);
    }

    private void onThirdClick() {
        mFragNavController.switchTab(INDEX_THIRD_HOST);
    }


    @Override
    public void pushFragment(Fragment fragment) {
        if (mFragNavController != null) {
            Log.d(TAG, "pushFragment: ");
            mFragNavController.pushFragment(fragment);
        }
    }
}

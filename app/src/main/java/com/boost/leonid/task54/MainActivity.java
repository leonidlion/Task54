package com.boost.leonid.task54;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

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

    private void onFirstClick() {

    }

    private void onSecondClick() {

    }

    private void onThirdClick() {

    }
}

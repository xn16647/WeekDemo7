package com.jiyun.jpushdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.jiyun.jpushdemo.R;

public class WelComeActivity extends AppCompatActivity implements Animation.AnimationListener {

    private TextView high;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wel_come);
        initView();
        initAnim();
    }

    private void initAnim() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale_anim);
        high.setAnimation(animation);
        animation.start();
        animation.setAnimationListener(this);
    }

    private void initView() {
        high = (TextView) findViewById(R.id.high);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        startActivity(new Intent(WelComeActivity.this,MainActivity.class));
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}

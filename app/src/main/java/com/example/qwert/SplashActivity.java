package com.example.qwert;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.blankj.utilcode.util.SPUtils;
import com.example.qwert.floatingbutton.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import yanzhikai.textpath.SyncTextPathView;
import yanzhikai.textpath.painter.FireworksPainter;


public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.atpv_as)
    SyncTextPathView atpvAs;
    private Boolean isFirstInto = true;
    private SPUtils spUtils;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        spUtils = SPUtils.getInstance();
        spUtils.getBoolean("isFristInto");

        atpvAs.setPathPainter(new FireworksPainter());
        atpvAs.startAnimation(0, 1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isFirstInto) {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    spUtils.put("isFirstInto", true);
                    finish();
                }

            }
        }, 3000);


    }


    private void goMain() {
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }
}

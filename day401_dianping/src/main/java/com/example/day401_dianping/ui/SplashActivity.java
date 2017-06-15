package com.example.day401_dianping.ui;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.day401_dianping.R;
import com.example.day401_dianping.util.SPUtil;

public class SplashActivity extends AppCompatActivity {
    SPUtil sputil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        sputil=new SPUtil(this);
        new Handler().postDelayed(run,2000);
    }
    Runnable run=new Runnable() {
        @Override
        public void run() {
            Intent intent;
            if (sputil.isFirst()){
                intent=new Intent(SplashActivity.this,GuideActivity.class);
                sputil.setFirst(false);
            }else {
                intent=new Intent(SplashActivity.this,MainActivity.class);
            }
            startActivity(intent);
            finish();
        }
    };
}

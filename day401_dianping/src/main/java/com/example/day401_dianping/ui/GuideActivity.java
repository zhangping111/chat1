package com.example.day401_dianping.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.day401_dianping.R;
import com.example.day401_dianping.adapter.FragAdapter;

public class GuideActivity extends FragmentActivity {
    Fragment fragment01;
    Fragment fragment02;
    Fragment fragment03;
    Fragment fragment04;

    ViewPager viewPager;
    RadioGroup radioGroup;
    RadioButton radioButton01;
    RadioButton radioButton02;
    RadioButton radioButton03;
    RadioButton radioButton04;

    FragAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        viewPager= (ViewPager) findViewById(R.id.viewpager);
        radioGroup= (RadioGroup) findViewById(R.id.radiogroup);
        setListener();

        initViewPager();
    }

    private void setListener() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        radioGroup.check(R.id.radio_btn01);
                        break;
                    case 1:
                        radioGroup.check(R.id.radio_btn02);
                        break;
                    case 2:
                        radioGroup.check(R.id.radio_btn03);
                        break;
                    case 3:
                        radioGroup.check(R.id.radio_btn04);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radio_btn01:
                        viewPager.setCurrentItem(0,false);
                        break;
                    case R.id.radio_btn02:
                        viewPager.setCurrentItem(1,false);
                        break;
                    case R.id.radio_btn03:
                        viewPager.setCurrentItem(2,false);
                        break;
                    case R.id.radio_btn04:
                        viewPager.setCurrentItem(3,false);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void initViewPager() {
        adapter=new FragAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }
}

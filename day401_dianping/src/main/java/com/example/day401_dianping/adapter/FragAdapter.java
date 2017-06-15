package com.example.day401_dianping.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.day401_dianping.fragment.FirstFragment;
import com.example.day401_dianping.fragment.frouthFragment;
import com.example.day401_dianping.fragment.secondFragment;
import com.example.day401_dianping.fragment.thirdFragment;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/15 0015.
 */

public class FragAdapter extends FragmentPagerAdapter {
    List<Fragment> fragmentList;
    public FragAdapter(FragmentManager fm) {
        super(fm);
        fragmentList=new ArrayList<Fragment>();
        fragmentList.add(new FirstFragment());
        fragmentList.add(new secondFragment());
        fragmentList.add(new thirdFragment());
        fragmentList.add(new frouthFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}

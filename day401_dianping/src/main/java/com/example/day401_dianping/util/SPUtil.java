package com.example.day401_dianping.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.day401_dianping.constant.Constant;

/**
 * Created by Administrator on 2017/6/15 0015.
 */

public class SPUtil {
    SharedPreferences sharedPreferences;
    public SPUtil(Context context,String name){
        SharedPreferences sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
    }

    public SPUtil(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public boolean isFirst(){
        return sharedPreferences.getBoolean(Constant.FIRST,true);
    }
    public void setFirst(boolean flag){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean(Constant.FIRST,flag);
        editor.commit();
    }
}

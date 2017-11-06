package cn.xjw.mvp.utils;

import android.support.v7.app.AppCompatActivity;

import java.util.Stack;

/**
 * Created by xjw on 2017/11/6 11:02
 * Email : 1521975316@qq.com
 */

public class ActivityStack {

    private ActivityStack(){

    }

    private static ActivityStack stack;

    private static Stack<AppCompatActivity> activityStack = new Stack<>();

    public static ActivityStack get(){
        if (stack == null) {
            synchronized (ActivityStack.class) {
                if (stack == null) {
                    stack = new ActivityStack();
                }
            }
        }
        return stack;
    }

    public boolean add(AppCompatActivity appCompatActivity) {
        return activityStack.add(appCompatActivity);
    }



}

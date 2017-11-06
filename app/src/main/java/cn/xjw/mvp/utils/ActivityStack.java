package cn.xjw.mvp.utils;

import android.os.Process;
import android.support.v7.app.AppCompatActivity;

import java.util.Stack;

/**
 * Created by xjw on 2017/11/6 11:02
 * Email : 1521975316@qq.com
 */

public class ActivityStack {

    private ActivityStack() {
        activityStack = new Stack<>();
    }

    private static ActivityStack stack;

    private Stack<AppCompatActivity> activityStack;

    public static ActivityStack get() {
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

    public boolean remove(AppCompatActivity appCompatActivity) {
        return activityStack.remove(appCompatActivity);
    }

    public void exit() {
        while (activityStack.size() > 0) {
            AppCompatActivity removeActivity = activityStack.remove(0);
            removeActivity.finish();
        }
        Process.killProcess(Process.myPid());
        System.exit(0);
    }


}

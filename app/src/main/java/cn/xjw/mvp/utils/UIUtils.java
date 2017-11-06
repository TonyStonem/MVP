package cn.xjw.mvp.utils;

import android.content.Context;
import android.widget.Toast;

import cn.xjw.mvp.base.App;

/**
 * Created by xjw on 2017/11/6 10:39
 * Email : 1521975316@qq.com
 */

public class UIUtils {


    private static Toast toast;

    public static void showToast(String msg) {
        showToast(App.getApp(), msg);
    }

    public static void showToast(Context context, String msg) {
        if (toast == null) {
            toast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
        }
        toast.setText(msg);
        toast.show();
    }


}

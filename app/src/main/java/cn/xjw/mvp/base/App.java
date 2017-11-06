package cn.xjw.mvp.base;

import android.app.Application;

/**
 * Created by xjw on 2017/11/6 10:30
 * Email : 1521975316@qq.com
 */

public class App extends Application {

    private static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    public static App getApp() {
        return app;
    }


}

package cn.xjw.mvp.module.model;

import android.os.Handler;
import android.os.Looper;

import javax.inject.Inject;

import cn.xjw.mvp.module.OnLoadNetListener;
import cn.xjw.mvp.module.contract.LoginContract;

/**
 * Created by xjw on 2017/11/6 15:09
 * Email : 1521975316@qq.com
 */

public class LoginModel implements LoginContract.Model {

    @Inject
    public LoginModel() {

    }

    private Handler handler = new Handler(Looper.getMainLooper());


    @Override
    public void login(final String name, final String pswd, final OnLoadNetListener listener) {
        listener.start();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.end();
                if (name.length() == 3 && pswd.length() == 3) {
                    listener.success("{'msg':'登录成功'}");
                } else {
                    listener.error("{'msg':'账号或密码不正确'}");
                }
            }
        }, 2000);
    }

}

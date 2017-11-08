package cn.xjw.mvp.module.presenter;

import android.text.TextUtils;

import javax.inject.Inject;

import cn.xjw.mvp.base.BasePresenter;
import cn.xjw.mvp.module.OnLoadNetListener;
import cn.xjw.mvp.module.contract.LoginContract;
import cn.xjw.mvp.module.model.LoginModel;

/**
 * Created by xjw on 2017/11/6 11:23
 * Email : 1521975316@qq.com
 */

public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    @Inject
    public LoginPresenter(){

    }

    @Inject
    LoginModel model;

    @Override
    public void start() {

        view.showToast("start.");

    }

    @Override
    public void login() {
        String name = view.getName();
        String pswd = view.getPswd();

        if (TextUtils.isEmpty(name)) {
            view.showToast("账号不能为空");
            return;
        }

        if (TextUtils.isEmpty(pswd)) {
            view.showToast("密码不能为空");
            return;
        }

        model.login(name,pswd,new OnLoadNetListener(){

            @Override
            public void start() {
                view.showLoadingDia();
            }

            @Override
            public void success(String json) {
                view.showToast(json);
                view.gotoMain();
            }

            @Override
            public void error(String error) {
                view.showToast(error);
            }

            @Override
            public void end() {
                view.cancelLoadingDai();
            }
        });



    }
}

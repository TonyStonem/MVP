package cn.xjw.mvp.module.presenter;

import javax.inject.Inject;

import cn.xjw.mvp.base.BasePresenter;
import cn.xjw.mvp.module.contract.LoginContract;

/**
 * Created by xjw on 2017/11/6 11:23
 * Email : 1521975316@qq.com
 */

public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    @Inject
    public LoginPresenter(){

    }


    @Override
    public void login() {
        String name = view.getName();
        String pswd = view.getPswd();

    }
}

package cn.xjw.mvp.module.contract;

import cn.xjw.mvp.base.BaseContract;
import cn.xjw.mvp.module.OnLoadNetListener;

/**
 * Created by xjw on 2017/11/6 11:23
 * Email : 1521975316@qq.com
 */

public interface LoginContract {

    interface View extends BaseContract.View {

        String getName();

        String getPswd();

        void gotoMain();
    }

    interface Presenter extends BaseContract.Presenter {

        void login();

    }

    interface Model extends BaseContract.Model {
        void login(String name, String pswd, OnLoadNetListener listener);
    }

}

package cn.xjw.mvp.module.contract;

import cn.xjw.mvp.base.BaseContract;

/**
 * Created by xjw on 2017/11/6 11:23
 * Email : 1521975316@qq.com
 */

public interface LoginContract {

    interface View extends BaseContract.View{

        String getName();

        String getPswd();

    }

    interface Presenter{

        void login();

    }

}

package cn.xjw.mvp.di.module;

import cn.xjw.mvp.di.scope.PerActivity;
import cn.xjw.mvp.module.contract.LoginContract;
import cn.xjw.mvp.module.presenter.LoginPresenter;
import dagger.Binds;
import dagger.Module;

/**
 * Created by xjw on 2017/11/6 11:24
 * Email : 1521975316@qq.com
 */
@Module
public abstract class PresenterMappingModule {

    @PerActivity
    @Binds
    public abstract LoginContract.Presenter provideLoginPresenter(LoginPresenter presenter);

}

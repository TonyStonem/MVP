package cn.xjw.mvp.di.module;

import cn.xjw.mvp.di.scope.PerPresenter;
import cn.xjw.mvp.module.contract.LoginContract;
import cn.xjw.mvp.module.model.LoginModel;
import dagger.Binds;
import dagger.Module;

/**
 * Created by xjw on 2017/11/6 11:24
 * Email : 1521975316@qq.com
 */
@Module
public abstract class ModelMappingModule {

    @PerPresenter
    @Binds
    public abstract LoginContract.Model provideLoginModel(LoginModel model);

}

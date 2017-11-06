package cn.xjw.mvp.di.component;

import cn.xjw.mvp.di.module.ModelMappingModule;
import cn.xjw.mvp.di.module.PresenterMappingModule;
import cn.xjw.mvp.di.scope.PerActivity;
import cn.xjw.mvp.di.scope.PerFragment;
import cn.xjw.mvp.di.scope.PerPresenter;
import cn.xjw.mvp.module.view.LoginActivity;
import cn.xjw.mvp.module.view.MainActivity;
import dagger.Component;

/**
 * Created by xjw on 2017/11/6 11:08
 * Email : 1521975316@qq.com
 */
@PerActivity
@PerFragment
@PerPresenter
@Component(modules = {PresenterMappingModule.class, ModelMappingModule.class})
public interface MainComponent {

    void inject(LoginActivity activity);

    void inject(MainActivity activity);


}

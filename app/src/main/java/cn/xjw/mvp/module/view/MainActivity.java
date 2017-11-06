package cn.xjw.mvp.module.view;

import cn.xjw.mvp.R;
import cn.xjw.mvp.base.BaseActivity;
import cn.xjw.mvp.base.BaseContract;
import cn.xjw.mvp.base.BasePresenter;
import cn.xjw.mvp.di.component.MainComponent;

public class MainActivity extends BaseActivity {

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void start() {

    }

    @Override
    protected BaseContract.Presenter injectPresenter(MainComponent build) {
        build.inject(this);
        return new BasePresenter<>();
    }
}

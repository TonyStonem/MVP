package cn.xjw.mvp.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import cn.xjw.mvp.di.component.DaggerMainComponent;
import cn.xjw.mvp.di.component.MainComponent;
import cn.xjw.mvp.utils.ActivityStack;
import dagger.internal.Preconditions;

/**
 * Created by xjw on 2017/11/6 10:59
 * Email : 1521975316@qq.com
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseContract.View {

    private AppCompatActivity activity;
    private BaseContract.Presenter basePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        setContentView(getLayoutResID());
        ActivityStack.get().add(this);
        ButterKnife.bind(this);
        basePresenter = Preconditions.checkNotNull(
                injectPresenter(
                        DaggerMainComponent.builder().build()));
        basePresenter.attchView(this);
        start();
    }


    @LayoutRes
    abstract protected int getLayoutResID();

    abstract protected void start();

    protected abstract BaseContract.Presenter injectPresenter(MainComponent build);


    @Override
    public void showLoadingDia() {

    }

    @Override
    public void cancelLoadingDai() {

    }

    @Override
    public void close() {
        finish();
    }
}

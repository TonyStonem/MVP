package cn.xjw.mvp.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import cn.xjw.mvp.di.component.DaggerMainComponent;
import cn.xjw.mvp.di.component.MainComponent;
import cn.xjw.mvp.utils.ActivityStack;
import cn.xjw.mvp.utils.UIUtils;
import dagger.internal.Preconditions;

/**
 * Created by xjw on 2017/11/6 10:59
 * Email : 1521975316@qq.com
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseContract.View {

    private AppCompatActivity activity;
    private BaseContract.Presenter basePresenter;

    private int diaCount;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        setContentView(getLayoutResID());
        ActivityStack.get().add(this);
        ButterKnife.bind(this);
        basePresenter = Preconditions.checkNotNull(injectPresenter(DaggerMainComponent.builder().build()));
        basePresenter.attchView(this);
        basePresenter.start();
        start();
    }


    @LayoutRes
    abstract protected int getLayoutResID();

    protected abstract BaseContract.Presenter injectPresenter(MainComponent build);

    abstract protected void start();


    @Override
    public void showLoadingDia() {
        diaCount++;
    }

    @Override
    public void cancelLoadingDia() {
        cancelLoadingDia(false);
    }

    private void cancelLoadingDia(boolean b) {
        if (b) {
            diaCount = 0;
        }
        diaCount--;
        if (diaCount <= 0) {
            //TODO 取消Dia
        }
    }

    @Override
    public void showToast(String msg) {
        UIUtils.showToast(this, msg);
    }

    @Override
    public void close() {
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        basePresenter.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        basePresenter.paush();
    }

    @Override
    protected void onDestroy() {
        basePresenter.destroy();
        cancelLoadingDia(true);
        ActivityStack.get().remove(this);
        super.onDestroy();
    }
}

package cn.xjw.mvp.base;

/**
 * Created by xjw on 2017/11/6 11:34
 * Email : 1521975316@qq.com
 */

public class BasePresenter<T extends BaseContract.View> implements BaseContract.Presenter {

    protected T view;

    @Override
    public void attchView(BaseContract.View view) {
        this.view = (T) view;
    }

    @Override
    public void start() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void paush() {

    }

    @Override
    public void destroy() {

    }


}

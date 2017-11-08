package cn.xjw.mvp.base;

/**
 * Created by xjw on 2017/11/6 11:14
 * Email : 1521975316@qq.com
 */

public interface BaseContract {

    interface View {

        void showLoadingDia();

        void cancelLoadingDia();

        void showToast(String msg);

        void close();

    }

    interface Presenter<T extends BaseContract.View> {

        void attchView(T view);

        void start();

        void resume();

        void paush();

        void destroy();

    }

    interface Model{

    }

}

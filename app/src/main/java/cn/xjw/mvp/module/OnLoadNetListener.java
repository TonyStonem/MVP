package cn.xjw.mvp.module;

/**
 * Created by xjw on 2017/11/6 15:12
 * Email : 1521975316@qq.com
 */

public interface OnLoadNetListener {

    void start();

    void success(String json);

    void error(String error);

    void end();

}

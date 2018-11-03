package com.taoge.freereader.base;

/**
 * created by：TangTao on 2018/11/3 14:59
 * <p>
 * email：xxx@163.com
 */
public interface IBasePresenter<T extends IBaseView>{

    void attachView(T view);

    void detachView();
}

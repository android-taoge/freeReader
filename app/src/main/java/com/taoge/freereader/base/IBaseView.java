package com.taoge.freereader.base;


/**
 * created by：TangTao on 2018/10/26 14:18
 * <p>
 * email：xxx@163.com
 */
public interface IBaseView{

    void showLoading();

    void hideLoading();

    void showError();

    void showMsg(String msg);
}

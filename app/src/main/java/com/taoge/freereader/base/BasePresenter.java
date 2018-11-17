package com.taoge.freereader.base;

import java.lang.ref.WeakReference;

/**
 * created by：TangTao on 2018/10/26 14:26
 * <p>
 * email：xxx@163.com
 */
public abstract class BasePresenter<V extends IBaseView> {


    protected WeakReference<V> mViewRef;//View 接口类型的弱引用

    public void attachView(V view) {
        if(mViewRef==null){
            mViewRef = new WeakReference<V>(view);
        }
    }

    protected V getView() {
        return mViewRef.get();
    }

    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

    //每个Presenter都会有初始化的工作，可以在这里统一处理
    // 当然也可以不处理，这里只是一个公用的示范方法
    //public abstract void start();

    //这里也可以理解为一个公用的示范方法
    //public abstract void update();
}

package com.taoge.freereader.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * created by：TangTao on 2018/10/26 13:45
 * <p>
 * email：xxx@163.com
 */
public abstract class MvpBaseFragment<P extends BasePresenter> extends BaseFragment implements IBaseView{
    private static final String TAG = MvpBaseFragment.class.getSimpleName() + "";
    protected P mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();//创建Presenter
        mPresenter.attachView(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    protected abstract P createPresenter();
}

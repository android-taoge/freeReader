package com.taoge.freereader.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * created by：TangTao on 2018/10/27 11:25
 * <p>
 * email：xxx@163.com
 */
public abstract class MvpBaseActivity<V,P extends BasePresenter<V>> extends BaseActivity{

    protected P mPresenter;

    protected Unbinder mUnbind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUnbind = ButterKnife.bind(this);
        mPresenter=createPresenter();
        mPresenter.attachView((V) this);
    }


    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbind.unbind();
        mPresenter.detachView();
    }
}

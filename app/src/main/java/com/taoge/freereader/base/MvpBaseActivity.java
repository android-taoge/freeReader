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
public abstract class MvpBaseActivity<P extends BasePresenter> extends BaseActivity implements IBaseView{

    protected P mPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter=createPresenter();
        if(mPresenter!=null){
            mPresenter.attachView(this);

            initData();
            initListener();
        }

    }

    /**
     * 设置数据
     */
    public abstract void initData();


    /**
     * 设置监听
     */
    public abstract void initListener();


    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter!=null){
            mPresenter.detachView();
        }
    }
}

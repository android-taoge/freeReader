package com.taoge.freereader.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * created by：TangTao on 2018/10/27 13:53
 * <p>
 * email：xxx@163.com
 */
public abstract class BaseActivity extends FragmentActivity{

    protected Unbinder mUnbind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        mUnbind= ButterKnife.bind(this);
        initView();
        initData();
        initListener();
    }


    /**
     * 获取布局layout
     * @return
     */
    protected abstract int initLayout();


    /**
     * 获取控件
     */
    public abstract void initView();


    /**
     * 设置数据
     */
    public abstract void initData();


    /**
     * 设置监听
     */
    public abstract void initListener();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbind.unbind();
    }
}

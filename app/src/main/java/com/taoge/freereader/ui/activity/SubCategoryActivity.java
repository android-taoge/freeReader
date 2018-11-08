package com.taoge.freereader.ui.activity;


import android.content.Context;
import android.content.Intent;

import com.taoge.freereader.R;
import com.taoge.freereader.base.BasePresenter;
import com.taoge.freereader.base.MvpBaseActivity;

public class SubCategoryActivity extends MvpBaseActivity {


    @Override
    protected int initLayout() {
        return R.layout.activity_sub_category;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showMsg(String msg) {

    }


    public static void startActivity(Context context) {
        Intent intent = new Intent(context, SubCategoryActivity.class);
        context.startActivity(intent);
    }
}

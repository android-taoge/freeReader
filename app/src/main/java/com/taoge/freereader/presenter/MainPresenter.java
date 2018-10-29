package com.taoge.freereader.presenter;

import com.taoge.freereader.contract.MainContract;
import com.taoge.freereader.model.MainModel;

/**
 * created by：TangTao on 2018/10/27 16:36
 * <p>
 * email：xxx@163.com
 */
public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;
    private MainContract.Model mModel;


    public MainPresenter(MainContract.View mView) {
        this.mView = mView;
        mModel=new MainModel(this);
    }

    @Override
    public void initData() {

        initFragments();
    }

    private void initFragments() {


    }







    @Override
    public void showMessage(String msg) {

    }





}

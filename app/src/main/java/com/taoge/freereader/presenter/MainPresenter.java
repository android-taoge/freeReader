package com.taoge.freereader.presenter;


import com.taoge.freereader.base.BasePresenter;
import com.taoge.freereader.contract.MainContract;
import com.taoge.freereader.model.MainModel;


/**
 * created by：TangTao on 2018/10/27 16:36
 * <p>
 * email：xxx@163.com
 */
public class MainPresenter extends BasePresenter<MainContract.View>
        implements MainContract.Presenter{


    private MainModel mainModel;

    public MainPresenter() {
        this.mainModel = new MainModel();
    }



}

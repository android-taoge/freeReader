package com.taoge.freereader.presenter;

import com.taoge.freereader.base.BasePresenter;
import com.taoge.freereader.bean.TopBookCategory;
import com.taoge.freereader.contract.HomeContract;
import com.taoge.freereader.model.HomeModel;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * created by：TangTao on 2018/11/3 16:41
 * <p>
 * email：xxx@163.com
 */
public class HomePresenter extends BasePresenter<HomeContract.View>
        implements HomeContract.Presenter {

    private HomeModel mHomeModel;

    public HomePresenter() {
        this.mHomeModel = new HomeModel();
    }



}

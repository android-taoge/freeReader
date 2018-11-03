package com.taoge.freereader.model;

import com.taoge.freereader.bean.Girl;
import com.taoge.freereader.contract.MainContract;
import com.taoge.freereader.net.ApiService;
import com.taoge.freereader.net.RetrofitServiceManager;

import io.reactivex.Observable;

/**
 * created by：TangTao on 2018/10/27 16:36
 * <p>
 * email：xxx@163.com
 */
public class MainModel implements MainContract.Model {


    @Override
    public Observable<Girl> getGirl() {
        return RetrofitServiceManager
                .getInstance()
                .create(ApiService.class)
                .getGirl();
    }
}

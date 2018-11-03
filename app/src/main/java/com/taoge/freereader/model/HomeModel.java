package com.taoge.freereader.model;

import com.google.gson.JsonObject;
import com.taoge.freereader.bean.BookCategory;
import com.taoge.freereader.contract.HomeContract;
import com.taoge.freereader.net.ApiService;
import com.taoge.freereader.net.RetrofitServiceManager;

import io.reactivex.Observable;

/**
 * created by：TangTao on 2018/11/3 16:39
 * <p>
 * email：xxx@163.com
 */
public class HomeModel implements HomeContract.Model {


    @Override
    public Observable<BookCategory> getBookCategory() {
        return RetrofitServiceManager
                .getInstance()
                .create(ApiService.class)
                .getBookCategory();
    }
}

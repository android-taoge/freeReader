package com.taoge.freereader.model;

import com.taoge.freereader.bean.TopBookCategory;
import com.taoge.freereader.contract.TopCategoryContract;
import com.taoge.freereader.net.ApiService;
import com.taoge.freereader.net.RetrofitServiceManager;

import io.reactivex.Observable;

/**
 * created by：TangTao on 2018/11/7 16:14
 * <p>
 * email：xxx@163.com
 */
public class TopCategoryModel implements TopCategoryContract.Model {

    @Override
    public Observable<TopBookCategory> getBookCategory() {
        return RetrofitServiceManager
                .getInstance()
                .create(ApiService.class)
                .getBookCategory();
    }
}

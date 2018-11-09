package com.taoge.freereader.model;

import com.taoge.freereader.bean.SomeoneCategoryBookList;
import com.taoge.freereader.contract.SomeoneCategoryBookListContract;
import com.taoge.freereader.net.ApiService;
import com.taoge.freereader.net.RetrofitServiceManager;

import io.reactivex.Observable;

/**
 * created by：TangTao on 2018/11/9 11:52
 * <p>
 * email：xxx@163.com
 */
public class SomeoneCategoryModel implements SomeoneCategoryBookListContract.Model{


    @Override
    public Observable<SomeoneCategoryBookList> getSubCategoryList(String gender, String type, String major, int start, int limit) {
        return RetrofitServiceManager
                .getInstance()
                .create(ApiService.class)
                .getBooksByCategory(gender,type,major,start,limit);
    }
}

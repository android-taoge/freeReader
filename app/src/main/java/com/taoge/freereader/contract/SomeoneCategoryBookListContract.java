package com.taoge.freereader.contract;

import com.taoge.freereader.adapter.SomeOneCategoryAdapter;
import com.taoge.freereader.base.IBaseModel;
import com.taoge.freereader.base.IBaseView;
import com.taoge.freereader.bean.SomeoneCategoryBookList;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Query;

/**
 * created by：TangTao on 2018/11/9 11:47
 * <p>
 * email：xxx@163.com
 */
public interface SomeoneCategoryBookListContract {

    interface View extends IBaseView{
        void showBookList(SomeOneCategoryAdapter adapter,int backSize);

        void loadMoreComplete(SomeOneCategoryAdapter adapter);

        void loadMoreEnd(SomeOneCategoryAdapter adapter);

        void loadMoreFail(SomeOneCategoryAdapter adapter);
    }


    interface Model extends IBaseModel{

        Observable<SomeoneCategoryBookList> getSubCategoryList(String gender, String type, String major, int start, int limit);
    }

    interface Presenter {

    }
}

package com.taoge.freereader.contract;

import com.taoge.freereader.base.IBaseModel;
import com.taoge.freereader.base.IBaseView;
import com.taoge.freereader.bean.SomeoneCategoryBookList;

import java.util.List;

import io.reactivex.Observable;

/**
 * created by：TangTao on 2018/11/9 11:47
 * <p>
 * email：xxx@163.com
 */
public interface SomeoneCategoryBookListContract {

    interface View extends IBaseView{

        void showBookList(List<SomeoneCategoryBookList.BooksBean> booksBeanList);


    }


    interface Model extends IBaseModel{

        Observable<SomeoneCategoryBookList> getSubCategoryList(String gender, String type, String major, int start, int limit);
    }

    interface Presenter {

    }
}

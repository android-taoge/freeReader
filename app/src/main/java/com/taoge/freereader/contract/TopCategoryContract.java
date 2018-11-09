package com.taoge.freereader.contract;

import com.taoge.freereader.base.IBaseModel;
import com.taoge.freereader.base.IBaseView;
import com.taoge.freereader.bean.TopBookCategory;

import io.reactivex.Observable;

/**
 * created by：TangTao on 2018/11/7 16:12
 * <p>
 * email：xxx@163.com
 */
public interface TopCategoryContract {

    interface View extends IBaseView{

        void showCategory(TopBookCategory category);
    }


    interface Presenter{

    }

    interface Model extends IBaseModel{

        Observable<TopBookCategory> getBookCategory();
    }
}

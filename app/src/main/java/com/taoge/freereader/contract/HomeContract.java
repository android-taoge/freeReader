package com.taoge.freereader.contract;

import com.taoge.freereader.base.IBaseModel;
import com.taoge.freereader.base.IBaseView;
import com.taoge.freereader.bean.BookCategory;

import io.reactivex.Observable;


/**
 * created by：TangTao on 2018/11/3 16:36
 * <p>
 * email：xxx@163.com
 */
public interface HomeContract {

    interface View extends IBaseView{

        void showHomeData(String data);

    }

    interface Presenter {

    }

    interface Model extends IBaseModel{
        Observable<BookCategory> getBookCategory();
    }
}

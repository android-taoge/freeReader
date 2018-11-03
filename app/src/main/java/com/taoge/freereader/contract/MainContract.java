package com.taoge.freereader.contract;


import com.taoge.freereader.base.IBaseView;
import com.taoge.freereader.bean.Girl;

import java.util.HashMap;

import io.reactivex.Observable;


/**
 * created by：TangTao on 2018/10/27 16:36
 * <p>
 * email：xxx@163.com
 */
public interface MainContract {


    interface View extends IBaseView{


        void showMessage(String msg);
    }


    //作为BasePresenter的功能扩展接口
    interface Presenter  {


    }


    interface Model{

        Observable<Girl> getGirl();
    }
}

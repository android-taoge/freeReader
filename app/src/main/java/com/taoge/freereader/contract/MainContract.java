package com.taoge.freereader.contract;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;


/**
 * created by：TangTao on 2018/10/27 16:36
 * <p>
 * email：xxx@163.com
 */
public interface MainContract {


    interface View {


        void showMessage(String msg);
    }

    interface Presenter {

        void initData();

        void showMessage(String msg);


    }


    interface Model {

    }
}

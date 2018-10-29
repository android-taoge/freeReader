package com.taoge.freereader.ui;

import android.os.Bundle;
import android.view.View;

import com.taoge.freereader.R;
import com.taoge.freereader.base.BaseFragment;

/**
 * created by：TangTao on 2018/10/27 17:47
 * <p>
 * email：xxx@163.com
 */
public class HomeFragment extends BaseFragment{

    private static HomeFragment homeFragment=null;

    public static HomeFragment newInstance(){
        if(homeFragment==null){
            homeFragment=new HomeFragment();
        }
        return homeFragment;
    }


    @Override
    protected int getPageLayoutID() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }
}

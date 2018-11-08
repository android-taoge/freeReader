package com.taoge.freereader.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.taoge.freereader.R;
import com.taoge.freereader.base.BaseFragment;

/**
 * created by：TangTao on 2018/10/27 17:47
 * <p>
 * email：xxx@163.com
 */
public class PersonalFragment extends BaseFragment {

    private static PersonalFragment personalFragment = null;

    public static PersonalFragment newInstance() {
        if (personalFragment == null) {
            personalFragment = new PersonalFragment();
        }
        return personalFragment;
    }


    @Override
    protected int getPageLayoutID() {
        return R.layout.fragment_personal;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }
}

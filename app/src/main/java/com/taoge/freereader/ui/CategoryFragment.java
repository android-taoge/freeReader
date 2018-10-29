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
public class CategoryFragment extends BaseFragment {

    private static CategoryFragment categoryFragment = null;

    public static CategoryFragment newInstance() {
        if (categoryFragment == null) {
            categoryFragment = new CategoryFragment();

        }
        return categoryFragment;
    }


    @Override
    protected int getPageLayoutID() {
        return R.layout.fragment_category;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }
}

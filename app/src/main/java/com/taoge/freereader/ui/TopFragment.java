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
public class TopFragment extends BaseFragment {

    private static TopFragment topFragment = null;

    public static TopFragment newInstance() {

        if (topFragment == null) {
            topFragment = new TopFragment();
        }
        return topFragment;
    }


    @Override
    protected int getPageLayoutID() {
        return R.layout.fragment_top;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }
}

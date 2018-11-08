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
public class RankFragment extends BaseFragment {

    private static RankFragment rankFragment = null;

    public static RankFragment newInstance() {

        if (rankFragment == null) {
            rankFragment = new RankFragment();
        }
        return rankFragment;
    }


    @Override
    protected int getPageLayoutID() {
        return R.layout.fragment_rank;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }
}

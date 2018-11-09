package com.taoge.freereader.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.taoge.freereader.R;
import com.taoge.freereader.base.BaseFragment;
import com.taoge.freereader.base.MvpBaseFragment;
import com.taoge.freereader.presenter.SomeoneCategoryPresenter;

/**
 * created by：TangTao on 2018/10/27 17:47
 * <p>
 * email：xxx@163.com
 */
public class RankFragment extends MvpBaseFragment {

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

    @Override
    protected SomeoneCategoryPresenter createPresenter() {
        return new SomeoneCategoryPresenter();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showMsg(String msg) {

    }
}

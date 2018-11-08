package com.taoge.freereader.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.taoge.freereader.R;
import com.taoge.freereader.base.MvpBaseFragment;
import com.taoge.freereader.contract.HomeContract;
import com.taoge.freereader.presenter.HomePresenter;

import butterknife.BindView;

/**
 * created by：TangTao on 2018/10/27 17:47
 * <p>
 * email：xxx@163.com
 */
public class HomeFragment extends MvpBaseFragment<HomePresenter> implements HomeContract.View{


    private static HomeFragment homeFragment=null;

    @BindView(R.id.tv_home)
    TextView textHome;




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

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    public void showHomeData(String data) {
        if(!TextUtils.isEmpty(data)){
            textHome.setText(data);
        }
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
        Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
    }



}

package com.taoge.freereader;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.MenuItem;

import com.taoge.freereader.base.BaseActivity;
import com.taoge.freereader.base.BaseFragment;
import com.taoge.freereader.contract.MainContract;
import com.taoge.freereader.presenter.MainPresenter;
import com.taoge.freereader.ui.CategoryFragment;
import com.taoge.freereader.ui.HomeFragment;
import com.taoge.freereader.ui.TopFragment;
import com.taoge.freereader.ui.PersonalFragment;
import com.taoge.freereader.util.BottomNavigationViewHelper;


import butterknife.BindView;

public class MainActivity extends BaseActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener, MainContract.View {

    @BindView(R.id.bottom_navigation)
    BottomNavigationView navigationView;


    private MainContract.Presenter mPresenter;
    private Fragment currentFragment = HomeFragment.newInstance();


    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        BottomNavigationViewHelper.disableShiftMode(navigationView);
    }


    @Override
    public void initData() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.main_content, currentFragment)
                .show(currentFragment).
                commit();
        mPresenter = new MainPresenter(this);
        mPresenter.initData();


    }

    @Override
    public void initListener() {
        navigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        BaseFragment targetFragment;
        switch (menuItem.getItemId()) {
            case R.id.home:
                targetFragment = HomeFragment.newInstance();
                switchFragment(targetFragment)
                        .commit();
                return true;

            case R.id.category:
                targetFragment = CategoryFragment.newInstance();
                switchFragment(targetFragment)
                        .commit();
                return true;

            case R.id.notification:
                targetFragment = TopFragment.newInstance();
                switchFragment(targetFragment)
                        .commit();
                return true;

            case R.id.personal:
                targetFragment = PersonalFragment.newInstance();
                switchFragment(targetFragment)
                        .commit();
                return true;

        }

        return false;


    }


    @Override
    public void showMessage(String msg) {

    }


    /**
     * 切换Fragment
     *
     * @param targetFragment
     * @return
     */
    public FragmentTransaction switchFragment(Fragment targetFragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (!targetFragment.isAdded()) {        //第一次使用switchFragment()时currentFragment为null，所以要判断一下

            if (currentFragment != null) {
                transaction.hide(currentFragment);
            }
            transaction.add(R.id.main_content,
                    targetFragment)
                    .show(targetFragment);
        } else {

            transaction.hide(currentFragment)
                    .show(targetFragment);
        }
        currentFragment = targetFragment;
        //Log.e("current_fragment","=="+currentFragment.getClass().getSimpleName());
        return transaction;
    }


}

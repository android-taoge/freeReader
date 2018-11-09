package com.taoge.freereader.ui.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.taoge.freereader.R;
import com.taoge.freereader.base.BaseFragment;
import com.taoge.freereader.base.MvpBaseActivity;
import com.taoge.freereader.contract.MainContract;
import com.taoge.freereader.presenter.MainPresenter;
import com.taoge.freereader.ui.fragment.CategoryFragment;
import com.taoge.freereader.ui.fragment.HomeFragment;
import com.taoge.freereader.ui.fragment.RankFragment;
import com.taoge.freereader.ui.fragment.PersonalFragment;
import com.taoge.freereader.util.BottomNavigationViewHelper;


import butterknife.BindView;

public class MainActivity extends MvpBaseActivity<MainPresenter> implements
        BottomNavigationView.OnNavigationItemSelectedListener,
        MainContract.View, View.OnClickListener {

    @BindView(R.id.bottom_navigation)
    BottomNavigationView navigationView;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.toolbar_title)
    TextView tvTitle;

    private Fragment currentFragment = HomeFragment.newInstance();


    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        BottomNavigationViewHelper.disableShiftMode(navigationView);
        mToolbar.setTitle("");
        tvTitle.setText(R.string.app_name);
        setSupportActionBar(mToolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
           /* case android.R.id.home:
                this.finish();
                break;*/


            case R.id.action_search:
                Toast.makeText(this, "搜索", Toast.LENGTH_SHORT).show();
                break;

            case R.id.action_settings:
                Toast.makeText(this, "设置", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void initData() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.main_content, currentFragment)
                .show(currentFragment).
                commit();



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
                targetFragment = RankFragment.newInstance();
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


    @Override
    public void onClick(View view) {
        Toast.makeText(this, "有点急", Toast.LENGTH_SHORT).show();

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

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }
}

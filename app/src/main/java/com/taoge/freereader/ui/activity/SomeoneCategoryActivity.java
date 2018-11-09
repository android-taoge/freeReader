package com.taoge.freereader.ui.activity;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.taoge.freereader.R;
import com.taoge.freereader.adapter.SomeOneCategoryAdapter;
import com.taoge.freereader.base.MvpBaseActivity;
import com.taoge.freereader.contract.SomeoneCategoryBookListContract;
import com.taoge.freereader.presenter.SomeoneCategoryPresenter;


import butterknife.BindView;


public class SomeoneCategoryActivity extends MvpBaseActivity<SomeoneCategoryPresenter>
        implements SomeoneCategoryBookListContract.View {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.toolbar_title)
    TextView tvTitle;

    @BindView(R.id.sub_category_rcv)
    RecyclerView mBooksRcv;

    private String categoryName;

    private String gender;  //性别


    private int start = 0;
    private int limit = 20;


    @Override
    protected int initLayout() {
        return R.layout.activity_sub_category;
    }

    @Override
    public void initView() {
        categoryName = getIntent().getStringExtra("categoryName");
        gender = getIntent().getStringExtra("gender");
        if (!TextUtils.isEmpty(categoryName)) {
            tvTitle.setText(categoryName);
        }

        mToolbar.setTitle("");
        mToolbar.setNavigationIcon(R.drawable.ic_back);
        setSupportActionBar(mToolbar);

    }

    @Override
    public void initData() {
        if (categoryName != null && gender != null) {
            mPresenter.getBooksByCategory(gender, "hot", categoryName, 0, limit);
        }
    }

    @Override
    public void initListener() {

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


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }

        return true;
    }

    public static void startActivity(Context context, String categoryName, String gender) {
        Intent intent = new Intent(context, SomeoneCategoryActivity.class);
        intent.putExtra("categoryName", categoryName);
        intent.putExtra("gender", gender);
        context.startActivity(intent);
    }

    @Override
    public void showBookList(SomeOneCategoryAdapter adapter, int backSize) {

        start = start + backSize;
        mBooksRcv.setLayoutManager(new LinearLayoutManager(this));
        mBooksRcv.setAdapter(adapter);
        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mBooksRcv.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                    }/*if (limit >= backSize) {
                            //数据全部加载完毕
                            adapter.loadMoreEnd();
                        } else {
                            if (isErr) {
                                //成功获取更多数据
                                adapter.addData(mPresenter.getBooksByCategory(gender, "hot", categoryName, 0, 20));
                                adapter.loadMoreComplete();
                            } else {
                                //获取更多数据失败
                                isErr = true;
                                Toast.makeText(SomeoneCategoryActivity.this, "获取失败", Toast.LENGTH_LONG).show();
                                adapter.loadMoreFail();

                            }
                        }*/
                }, 1500);
            }
        }, mBooksRcv);
    }

   /* @Override
    public void showBookList(List<SomeoneCategoryBookList.BooksBean> booksBeanList) {
        start = start + mAdapter.getData().size();
        mAdapter = new SomeOneCategoryAdapter(R.layout.item_sub_category_list, booksBeanList);
        mBooksRcv.setLayoutManager(new LinearLayoutManager(this));
        mBooksRcv.setAdapter(mAdapter);
        mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mBooksRcv.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                     *//*   if (mCurrentCounter >= TOTAL_COUNTER) {
                            //数据全部加载完毕
                            mAdapter.loadMoreEnd();
                        } else {
                            if (isErr) {
                                //成功获取更多数据
                                mAdapter.addData(mPresenter.getBooksByCategory(gender,"hot",categoryName,0,20));
                                mCurrentCounter = mAdapter.getData().size();
                                mAdapter.loadMoreComplete();
                            } else {
                                //获取更多数据失败
                                isErr = true;
                                Toast.makeText(SomeoneCategoryActivity.this, "获取失败", Toast.LENGTH_LONG).show();
                                mAdapter.loadMoreFail();

                            }
                        }*//*


                    }


                }, 2000);
            }
        }, mBooksRcv);
    }*/
}

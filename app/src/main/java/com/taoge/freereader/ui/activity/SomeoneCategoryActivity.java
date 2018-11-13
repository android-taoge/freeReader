package com.taoge.freereader.ui.activity;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.taoge.freereader.R;
import com.taoge.freereader.adapter.SomeOneCategoryAdapter;
import com.taoge.freereader.base.MvpBaseActivity;
import com.taoge.freereader.bean.SomeoneCategoryBookList;
import com.taoge.freereader.contract.SomeoneCategoryBookListContract;
import com.taoge.freereader.presenter.SomeoneCategoryPresenter;
import com.taoge.freereader.util.LogUtil;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class SomeoneCategoryActivity extends MvpBaseActivity<SomeoneCategoryPresenter>
        implements SomeoneCategoryBookListContract.View, SwipeRefreshLayout.OnRefreshListener {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.toolbar_title)
    TextView tvTitle;

    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.sub_category_rcv)
    RecyclerView mBooksRcv;

    private String categoryName;

    private String gender;  //性别

    private boolean isRefresh = true;

    private List<SomeoneCategoryBookList.BooksBean> booksBeanList = new ArrayList<>();
    private SomeOneCategoryAdapter adapter;
    private int start = 0;
    private int limit = 10;
    private boolean sIsScrolling;


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
        mBooksRcv.setLayoutManager(new LinearLayoutManager(this));
        mBooksRcv.addOnScrollListener(new OnScrollListener());
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void initData() {

        adapter = new SomeOneCategoryAdapter(R.layout.item_sub_category_list, booksBeanList);
        mBooksRcv.setAdapter(adapter);
        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {

            @Override
            public void onLoadMoreRequested() {
                mBooksRcv.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isRefresh = false;
                        mPresenter.getBooksByCategory(gender, "hot", categoryName, start, limit);
                    }
                }, 2000);
            }
        }, mBooksRcv);

        if (categoryName != null && gender != null) {
            mPresenter.getBooksByCategory(gender, "hot", categoryName, 0, limit);
        }
    }

    @Override
    public void initListener() {
        swipeRefreshLayout.setOnRefreshListener(this);
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
    public void loadMoreComplete(SomeOneCategoryAdapter adapter) {
        adapter.loadMoreComplete();
    }

    @Override
    public void loadMoreEnd(SomeOneCategoryAdapter adapter) {
        adapter.loadMoreEnd();
    }

    @Override
    public void loadMoreFail(SomeOneCategoryAdapter adapter) {
        adapter.loadMoreFail();
    }


    @Override
    public void showBookList(List<SomeoneCategoryBookList.BooksBean> booksBeanList) {


        adapter.addData(booksBeanList);

        if (isRefresh) {
            adapter.removeAllFooterView();
            adapter.setNewData(booksBeanList);
            adapter.notifyDataSetChanged();
            swipeRefreshLayout.setRefreshing(false);

        } else {
            adapter.addData(booksBeanList);
            if (booksBeanList.size() == 0 || booksBeanList.size() < limit) {
                adapter.loadMoreEnd();
            } else if (booksBeanList.size() >= limit) {
                adapter.loadMoreComplete();
            }
            isRefresh = true;
        }

        start += booksBeanList.size();

    }

    @Override
    public void onRefresh() {
        start = 0;
        mPresenter.getBooksByCategory(gender, "hot", categoryName, 0, limit);
    }


    /**
     * recyclerView 滚动监听
     */
    class OnScrollListener extends RecyclerView.OnScrollListener {
        @Override
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
        }

        @Override
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == RecyclerView.SCROLL_STATE_DRAGGING || newState == RecyclerView.SCROLL_STATE_SETTLING) {
                sIsScrolling = true;
                Glide.with(SomeoneCategoryActivity.this).pauseRequests();
            } else if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                if (sIsScrolling == true) {
                    Glide.with(SomeoneCategoryActivity.this).resumeRequests();

                }
                sIsScrolling = false;
            }


        }
    }
}

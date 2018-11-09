package com.taoge.freereader.presenter;

import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.taoge.freereader.R;
import com.taoge.freereader.adapter.SomeOneCategoryAdapter;
import com.taoge.freereader.base.BasePresenter;
import com.taoge.freereader.bean.SomeoneCategoryBookList;
import com.taoge.freereader.contract.SomeoneCategoryBookListContract;
import com.taoge.freereader.model.SomeoneCategoryModel;
import com.taoge.freereader.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * created by：TangTao on 2018/11/9 13:44
 * <p>
 * email：xxx@163.com
 */
public class SomeoneCategoryPresenter
        extends BasePresenter<SomeoneCategoryBookListContract.View> {


    private SomeoneCategoryModel mModel;

    private SomeOneCategoryAdapter adapter;

    private int start = 0;
    private int limit = 10;
    private String gender;
    private String categoryName;
    private String type;
    private RecyclerView recyclerView;

    public SomeoneCategoryPresenter() {
        this.mModel = new SomeoneCategoryModel();
    }


    /**
     * 获取某个分类的书籍 列表
     *
     * @param gender
     * @param type
     * @param major
     * @param start
     * @param limit
     */
    public void getBooksByCategory(RecyclerView recyclerView, String gender, String type, String major, int start, int limit) {
        this.recyclerView=recyclerView;
        this.gender = gender;
        this.type=type;
        this.categoryName = major;
        mModel.getSubCategoryList(
                gender,
                type,
                major,
                start,
                limit
        ).subscribeOn(Schedulers.io())
                .map(new Function<SomeoneCategoryBookList, List<SomeoneCategoryBookList.BooksBean>>() {
                    @Override
                    public List<SomeoneCategoryBookList.BooksBean> apply(SomeoneCategoryBookList someoneCategoryBookList) throws Exception {
                        return someoneCategoryBookList.getBooks();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<SomeoneCategoryBookList.BooksBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<SomeoneCategoryBookList.BooksBean> booksBeans) {
                        //int bookSize=booksBeans.size();
                        if (booksBeans.size() != 0) {
                            //LogUtil.e("bookSize","=="+bookSize);
                            setAdapterData(booksBeans);

                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


    private void setAdapterData(List<SomeoneCategoryBookList.BooksBean> booksBeans) {
        int bookSize = booksBeans.size();
        start = start + bookSize;
        LogUtil.e("backSize", "==" + bookSize);
        LogUtil.e("start", "==" + start);
        if (mViewRef.get() != null) {
            if (adapter == null) {
                adapter = new SomeOneCategoryAdapter(R.layout.item_sub_category_list, booksBeans);
                mViewRef.get().showBookList(adapter, bookSize);
            } else {
                adapter.addData(booksBeans);
                LogUtil.e("adapter.dataSize", "==" + adapter.getData().size());
            }

            adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
                @Override
                public void onLoadMoreRequested() {
                    recyclerView.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            if (limit >= bookSize) {
                               mViewRef.get().loadMoreEnd(adapter);
                            } else {
                                getBooksByCategory(recyclerView,gender, type, categoryName, start, limit);
                                mViewRef.get().loadMoreComplete(adapter);
                            }
                        }
                    },1000);
                }
            },recyclerView);
        }
    }
}

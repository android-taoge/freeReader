package com.taoge.freereader.presenter;

import com.taoge.freereader.adapter.SomeOneCategoryAdapter;
import com.taoge.freereader.base.BasePresenter;
import com.taoge.freereader.bean.SomeoneCategoryBookList;
import com.taoge.freereader.contract.SomeoneCategoryBookListContract;
import com.taoge.freereader.model.SomeoneCategoryModel;
import com.taoge.freereader.util.LogUtil;

import java.util.List;

import io.reactivex.Observer;
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
    public void getBooksByCategory(String gender, String type, String major, int start, int limit) {
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
                        //LogUtil.e("books.type", "==" + type);
                        //LogUtil.e("books.size", "==" + booksBeans.size());
                        if (mViewRef.get() != null) {

                            mViewRef.get().showBookList(booksBeans);
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


}

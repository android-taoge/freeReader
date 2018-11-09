package com.taoge.freereader.presenter;

import com.taoge.freereader.R;
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
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SomeoneCategoryBookList>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SomeoneCategoryBookList someoneCategoryBookList) {
                        List<SomeoneCategoryBookList.BooksBean> booksBeanList = someoneCategoryBookList.getBooks();
                        LogUtil.e("booklist", "==" + booksBeanList.size());
                       /*if(mViewRef.get()!=null){
                           mViewRef.get().showBookList(booksBeanList);
                       }*/
                        if (booksBeanList.size() != 0) {
                            setAdapterData(booksBeanList);

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
        int bookSize=booksBeans.size();
        if (mViewRef.get() != null) {
           if(adapter==null){
               adapter = new SomeOneCategoryAdapter(R.layout.item_sub_category_list, booksBeans);
               mViewRef.get().showBookList(adapter,bookSize);
           }else {
               adapter.addData(booksBeans);
           }

        }
    }
}

package com.taoge.freereader.presenter;

import com.taoge.freereader.base.BasePresenter;
import com.taoge.freereader.bean.BookCategory;
import com.taoge.freereader.contract.CategoryContract;
import com.taoge.freereader.model.CategoryModel;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * created by：TangTao on 2018/11/7 16:15
 * <p>
 * email：xxx@163.com
 */
public class CategoryPresenter extends BasePresenter<CategoryContract.View>
        implements CategoryContract.Presenter{

    private CategoryModel mModel;

    public CategoryPresenter() {
        this.mModel = new CategoryModel();
    }


    /**
     * 获取书籍分类
     */
    public void getBookCategory(){
        mModel.getBookCategory()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BookCategory>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BookCategory bookCategory) {
                        if(mViewRef.get()!=null){
                            mViewRef.get().showCategory(bookCategory);
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

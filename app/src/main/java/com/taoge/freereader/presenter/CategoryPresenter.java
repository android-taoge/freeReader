package com.taoge.freereader.presenter;

import com.taoge.freereader.base.BasePresenter;
import com.taoge.freereader.bean.TopBookCategory;
import com.taoge.freereader.contract.TopCategoryContract;
import com.taoge.freereader.model.TopCategoryModel;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * created by：TangTao on 2018/11/7 16:15
 * <p>
 * email：xxx@163.com
 */
public class CategoryPresenter extends BasePresenter<TopCategoryContract.View>
        implements TopCategoryContract.Presenter{

    private TopCategoryModel mModel;

    public CategoryPresenter() {
        this.mModel = new TopCategoryModel();
    }


    /**
     * 获取书籍分类
     */
    public void getBookCategory(){
        mModel.getBookCategory()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TopBookCategory>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TopBookCategory topBookCategory) {
                        if(mViewRef.get()!=null){
                            mViewRef.get().showCategory(topBookCategory);
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

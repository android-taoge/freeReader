package com.taoge.freereader.presenter;

import com.google.gson.JsonObject;
import com.taoge.freereader.base.BasePresenter;
import com.taoge.freereader.bean.BookCategory;
import com.taoge.freereader.contract.HomeContract;
import com.taoge.freereader.model.HomeModel;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * created by：TangTao on 2018/11/3 16:41
 * <p>
 * email：xxx@163.com
 */
public class HomePresenter extends BasePresenter<HomeContract.View>
        implements HomeContract.Presenter {

    private HomeModel mHomeModel;

    public HomePresenter() {
        this.mHomeModel = new HomeModel();
    }


    /**
     * 获取百度首页信息
     */
    public void getBookCategory() {
        mHomeModel.getBookCategory()
                .subscribeOn(Schedulers.io())
                .map(bookCategory -> bookCategory)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BookCategory>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BookCategory category) {
                        if (mViewRef.get() != null) {
                            mViewRef.get().showHomeData(category.toString());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if(mViewRef.get()!=null){
                            mViewRef.get().showMsg(e.toString());

                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}

package com.taoge.freereader.presenter;


import com.taoge.freereader.base.BasePresenter;
import com.taoge.freereader.bean.Girl;
import com.taoge.freereader.contract.MainContract;
import com.taoge.freereader.model.MainModel;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * created by：TangTao on 2018/10/27 16:36
 * <p>
 * email：xxx@163.com
 */
public class MainPresenter extends BasePresenter<MainContract.View>
        implements MainContract.Presenter{


    private MainModel mainModel;

    public MainPresenter() {
        this.mainModel = new MainModel();
    }


    public void getGirlData(){
        mainModel.getGirl()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Girl>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Girl girl) {
                        if(mViewRef.get()!=null){
                            mViewRef.get().showMessage(girl.toString());

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

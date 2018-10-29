package com.taoge.freereader.base;

/**
 * created by：TangTao on 2018/10/26 14:23
 * <p>
 * email：xxx@163.com
 */
public interface IBaseModel<Data> {

    void loadData(OnDataLoadCompleteListener<Data> loadCompleteListener);

    interface OnDataLoadCompleteListener<Data> {
        void onLoadComplete(Data data);
    }
}

package com.taoge.freereader.net;

import io.reactivex.disposables.Disposable;

/**
 * created by：TangTao on 2018/11/3 16:07
 * <p>
 * email：xxx@163.com
 */
public interface SubscriptionHelper<T> {
    void add(Disposable subscription);

    void cancel(Disposable t);

    void cancelall();
}

package com.taoge.freereader.net;

import com.taoge.freereader.bean.BookCategory;
import com.taoge.freereader.bean.Girl;
import com.taoge.freereader.bean.RankList;


import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * created by：TangTao on 2018/11/3 16:11
 * <p>
 * email：xxx@163.com
 */
public interface ApiService {

    @GET("")
    Observable<Girl> getGirl();

    /**
     * 获取书籍分类
     * @return
     */
    @GET("cats/lv2/statistics")
    Observable<BookCategory> getBookCategory();


    /**
     * 最外层大排行榜
     * @return
     */
    @GET("/ranking/gender")
    Observable<RankList> getBookRank();

}

package com.taoge.freereader.net;

import com.taoge.freereader.bean.SomeoneCategoryBookList;
import com.taoge.freereader.bean.TopBookCategory;
import com.taoge.freereader.bean.RankList;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * created by：TangTao on 2018/11/3 16:11
 * <p>
 * email：xxx@163.com
 */
public interface ApiService {



    /**
     * 获取书籍分类
     * @return
     */
    @GET("cats/lv2/statistics")
    Observable<TopBookCategory> getBookCategory();


    /**
     * 按分类获取书籍列表
     *
     * @param gender male、female
     * @param type   hot(热门)、new(新书)、reputation(好评)、over(完结)
     * @param major  玄幻
     * @param //minor  东方玄幻、异界大陆、异界争霸、远古神话
     * @param limit  50
     * @return
     */
    @GET("/book/by-categories")
    Observable<SomeoneCategoryBookList> getBooksByCategory(@Query("gender") String gender,
                                                           @Query("type") String type,
                                                           @Query("major") String major,
                                                           @Query("start") int start,
                                                           @Query("limit") int limit);



    /**
     * 最外层大排行榜
     * @return
     */
    @GET("/ranking/gender")
    Observable<RankList> getBookRank();





}

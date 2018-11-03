package com.taoge.freereader.net;

import com.google.gson.JsonObject;
import com.taoge.freereader.bean.BookCategory;
import com.taoge.freereader.bean.Girl;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * created by：TangTao on 2018/11/3 16:11
 * <p>
 * email：xxx@163.com
 */
public interface ApiService {
    /*@GET("{fenzhi}{bianhao}/orderinfo")
    Observable<List<BeanGSchaxun>> getGSxin(@Path("fenzhi") String fenzhi,
                                            @Path("bianhao") String bianhao,
                                            @Query("batchNo") String batchNo);*/

    @GET("")
    Observable<Girl> getGirl();

    @GET("cats/lv2/statistics")
    Observable<BookCategory> getBookCategory();
}

package com.taoge.freereader.constant;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * created by：TangTao on 2018/11/9 11:17
 * <p>
 * email：xxx@163.com
 */
public class Constant {


    public static final String API_BASE_URL = "http://api.zhuishushenqi.com";

    public static final String IMG_BASE_URL = "http://statics.zhuishushenqi.com";



    @StringDef({
            Gender.MALE,
            Gender.FEMALE
    })

    /**
     * 性别(使用注解而不使用枚举的原因是枚举太占用内存)
     */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Gender {
        String MALE = "male";
        String FEMALE = "female";
    }


    @StringDef({
            Category.HOT,
            Category.NEW,
            Category.REPUTATION,
            Category.OVER
    })

    /**
     * 分类类型
     */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Category {
        String HOT = "hot";
        String NEW = "new";
        String REPUTATION = "reputation";
        String OVER = "over";
    }
}

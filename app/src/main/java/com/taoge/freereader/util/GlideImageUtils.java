package com.taoge.freereader.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.taoge.freereader.R;

/**
 * created by：TangTao on 2018/11/13 11:26
 * <p>
 * email：xxx@163.com
 */
public class GlideImageUtils {

    /**
     * (1)
     * 显示图片Imageview
     *
     * @param context  上下文
     * @param placeImg 错误的资源图片
     * @param imgUrl      图片链接
     * @param imageView 组件
     */
    public static void showImageView(Context context, int placeImg, String imgUrl,
                                     ImageView imageView) {

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.cover_default)
                .error(placeImg)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);// 缓存修改过的图片

        Glide.with(context)
                .load(imgUrl)
                .apply(options)
                .into(imageView);


    }



}

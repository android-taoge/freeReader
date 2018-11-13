package com.taoge.freereader.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.taoge.freereader.R;
import com.taoge.freereader.bean.SomeoneCategoryBookList;
import com.taoge.freereader.constant.Constant;
import com.taoge.freereader.util.GlideImageUtils;

import java.util.List;

/**
 * created by：TangTao on 2018/11/9 15:17
 * <p>
 * email：xxx@163.com
 */
public class SomeOneCategoryAdapter extends BaseQuickAdapter<SomeoneCategoryBookList.BooksBean,BaseViewHolder>{

    public SomeOneCategoryAdapter(int layoutResId, @Nullable List<SomeoneCategoryBookList.BooksBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SomeoneCategoryBookList.BooksBean item) {

        String imgUrl= Constant.IMG_BASE_URL+item.getCover();

        helper.setText(R.id.tvSubCateTitle,item.getTitle());
        helper.setText(R.id.tvSubCateAuthor,item.getAuthor());
        helper.setText(R.id.tvSubCategory,item.getMajorCate());
        helper.setText(R.id.tvSubCateShort,item.getShortIntro());
        helper.setText(R.id.tvFlower,item.getLatelyFollower()+"人在读");

        GlideImageUtils.
                showImageView(mContext,
                        R.drawable.cover_default,
                        imgUrl,
                        helper.getView(R.id.ivSubCateCover));
    }
}

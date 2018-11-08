package com.taoge.freereader.adapter;

import android.content.Context;
import android.view.View;

import com.taoge.freereader.R;
import com.taoge.freereader.bean.BookCategory;
import com.taoge.freereader.common.CommonRVAdapter;
import com.taoge.freereader.common.CommonRVHolder;
import com.taoge.freereader.common.OnRvItemClickListener;

import java.util.List;

/**
 * created by：TangTao on 2018/11/7 17:50
 * <p>
 * email：xxx@163.com
 */
public class MaleCategoryAdapter extends CommonRVAdapter<BookCategory.MaleBean>{
    private OnRvItemClickListener itemClickListener;

    public MaleCategoryAdapter(Context context, List<BookCategory.MaleBean> list, OnRvItemClickListener listener) {
        super(context, list, R.layout.item_top_category);
        this.itemClickListener = listener;
    }

    @Override
    protected void onBindData(CommonRVHolder viewHolder, int position, BookCategory.MaleBean item) {

        viewHolder.setText(R.id.tvName, item.getName())
                .setText(R.id.tvBookCount, String.format(mContext.getString(R.string
                        .category_book_count), item.getBookCount()));

        viewHolder.setOnItemViewClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClick(viewHolder.getItemView(), position, item);
            }
        });
    }
}

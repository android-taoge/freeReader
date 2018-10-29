package com.taoge.freereader.wedgit;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.support.v7.widget.AppCompatTextView;

/**
 * created by：TangTao on 2018/10/25 17:22
 * <p>
 * email：xxx@163.com
 */
public class IconFontTextView extends AppCompatTextView {
    public IconFontTextView(Context context) {
        super(context);
        init(context);
    }

    public IconFontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public IconFontTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    private void init(Context context){
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),"icon/iconfont.ttf"));
    }
}


package com.taoge.freereader.order_test;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.taoge.freereader.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YQ on 2016/11/25.
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "RecycleViewAdapter_log";
    private List<Order.MsgBean> dataList = new ArrayList<>();
    private final int HEAD = 0x001;
    private final int ITEM = 0x002;
    private final int FOOT = 0x003;
    private Context context;
    private itemClickListeren listeren;
    private footButtonClick footButtonClick;

    public void setFootButtonClick(RecycleViewAdapter.footButtonClick footButtonClick) {
        this.footButtonClick = footButtonClick;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case HEAD:
                return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_head, parent, false));
            case ITEM:
                return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
            case FOOT:
                return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_foot, parent, false));
            default:
                return null;
        }
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        if (getItemViewType(position) == HEAD) {
            ((TextView) viewHolder.getView(R.id.item_headTv)).setText("订单号:" + dataList.get(position).getSn());
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   if(listeren!=null){
                       listeren.headItemClick(position);
                   }
                }
            });
        } else if (getItemViewType(position) == ITEM) {
            int tempP = dataList.get(position).getOrderPosition();//获取orderItem真实位置
            ((TextView) viewHolder.getView(R.id.item_Tv)).setText(dataList.get(position).getOrderItem().get(tempP).getName());
            ((TextView) viewHolder.getView(R.id.item_pTv)).setText("￥" + dataList.get(position).getOrderItem().get(tempP).getPrice());
            //Picasso.with(context).load(dataList.get(position).getImage()).into(((ImageView) viewHolder.getView(R.id.item_Iv)));
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listeren!=null){
                        listeren.itemClick(position);
                    }
                }
            });
        } else if (getItemViewType(position) == FOOT) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   if(listeren!=null){
                       listeren.footItemClick(position);
                   }
                }
            });

            viewHolder.getView(R.id.item_footTv).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(footButtonClick!=null){
                        footButtonClick.onButtonclick(position);

                    }
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (dataList.get(position).getType()) {
            case 1:
                return HEAD;
            case 2:
                return ITEM;
            case 3:
                return FOOT;
            default:
                return 0;
        }
    }

    public RecycleViewAdapter(List<Order.MsgBean> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private SparseArray<View> views = new SparseArray<>();

        public ViewHolder(View convertView) {
            super(convertView);
        }

        /**
         * 根据id获取view
         */
        public <T extends View> T getView(int viewId) {
            View view = views.get(viewId);
            if (null == view) {
                view = itemView.findViewById(viewId);
                views.put(viewId, view);
            }
            return (T) view;
        }
    }

    public interface itemClickListeren {
        void headItemClick(int position);

        void itemClick(int position);

        void footItemClick(int position);
    }

    public interface footButtonClick{
        void onButtonclick(int position);
    }

    public void setItemOnClick(itemClickListeren listeren) {
        if(listeren!=null){
            this.listeren = listeren;
        }
    }
}

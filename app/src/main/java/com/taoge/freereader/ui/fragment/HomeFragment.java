package com.taoge.freereader.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.taoge.freereader.R;
import com.taoge.freereader.base.MvpBaseFragment;
import com.taoge.freereader.contract.HomeContract;
import com.taoge.freereader.hongyang.LoadMoreWrapper;
import com.taoge.freereader.order_test.Order;
import com.taoge.freereader.order_test.RecycleViewAdapter;
import com.taoge.freereader.presenter.HomePresenter;
import com.taoge.freereader.order_test.ReadJsonUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * created by：TangTao on 2018/10/27 17:47
 * <p>
 * email：xxx@163.com
 */
public class HomeFragment extends MvpBaseFragment<HomePresenter> implements HomeContract.View, RecycleViewAdapter.itemClickListeren, RecycleViewAdapter.footButtonClick {


    private static HomeFragment homeFragment=null;

    //@BindView(R.id.tv_home)
    //TextView textHome;

    @BindView(R.id.rcv)
    RecyclerView recyclerView;
    private String orderJsonString;
    private Order.MsgBean bean;
    private List<Order.MsgBean> msgBeanList=new ArrayList<>();
    private RecycleViewAdapter adapter;

    private LoadMoreWrapper loadMoreWrapper;


    public static HomeFragment newInstance(){
        if(homeFragment==null){
            homeFragment=new HomeFragment();
        }
        return homeFragment;
    }


    @Override
    protected int getPageLayoutID() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

        initData();
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    public void showHomeData(String data) {
        /*if(!TextUtils.isEmpty(data)){
            textHome.setText(data);
        }*/
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showMsg(String msg) {
        Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
    }




    private void initData(){
        orderJsonString=ReadJsonUtil.getJson(getActivity(),"order.json");
        Order order=new Gson().fromJson(orderJsonString,Order.class);
        List<Order.MsgBean> list=order.getMsg();
        msgBeanList= handleList(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter=new RecycleViewAdapter(msgBeanList,getActivity());
        loadMoreWrapper=new LoadMoreWrapper(adapter);
        loadMoreWrapper.setLoadMoreView(R.layout.brvah_quick_view_load_more);
        recyclerView.setAdapter(loadMoreWrapper);
        loadMoreWrapper.setOnLoadMoreListener(new LoadMoreWrapper.OnLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {

                recyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                       /* Order.MsgBean msgBean=new Order.MsgBean();
                        msgBean.setType(1);
                        msgBean.setSn("tttttttttttttt");
                        List<Order.MsgBean.OrderItemBean> orderItemBeans=new ArrayList<>();
                        Order.MsgBean.OrderItemBean orderItemBean=new Order.MsgBean.OrderItemBean();
                        orderItemBean.setName("充气娃娃");
                        orderItemBean.setPrice(199);
                        msgBean.setOrderItem(orderItemBeans);
                        List<Order.MsgBean> oneMsgBeans=new ArrayList<>();
                        oneMsgBeans.add(msgBean);
                        List<Order.MsgBean> newMsgBeanList=handleList(oneMsgBeans);*/
                        msgBeanList.addAll(msgBeanList);
                        loadMoreWrapper.notifyDataSetChanged();

                    }
                },2000);
            }
        });

        adapter.setItemOnClick(this);
        adapter.setFootButtonClick(this);

    }



    private List<Order.MsgBean> handleList(List<Order.MsgBean> list) {
        if (null == list || 0 == list.size())
            return list;
        List<Order.MsgBean> temp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {//拆解一个订单
            bean = list.get(i);
            bean.setType(1);//给bean增加了一个type字段,所以这样可以用来set,为了在adapter里面去判断是什么类型
            temp.add(bean);//先增加一个头
            for (int j = 0; j < list.get(i).getOrderItem().size(); j++) {//拆解一个订单里面的具体每个订单
                bean = (Order.MsgBean) bean.clone();//这里用了深拷贝,是因为要对数据进行修改,后面会给出连接.

                bean.setType(2);
                bean.setOrderPosition(j);
                temp.add(bean);//增加一个内容
            }
            bean = (Order.MsgBean) bean.clone();
            bean.setType(3);
            temp.add(bean);//尾部添加一个
        }
        return temp;
    }

    @Override
    public void headItemClick(int position) {
        Toast.makeText(getActivity(), "点击了头部", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void itemClick(int position) {
        Toast.makeText(getActivity(), "点击了内容", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void footItemClick(int position) {
        Toast.makeText(getActivity(), "点击了底部", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onButtonclick(int position) {
        Toast.makeText(getActivity(), "底部按钮", Toast.LENGTH_SHORT).show();
    }
}

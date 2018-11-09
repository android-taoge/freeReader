package com.taoge.freereader.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.taoge.freereader.R;
import com.taoge.freereader.adapter.FemaleCategoryAdapter;
import com.taoge.freereader.adapter.MaleCategoryAdapter;
import com.taoge.freereader.base.MvpBaseFragment;
import com.taoge.freereader.bean.TopBookCategory;
import com.taoge.freereader.common.OnRvItemClickListener;
import com.taoge.freereader.common.SupportGridItemDecoration;
import com.taoge.freereader.contract.TopCategoryContract;
import com.taoge.freereader.presenter.CategoryPresenter;
import com.taoge.freereader.ui.activity.SomeoneCategoryActivity;

import butterknife.BindView;

/**
 * created by：TangTao on 2018/10/27 17:47
 * <p>
 * email：xxx@163.com
 */
public class CategoryFragment extends MvpBaseFragment<CategoryPresenter>
        implements TopCategoryContract.View {

    private static CategoryFragment categoryFragment = null;

    @BindView(R.id.male_rev)
    RecyclerView maleRecv;

    @BindView(R.id.female_rev)
    RecyclerView femaleRecv;

    private MaleCategoryAdapter maleAdapter;
    private FemaleCategoryAdapter femaleAdapter;


    public static CategoryFragment newInstance() {
        if (categoryFragment == null) {
            categoryFragment = new CategoryFragment();

        }
        return categoryFragment;
    }


    @Override
    protected int getPageLayoutID() {
        return R.layout.fragment_category;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

        mPresenter.getBookCategory();
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        maleRecv.setHasFixedSize(true);
        maleRecv.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        maleRecv.addItemDecoration(new SupportGridItemDecoration(getActivity()));
        femaleRecv.setHasFixedSize(true);
        femaleRecv.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        femaleRecv.addItemDecoration(new SupportGridItemDecoration(getActivity()));
    }

    @Override
    protected CategoryPresenter createPresenter() {
        return new CategoryPresenter();
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

    }

    @Override
    public void showCategory(TopBookCategory category) {

        maleAdapter = new MaleCategoryAdapter(getActivity(), category.getMale(), new MaleItemClickListener());
        femaleAdapter = new FemaleCategoryAdapter(getActivity(), category.getFemale(), new FemaleItemClickListener());

        maleRecv.setAdapter(maleAdapter);
        femaleRecv.setAdapter(femaleAdapter);
    }


    class MaleItemClickListener implements OnRvItemClickListener<TopBookCategory.MaleBean> {


        @Override
        public void onItemClick(View view, int position, TopBookCategory.MaleBean data) {
            Toast.makeText(getActivity(), "点我干啥？" + position, Toast.LENGTH_SHORT).show();
            String categoryName = data.getName();
            String gender="male";
            SomeoneCategoryActivity.startActivity(getActivity(),categoryName,gender);
        }
    }


    class FemaleItemClickListener implements OnRvItemClickListener<TopBookCategory.FemaleBean> {


        @Override
        public void onItemClick(View view, int position, TopBookCategory.FemaleBean data) {
            Toast.makeText(getActivity(), "点我干啥？" + position, Toast.LENGTH_SHORT).show();
            String categoryName = data.getName();
            String gender="female";
            SomeoneCategoryActivity.startActivity(getActivity(),categoryName,gender);
        }
    }
}

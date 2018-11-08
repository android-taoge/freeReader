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
import com.taoge.freereader.bean.BookCategory;
import com.taoge.freereader.common.OnRvItemClickListener;
import com.taoge.freereader.common.SupportGridItemDecoration;
import com.taoge.freereader.contract.CategoryContract;
import com.taoge.freereader.presenter.CategoryPresenter;
import com.taoge.freereader.ui.activity.SubCategoryActivity;

import butterknife.BindView;

/**
 * created by：TangTao on 2018/10/27 17:47
 * <p>
 * email：xxx@163.com
 */
public class CategoryFragment extends MvpBaseFragment<CategoryPresenter>
        implements CategoryContract.View {

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
    public void showCategory(BookCategory category) {

        maleAdapter=new MaleCategoryAdapter(getActivity(), category.getMale(), new MaleItemClickListener());
        femaleAdapter=new FemaleCategoryAdapter(getActivity(),category.getFemale(),new FemaleItemClickListener());

        maleRecv.setAdapter(maleAdapter);
        femaleRecv.setAdapter(femaleAdapter);
    }




    class MaleItemClickListener implements OnRvItemClickListener<BookCategory.MaleBean>{


        @Override
        public void onItemClick(View view, int position, BookCategory.MaleBean data) {
            Toast.makeText(getActivity(), "点我干啥？"+position, Toast.LENGTH_SHORT).show();
            SubCategoryActivity.startActivity(getActivity());
        }
    }


    class FemaleItemClickListener implements OnRvItemClickListener<BookCategory.FemaleBean>{


        @Override
        public void onItemClick(View view, int position, BookCategory.FemaleBean data) {
            Toast.makeText(getActivity(), "点我干啥？"+position, Toast.LENGTH_SHORT).show();
            SubCategoryActivity.startActivity(getActivity());
        }
    }
}

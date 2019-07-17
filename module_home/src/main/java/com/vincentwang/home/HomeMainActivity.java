package com.vincentwang.home;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.vincentwang.library.common.BaseActivity;

public class HomeMainActivity extends BaseActivity {


    Fragment fragment;

    @Override
    public int setLayoutId() {
        return R.layout.activity_main_home;
    }

    @Override
    public void initView() {
    }

    @Override
    public void initData() {
        changeFragment();
    }

    @Override
    public void initEvent() {

    }

    /**
     * Fragment 发生改变
     */
    public void changeFragment() {
        //hideFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (fragment != null) {
            transaction.show(fragment);
        } else {
            fragment = HomeFragment.getInstance(HomeFragment.class,null);
            transaction.add(R.id.fl_context,fragment);
        }
        transaction.commitAllowingStateLoss();
    }


    /**
     * 隐藏所有Fragment
     */
    private void hideFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(fragment);
        transaction.commit();

    }



}

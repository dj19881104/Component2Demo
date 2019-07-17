package com.vincentwang.news;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.vincentwang.library.common.BaseActivity;

public class NewsMainActivity extends BaseActivity {

    Fragment fragment;

    @Override
    public int setLayoutId() {
        return R.layout.activity_main_zixun;
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
            fragment = NewsFragment.getInstance(NewsFragment.class, null);
            transaction.add(R.id.zixunmodule_fl_containner, fragment);
        }
        transaction.commitAllowingStateLoss();
    }

}

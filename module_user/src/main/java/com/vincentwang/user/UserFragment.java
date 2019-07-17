package com.vincentwang.user;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.vincentwang.library.common.BaseFragment;

import static com.vincentwang.library.common.AouterConfig.MODULE_USER;


/**
 * 作者：Created by ${XZT} on 2019/6/1
 * 文件描述：
 */
@Route(path = MODULE_USER)
public class UserFragment extends BaseFragment {

    @Override
    public int setLayoutId() {
        return R.layout.activity_main_user;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {

    }
}

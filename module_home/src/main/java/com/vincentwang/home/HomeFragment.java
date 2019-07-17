package com.vincentwang.home;

import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.vincentwang.library.common.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

import static com.vincentwang.library.common.AouterConfig.COMPONENT_X5;
import static com.vincentwang.library.common.AouterConfig.MODULE_HOME;


/**
 * 作者：Created by ${XZT} on 2019/6/1
 * 文件描述：
 */
@Route(path = MODULE_HOME)
public class HomeFragment extends BaseFragment {



    @BindView(R2.id.homemodule_button)
    Button homemoduleButton;



    @Override
    public int setLayoutId() {
        return R.layout.fragment_main_home;
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





    @OnClick(R2.id.homemodule_button)
    public void onViewClicked() {
        ARouter.getInstance().build(COMPONENT_X5).withString("url","https://www.baidu.com/").navigation();
    }
}
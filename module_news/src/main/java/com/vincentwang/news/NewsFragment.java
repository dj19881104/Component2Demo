package com.vincentwang.news;

import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.vincentwang.library.common.AouterConfig;
import com.vincentwang.library.common.BaseFragment;
import com.vincentwang.library.intface.X5CompService;
import com.vincentwang.library.util.ARouterUtils;

import butterknife.BindView;
import butterknife.OnClick;

import static com.vincentwang.library.common.AouterConfig.MODULE_NEWS;


/**
 * 作者：Created by ${XZT} on 2019/6/1
 * 文件描述：
 */
@Route(path = MODULE_NEWS)
public class NewsFragment extends BaseFragment {

    @BindView(R2.id.button)
    Button button;


    @Override
    public int setLayoutId() {
        return R.layout.zixunmodule_fragment_zixun;
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


//    @Autowired(name = COMPONENT_X5CLASS)
//    public X5CompService x5CompService;


    @OnClick(R2.id.button)
    public void onViewClicked() {
        X5CompService x5CompService = ARouterUtils.provide(X5CompService.class, AouterConfig.COMPONENT_X5CLASS);
        if (x5CompService != null) {
            x5CompService.x5CompserviceMethod("http://fanyi.youdao.com");
        }


    }
}

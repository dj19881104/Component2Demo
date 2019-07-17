package com.vincentwang.train;

import android.annotation.SuppressLint;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.vincentwang.library.bean.Event;
import com.vincentwang.library.common.BaseActivity;
import com.vincentwang.library.common.BaseFragment;
import com.vincentwang.library.util.ARouterUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.vincentwang.library.common.AouterConfig.MODULE_HOME;
import static com.vincentwang.library.common.AouterConfig.MODULE_NEWS;
import static com.vincentwang.library.common.AouterConfig.MODULE_USER;
import static com.vincentwang.library.common.Conts.ACTION_USER;
import static com.vincentwang.library.common.Conts.ACTION_X5;


public class MainActivity extends BaseActivity {


    @BindView(R.id.vp_main)
    ViewPager vp_Main;
    @BindView(R.id.bav_main)
    BottomNavigationView bav_Main;

    /**
     * 底部菜单
     */
    private MenuItem menuItem;

    BaseFragment homeFrag;
    BaseFragment zixunFrag;
    BaseFragment userFrag;


    FragmentAdapter adapter;

    @Override
    public int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        vp_Main.addOnPageChangeListener(mOnPageChangeListener);
        bav_Main.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void initData() {
        homeFrag = ARouterUtils.getFragment(MODULE_HOME);
        zixunFrag = ARouterUtils.getFragment(MODULE_NEWS);
        userFrag = ARouterUtils.getFragment(MODULE_USER);

        List<BaseFragment> list = new ArrayList<>();
        list.add(homeFrag);
        list.add(zixunFrag);
        list.add(userFrag);

        adapter = new FragmentAdapter(getSupportFragmentManager(), MainActivity.this, list);
        vp_Main.setAdapter(adapter);
    }

    @Override
    public void initEvent() {
    }

    @Override
    protected boolean regEvent() {
        return true;
    }


    @Override
    public void onEventBus(Event event) {
        super.onEventBus(event);
        switch (event.getAction()) {
            case ACTION_X5:
                Toast.makeText(MainActivity.this, event.getData().toString(), Toast.LENGTH_LONG).show();
                break;
            case ACTION_USER:
                Toast.makeText(MainActivity.this, event.getData().toString(), Toast.LENGTH_LONG).show();
                break;
        }
    }

    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @SuppressLint("ResourceType")
        @Override
        public void onPageSelected(int position) {
            if (menuItem != null) {
                menuItem.isChecked();
            } else {
                bav_Main.getMenu().getItem(0).setChecked(false);
            }
            menuItem = bav_Main.getMenu().getItem(position);
            menuItem.setChecked(true);
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {

                @Override
                public boolean onNavigationItemSelected(MenuItem item) {
                    //item.getOrder()对应menu里的orderInCategory属性值
                    vp_Main.setCurrentItem(item.getOrder());
                    return true;
                }
            };

}


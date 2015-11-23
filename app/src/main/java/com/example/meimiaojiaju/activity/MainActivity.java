package com.example.meimiaojiaju.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.example.meimiaojiaju.R;
import com.example.meimiaojiaju.fragment.ClassifyFragment;
import com.example.meimiaojiaju.fragment.MineFragment;
import com.example.meimiaojiaju.fragment.PlasterFragment;
import com.example.meimiaojiaju.fragment.SaleFragment;
import com.example.meimiaojiaju.fragment.ShoppingFragment;

///
public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup rg_checked;
    private FrameLayout frameLayout_fragment;
    private FragmentManager manager;
    private Fragment lastFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    //
    private void init() {
        //fragment占位布局
        frameLayout_fragment = (FrameLayout) findViewById(R.id.layout_fragment);
        rg_checked = (RadioGroup) findViewById(R.id.rg_checked);
        rg_checked.setOnCheckedChangeListener(this);
        //初始化FragmentManager
        manager = getSupportFragmentManager();
        //默认点击第一个按钮，选中第一个页面
        rg_checked.getChildAt(0).performClick();
    }

    //RidaoGroup的监听事件，实现页面选择
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(lastFragment != null) {
            manager.beginTransaction().hide(lastFragment).commit();
        }
        switch (checkedId){
            case R.id.rb_sale:
                SaleFragment saleFragment = (SaleFragment) manager.findFragmentByTag("sale");
                if(saleFragment == null){
                    saleFragment = new SaleFragment();
                    manager.beginTransaction().add(R.id.layout_fragment, saleFragment, "sale").commit();
                }else{
                    manager.beginTransaction().show(saleFragment).commit();
                }
                lastFragment = saleFragment;
                break;
            case R.id.rb_classify:
                ClassifyFragment classifyFragment = (ClassifyFragment) manager.findFragmentByTag("classify");
                if(classifyFragment == null){
                    classifyFragment = new ClassifyFragment();
                    manager.beginTransaction().add(R.id.layout_fragment, classifyFragment, "classify").commit();
                }else{
                    manager.beginTransaction().show(classifyFragment).commit();
                }
                lastFragment = classifyFragment;
                break;
            case  R.id.rb_plaster:
                PlasterFragment plasterFragment = (PlasterFragment) manager.findFragmentByTag("plaster");
                if(plasterFragment == null){
                    plasterFragment = new PlasterFragment();
                    manager.beginTransaction().add(R.id.layout_fragment, plasterFragment, "plaster").commit();
                }else{
                    manager.beginTransaction().show(plasterFragment).commit();
                }
                lastFragment = plasterFragment;
                break;
            case  R.id.rb_shopping:
                ShoppingFragment shoppingFragment = (ShoppingFragment) manager.findFragmentByTag("shopping");
                if(shoppingFragment == null){
                    shoppingFragment = new ShoppingFragment();
                    manager.beginTransaction().add(R.id.layout_fragment, shoppingFragment, "shopping").commit();
                }else{
                    manager.beginTransaction().show(shoppingFragment).commit();
                }
                lastFragment = shoppingFragment;
                break;
            case  R.id.rb_mine:
                MineFragment mineFragment = (MineFragment) manager.findFragmentByTag("mine");
                if(mineFragment == null){
                    mineFragment = new MineFragment();
                    manager.beginTransaction().add(R.id.layout_fragment, mineFragment, "mine").commit();
                }else{
                    manager.beginTransaction().show(mineFragment).commit();
                }
                lastFragment = mineFragment;
                break;
        }
    }
}

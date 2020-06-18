package com.namsangmi.learning.ui.base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.namsangmi.learning.base.DraggerBaseActivity;
import javax.inject.Inject;


public abstract class BaseActivity<T extends BasePresenter> extends DraggerBaseActivity implements IBaseView {

    @Inject
    public T mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
        }
        initView();
    }


    /**
     * 初始化
     */
    protected abstract void initView();

    /**
     * 获取布局id
     *
     * @return
     */
    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }
}

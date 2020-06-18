package com.namsangmi.learning.ui.main;

import android.os.Bundle;
import android.widget.Toast;
import com.namsangmi.learning.R;
import com.namsangmi.learning.ui.base.BaseActivity;

public class MainActivity extends BaseActivity<MainPresenter> implements IMainView {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void initView() {
        mPresenter.getMessage();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.main_activity;
    }

    @Override
    public void showToast(String mesassage) {
        Toast.makeText(this, mesassage, Toast.LENGTH_LONG).show();
    }
}

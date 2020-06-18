package com.namsangmi.learning.ui.main;

import android.util.Log;

import com.namsangmi.learning.ui.base.BasePresenter;

import javax.inject.Inject;

public class MainPresenter extends BasePresenter<IMainView> {

    private final MainModel model;

    @Inject
    public MainPresenter(MainActivity view, MainModel model) {
        this.mView = view;
        this.model = model;
    }

    public void getMessage() {
        this.mView.showToast(model.getBottle().toString());
    }
}

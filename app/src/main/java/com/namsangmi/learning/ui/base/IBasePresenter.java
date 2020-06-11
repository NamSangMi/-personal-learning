package com.namsangmi.learning.ui.base;

public interface IBasePresenter<V extends IBaseView> {
    void attachView(V view);
}



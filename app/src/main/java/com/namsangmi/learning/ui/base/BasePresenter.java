package com.namsangmi.learning.ui.base;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.namsangmi.learning.utils.RxDisposableManager;

public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter<V>, LifecycleObserver {

    protected V mView;
    public RxDisposableManager rxDisposableManager = new RxDisposableManager();

    @Override
    public void attachView(V view) {
        this.mView = view;
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    @Override
    public void detachView() {
        this.mView = null;
        rxDisposableManager.clear();
    }

}

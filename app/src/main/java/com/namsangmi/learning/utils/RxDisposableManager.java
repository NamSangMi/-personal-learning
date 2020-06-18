package com.namsangmi.learning.utils;

import javax.inject.Inject;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

public class RxDisposableManager {

    @Inject
    public RxDisposableManager(){}

    CompositeDisposable compositeDisposable = new CompositeDisposable();

    public void add(Disposable d) {
        compositeDisposable.add(d);
    }

    public void clear() {
        compositeDisposable.dispose();
    }
}

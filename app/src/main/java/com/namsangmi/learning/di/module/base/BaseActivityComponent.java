package com.namsangmi.learning.di.module.base;

import com.namsangmi.learning.base.DraggerBaseActivity;
import com.namsangmi.learning.di.module.MainActivityModule;
import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Subcomponent(modules = {
        MainActivityModule.class,
        AndroidInjectionModule.class
})
public interface BaseActivityComponent extends AndroidInjector<DraggerBaseActivity> {

    @Subcomponent.Factory
    public interface Factory extends AndroidInjector.Factory<DraggerBaseActivity> {
    }
}

package com.namsangmi.learning.di.module.base;


import com.namsangmi.learning.ui.main.MainActivity;
import com.namsangmi.learning.di.module.MainActivityModule;
import com.namsangmi.learning.di.scope.ActivityScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(subcomponents = {
        BaseActivityComponent.class
})
public abstract class AllActivitiesModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity contributeMainActivitytInjector();

}

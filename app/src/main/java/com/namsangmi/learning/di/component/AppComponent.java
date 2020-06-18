package com.namsangmi.learning.di.component;

import com.namsangmi.learning.PLApplication;
import com.namsangmi.learning.di.module.AppModule;
import com.namsangmi.learning.di.module.base.AllActivitiesModule;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {
        AppModule.class,
        AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class,
        AllActivitiesModule.class
})
public interface AppComponent {
    void inject(PLApplication application);
}

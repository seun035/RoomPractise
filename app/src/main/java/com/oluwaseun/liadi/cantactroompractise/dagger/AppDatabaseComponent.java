package com.oluwaseun.liadi.cantactroompractise.dagger;

import com.oluwaseun.liadi.cantactroompractise.MainActivity;

import dagger.Component;

@Component(modules = AppDatabaseModule.class)
public interface AppDatabaseComponent {

    void inject(MainActivity mainActivity);
}

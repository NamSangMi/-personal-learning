package com.namsangmi.learning.ui.main;

import com.namsangmi.learning.bean.Bottle;
import com.namsangmi.learning.ui.base.IBaseMode;

import javax.inject.Inject;


public class MainModel implements IBaseMode {

    private Bottle mBottle;

    @Inject
    public MainModel(Bottle bottle) {
        this.mBottle = bottle;
    }

    public Bottle getBottle() {
        return mBottle;
    }
}

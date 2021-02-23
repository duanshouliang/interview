package com.dsl.code.callback;

import java.util.concurrent.Semaphore;

public class CommonEmployee extends Employee {
    @Override
    public void reportTask(Callback callBack) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        callBack.report("10%");
    }
}

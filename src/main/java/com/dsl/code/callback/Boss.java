package com.dsl.code.callback;

public class Boss implements Callback {
    @Override
    public void report(String msg) {
        System.out.println("Job process " + msg);
    }

    public void assignTask(Employee e){
        e.reportTask(this);
    }
}

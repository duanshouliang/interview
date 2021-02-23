package com.dsl.code.callback;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {
//        Boss boss = new Boss();
//        CommonEmployee commonEmployee = new CommonEmployee();
//        boss.assignTask(commonEmployee);
//
//        new ConcurrentHashMap<>();
//        new HashMap<>();

        String key = "d";
        int h;
        //hashcode值与其无符号右移16的结果做异或操作
        int hash = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        System.out.println(key.hashCode());
        System.out.println(100>>>16);
        System.out.println(100^(100>>>16));
        System.out.println(hash);
    }
}

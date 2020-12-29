package com.dsl.interview.summation;

import java.util.*;

public class DeviationSummation {
    public static void main(String[] args) {
        Integer[] items = new Integer[]{1, 2, 3, 4, 6};
        Integer target = 9;
        sum(items, target);
    }

    public static void sum(Integer[] items, Integer target) {
        if (null == target || null == items || items.length == 0) {
            return;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < items.length; i++) {
            if(map.containsKey(target - items[i])){
                System.out.println(map.get(target-items[i]) +", "+ i);
            }
            map.put(items[i], i);
        }
    }
}

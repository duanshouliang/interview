package com.dsl.interview.summation;

public class ForceSummation {
    public static void main(String[] args) {
        Integer[] items = new Integer[]{1,2,3,4,6};
        Integer target = 9;
        sum(items, target);
    }

    public static void sum(Integer[] items, Integer target) {
        if (null == target || null == items || items.length == 0) {
            return;
        }
        for (int i = 0; i < items.length; i++) {
            for (int j = i + 1; j < items.length; j++) {
                if (items[i] + items[j] == target.intValue()) {
                    System.out.println("i=" + i + ", j=" + j);
                }
            }
        }
    }
}

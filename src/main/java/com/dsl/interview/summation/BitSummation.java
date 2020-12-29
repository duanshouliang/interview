package com.dsl.interview.summation;

public class BitSummation {
    public static void main(String[] args) {
        Integer[] items = new Integer[]{1, 2, 3, 4, 6};
        Integer target = 9;
        sum(items, target);
    }


    public static void sum(Integer[] items, Integer target) {
        if (null == target || null == items || items.length == 0) {
            return;
        }
        int volume = 2 << 2;
        int bitNum = volume -1;
        int []res = new int[volume];
        for(int i=0;i<items.length;i++){
            int c = (target - items[i]) & bitNum;
            if(res[c] != 0){
                System.out.println(res[c] -1 +", " + i);
            }
            res[items[i]&bitNum] = i+1;
        }
    }

}

package com.dsl.sort.bubble;


/**
 * 冒泡排序
 *
 */
public class BubbleSort {
    public static void sort(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[j - 1] >= arr[j]) {
                    swap(arr, j, j - 1);
                }
                count++;
            }
        }
        System.out.println("times: " + count);
    }

    public static void sort2(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {   //需要n趟
            for (int j = 0; j < arr.length - i - 1; j++) {//没一趟确定一个元素，确定后的元素不需要在做比较交换
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j + 1, j);
                }
                count++;
            }
        }
        System.out.println("times: " + count);
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 2, 0, 1};
        sort2(arr);
        print(arr);
    }
}

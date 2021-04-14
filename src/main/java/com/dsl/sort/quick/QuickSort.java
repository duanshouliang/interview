package com.dsl.sort.quick;


import java.util.Arrays;
import java.util.Random;

/**
 * 内排序算法
 * 不稳定的排序算法
 * 分治策略
 */
public class QuickSort {
    private static Random rand = new Random();
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 0, 5, 9, 1, 6};
//        sort(nums, 0, nums.length - 1);
//        quickSort(nums);
        int[] nums2 = kClosest(nums, nums.length-2);
        print(nums2);
    }

    public static void sort(int[] nums, int left, int right) {
        int i = left;
        int j = right;
        int pivot = nums[left];

//        int pivot = nums[(left+right)/2] ;不能直接这样操作

        while (i < j) {
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            if (i < j) {
                swap(nums, i, j);
            }
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        if (i != left) {
            sort(nums, left, i - 1);
        }
        if (j != right) {
            sort(nums, j + 1, right);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }
    }



    public static void quickSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }

        quickSort(arr,0,arr.length-1);
    }

    public static void quickSort(int[] arr,int left,int right){
        if (left < right){      //不越界

            //以数组最后一个数为“基准”，随机在数组取一个数，与最后一个数做交换。
            swap(arr,left + (int)(Math.random()*(right - left + 1)),right);

            //分层 <区 =区 >区
            int[] p = partition(arr,left,right);

            //递归，小于区递归，大于区递归
            quickSort(arr,left,p[0]-1);     //p[0]是分层后的数组 等于区的左边界 p[0]-1是 小于区的最后一个元素
            quickSort(arr,p[1]+1,right);     //p[1]是分层后的数组 等于区的右边界 p[1]+1是 大于区的第一个元素
        }
    }

    //荷兰国旗是以target目标值 作为划分
    //快速排序是以数组最右位置上的元素arr[R] 作为划分
    public static int[] partition(int[] arr,int left,int right){
        int less = left - 1;    //小于区的右边界
        int more = right;       //大于区的左边界
        int when = left;        //when代表当前值
        while (when < more){
            if (arr[when] < arr[right]){    //当前值 ＜ 基准值
                swap(arr,++less,when++);
            }else if (arr[when] > arr[right]){
                swap(arr,--more,when);
            }else
                when++;
        }
        //此时已经分好区，把最后一个元素与＞区第一个元素交换，得到左边：＜基准值的区域，中间=基准值的区域，右边：＞基准值的区域
        swap(arr,more,right);

        int[] res = {less + 1,more};
        return res;
    }


    public static int[] kClosest(int[]nums, int K) {
        int n = nums.length;
        random_select(nums, 0, n - 1, K);
        return Arrays.copyOfRange(nums, 0, K);
    }
    public static void random_select(int[] nums, int left, int right, int K) {
        int pivotId = left + rand.nextInt(right - left + 1);
        int pivot = nums[pivotId];
        swap(nums, right, pivotId);
        int i = left - 1;
        for (int j = left; j < right; ++j) {
            if (nums[j] <= pivot) {
                ++i;
                swap(nums, i, j);
            }
        }
        ++i;
        swap(nums, i, right);
        // [left, i-1] 都小于等于 pivot, [i+1, right] 都大于 pivot
        if (K < i - left + 1) {
            random_select(nums, left, i - 1, K);
        } else if (K > i - left + 1) {
            random_select(nums, i + 1, right, K - (i - left + 1));
        }
    }
}

package com.dsl.interview;

import java.util.*;
import java.util.stream.Collectors;

public class StringDemo {
    /**
     * 最长无重复子串, 双指针实现
     */
    public static int longestNoDuplicateSubstringSolution(String str) {
        if (null == str || "".equals(str)) {
            return 0;
        }
        int left = 0;
        int right = 1;
        int max = 1;
        while (right < str.length()) {
            for (int i = left; i < right; i++) {
                if (str.charAt(right) == str.charAt(i)) {
                    left = i + 1;
                    break;
                }
            }
            right++;
            max = max < right - left ? right - left : max;
        }
        return max;
    }


    /**
     * hash实现
     *
     * @param str
     * @return
     */
    public static int longestNoDuplicateSubstringSolution2(String str) {
        if (null == str || "".equals(str)) {
            return 0;
        }
        int max = 1;
        int left = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                left = Math.max(map.get(str.charAt(i)) + 1, left);
            }
            max = i - left + 1 > max ? i - left + 1 : max;
            map.put(str.charAt(i), i);
        }
        return max;
    }

    /**
     * 异位词组分组：计数法
     *
     * @param strs
     * @return
     */
    public static List<List<String>> ectopicStringGrouping(List<String> strs) {
        return new ArrayList<>(strs.stream().collect(Collectors.groupingBy(str -> {
            int[] counter = new int[26];
            for (int i = 0; i < str.length(); i++) {
                counter[str.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                if (counter[i] != 0) {
                    sb.append((char)('a' + i)).append(i);
                }
            }
            return sb.toString();
        })).values());
    }

    /**
     * 异位词组分组：排序分组法
     *
     * @param strs
     * @return
     */
    public static List<List<String>> ectopicStringGrouping2(List<String> strs) {
        return new ArrayList<>(strs.stream().collect(Collectors.groupingBy(str -> {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        })).values());
    }


    public static void main(String[] args) {
//        System.out.println(longestNoDuplicateSubstringSolution2("aaabaabc"));
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("bca");
        list.add("bac");
        list.add("ea");
        list.add("ae");
        System.out.println(ectopicStringGrouping2(list));
    }
}

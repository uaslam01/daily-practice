package com.leetcode.dailypractice.year24.jun.week2;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Consumer;

public class SolutionTuesday0611 {
    //Mine Solution / Best Solution
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: arr1){
            if(map.containsKey(n)){
                map.put(n, map.get(n)+1);
            } else {
                map.put(n, 1);
            }
        }
        int j = 0;
        int count = map.get(arr2[0]);
        int i= 0;
        for(; i < arr1.length; i++){
            if(count == 0){
                map.remove(arr2[j]);
                j++;
                if(arr2.length==j)
                    break;
                count = map.get(arr2[j]);
            }
            arr1[i] = arr2[j];
            count--;
        }

        if(!map.isEmpty()){
            TreeMap<Integer,Integer> map2 = new TreeMap<>(map);
            int val = map2.firstKey();
            count = map2.get(val);
            for(; i < arr1.length; i++){
                if(count == 0){
                    map2.remove(val);
                    val = map2.firstKey();
                    count = map2.get(val);
                }
                arr1[i] = val;
                count--;            }
        }
        return arr1;
    }

    //Best Solution 2
    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        int[] cnt=new int[1001];
        for(int i:arr1){
            cnt[i]++;
        }
        int[] ans=new int[arr1.length];
        int i=0;
        for(int n:arr2){
            while(cnt[n]>0){
                ans[i]=n;
                cnt[n]--;
                i++;
            }
        }
        for(int j=0;j<cnt.length;j++){
            while(cnt[j]>0){
                ans[i]=j;
                cnt[j]--;
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] arg) {
        var obj = new SolutionTuesday0611();
        Consumer< ?super int[]> arrayConsumer = x -> Arrays.stream(x).forEach(System.out::println);
        arrayConsumer.accept(obj.relativeSortArray(new int[] {2,3,1,3,2,4,6,7,9,2,19}, new int[]{2,1,4,3,9,6}));
        System.out.println();
        arrayConsumer.accept(obj.relativeSortArray(new int[] {28,6,22,8,44,17}, new int[]{28,6,22,8}));


    }
    }

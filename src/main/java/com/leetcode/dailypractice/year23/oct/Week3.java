package com.leetcode.dailypractice.year23.oct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Week3 {
    public int constrainedSubsetSum(int[] nums, int k) {
		List<Integer> list = new ArrayList<>();
		List<Integer> neglist = new ArrayList<>();
		int currSum =0 ;
		for(int i=0;i<nums.length;i++) {
        	if(nums[i]>=0) {
        		if(neglist.size()>=k&&!list.isEmpty()) {
        			List<Integer> subList = findKMinimum(neglist, k);
        			currSum+=subList.stream().mapToInt(Integer::intValue).sum();
        			if(currSum>0){
            			list.addAll(subList);
        			} else {
        				currSum=0;
        				list.clear();
        			}
        		}
        		currSum+=nums[i];
    			list.add(nums[i]);    	
        		neglist.clear();
        	} else {
        		neglist.add(nums[i]);
        	}
        }
        return list.isEmpty()?Arrays.stream(nums).max().orElse(0):list.stream().mapToInt(Integer::intValue).sum();
    }
    
    private List<Integer> findKMinimum(List<Integer> neglist, int k) {
    	List<Integer>[] listArr = new List[k];
    	for(int i=0;i<k;i++) {
    		listArr[i]=new ArrayList<>();
    	}
    	for(int i=0;i<neglist.size();i++) {
    		listArr[i%k].add(neglist.get(i));
    	}
    	int minArrSum= listArr[0].stream().mapToInt(Integer::intValue).sum();
    	int minArrInd = 0;
    	for(int i=1;i<listArr.length;i++) {
    		int sum = listArr[i].stream().mapToInt(Integer::intValue).sum();
    		if(sum>minArrSum) {
    			minArrInd = i;
    		}
    	}
		
		return listArr[minArrInd];
	}

//    private List<Integer> findKMinimumDP(List<Integer> neglist, int k, int index) {
//    	
//    	if(index==0)
//    		return 0;
//    	
//    	int minArrSum= listArr[0].stream().mapToInt(Integer::intValue).sum();
//    	int minArrInd = 0;
//    	for(int i=1;i<listArr.length;i++) {
//    		int sum = listArr[i].stream().mapToInt(Integer::intValue).sum();
//    		if(sum>minArrSum) {
//    			minArrInd = i;
//    		}
//    	}
//		
//		return listArr[minArrInd];
//	}
	public static void main(String[] args) {
    	System.out.println(new Week3().constrainedSubsetSum(new int []{-8269,3217,-4023,-4138,-683,6455,-3621,9242,4015,-3790}, 1));
    }
}

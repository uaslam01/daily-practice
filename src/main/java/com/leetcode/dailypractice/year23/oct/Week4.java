package com.leetcode.dailypractice.year23.oct;

public class Week4 {
    public int maximumScore(int[] nums, int k) {
    	int i = leftMoveDP(nums, k, k-1,k, k,k);
    	int j = rightMoveDP(nums, k, k+1,k,k,k);
    	int res=nums[i];
    	for(int r=i+1;r<=j;r++) {
    		if(nums[r]<res) {
    			res=nums[r];
    		}
    	}
    	return res*(j-i+1);
    }

    public int leftMoveDP(int[] nums, int k, int i, int curMinInd, int selectMinInd, int leftind) {
    	int noOfElements = k-i+1;
    	if(i==-1) {
    		return leftind;
    	}
    	
    	if(nums[i]<nums[curMinInd]) {
    		curMinInd = i;
    		if(nums[selectMinInd]*(k-leftind+1)<nums[curMinInd]*noOfElements) {
    			selectMinInd = i;
    			leftind =i;
    		} 
		}else {
			if(selectMinInd!=curMinInd) {
				if(nums[selectMinInd]*(k-leftind+1)<nums[curMinInd]*noOfElements) {
	    			selectMinInd = curMinInd;
	    			leftind = i;
	    		}	
			} else {
				leftind--;
			}    			
		}
		return leftMoveDP(nums, k, i-1, curMinInd, selectMinInd, leftind);

	
    }
    public int rightMoveDP(int[] nums, int k, int j, int curMinInd, int selectMinInd, int rightind) {
    	int noOfElements = j-k+1;
    	if(j==nums.length) {
    		return rightind;
    	}
    	
    	if(nums[j]<nums[curMinInd]) {
    		curMinInd = j;
    		if(nums[selectMinInd]*(rightind-k+1)<nums[curMinInd]*noOfElements) {
    			selectMinInd = j;
    			rightind =j;
    		} 
		}else {
			if(selectMinInd!=curMinInd) {
				if(nums[selectMinInd]*(rightind-k+1)<nums[curMinInd]*noOfElements) {
	    			selectMinInd = curMinInd;
	    			rightind = j;
	    		}	
			} else {
				rightind++;
			}    			
		}
		return rightMoveDP(nums, k, j+1, curMinInd, selectMinInd, rightind);

	
    }
	public static void main(String[] args) {
    	System.out.println(new Week4().maximumScore(new int []{6569,9667,3148,7698,1622,2194,793,9041,1670,1872}, 5));
//    	System.out.println(new Week4().maximumScore(new int []{5,5,4,5,4,1,1,1}, 0));
		
	}
    /** First did without DP consideration
    public int leftMove(int[] nums, int k) {
    	int res=k;
    	int noOfElements=1;
    	int minVal= nums[k];
    	for(int i=k-1; i>=0;i--) {
    		if(minVal>nums[i]) {
    			if(nums[i]*(noOfElements+1)>=minVal) {
        			minVal = nums[i];
    			} else {
    				res=i+1;
    				break;
    			}
    			
    		} 
			noOfElements++;
			res=i;
    	}
    	return res;
    }

    public int rightMove(int[] nums, int k) {
    	int res=k;
    	int noOfElements=1;
    	int minVal= nums[k];
    	for(int i=k+1; i<nums.length;i++) {
    		if(minVal>nums[i]) {
    			if(nums[i]*(noOfElements+1)>=minVal) {
        			minVal = nums[i];
    			} else {
    				res=i-1;
    				break;
    			}
    			
    		} 
			noOfElements++;
			res=i;
    	}
    	return res;
    }*/
 
    


}
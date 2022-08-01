// Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, 
// find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.
// For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3. You can modify the input array in-place.

import java.util.*;

class LowestPositiveMissingInteger {
    public static int max(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        //System.out.println("max: " + max);
        return max;
    }

    public static int min(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        //System.out.println("min: " + min);
        return min;
    }
    
    public static int sumOfExpected(int[] nums) {
         int n = nums.length;
        int min = min(nums);
        int max = max(nums);
        int sum2 = 0;
        for(int i = min; i <= max; i++) {
            sum2 += i;
        }
        // System.out.println("sum2 :" + sum2);
        return sum2;
    }
    
    public static int sumOfGiven(int[] nums) {
        int n = nums.length;
        int sum1 = 0;
        for(int i = 0 ; i < n; i++) {
            sum1 += nums[i];
        }
        // System.out.println("sum1: " + sum1);
        return sum1;
    }

	// Function to find the missing number
	public static int getMissingNo(int[] arr, int n) {
	    int sum1 = sumOfExpected(arr);
	   // System.out.println("sum1: " + sum1);
	    int sum2 = sumOfGiven(arr);
	    if(sum1 == sum2) {
	        return sum1;
	    }
	   // System.out.println("sum2: " + sum2);
		int result = Math.abs(sum1 - sum2);
// 		System.out.println("result: " + result);
		return result;
	}
	public static void main(String[] args)
	{
		int[] arr = {3, 4, 1, -1};
		int n = arr.length;
		int ans = getMissingNo(arr, n);
        System.out.println("ans :" + ans);
	}
}

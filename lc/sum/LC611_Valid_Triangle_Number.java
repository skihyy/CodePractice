package com.yuyang.he.lc.sum;

import java.util.Arrays;

public class LC611_Valid_Triangle_Number
{

    public static void main(String[] args)
    {
        System.out.println(new LC611_Valid_Triangle_Number().triangleNumber(new int[] { 2, 2, 3, 4 }));
    }

    public final int triangleNumber(final int[] nums) {
        Arrays.sort(nums); // O(nlogn)
        int count = 0;
        // similar to 3 sum
        for(int i = nums.length - 1; 2 <= i; i--) {
            int left = 0, right = i - 1;
            while(left < right)
                if(nums[left] + nums[right] > nums[i]) {
                    count += right - left;
                    right--;
                } else
                    left++;
        }
        return count;
    }
}

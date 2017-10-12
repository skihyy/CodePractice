package com.yuyang.he.lc.numbers;

public class LC360_Sort_Transformed_Array
{

    public static void main(String[] args)
    {
        final int [] r = new LC360_Sort_Transformed_Array().sortTransformedArray(new int[] { -4, -2, 2, 4 }, 1, 3, 5);
        for(final int i : r)
            System.out.print(i + " ");
    }
    
    // a > 0, ax^2 + c > bx => smallest element at the 2 sides of nums
    // a < 0, ax^2 + c < bx => largest element at the 2 sides of nums
    public final int[] sortTransformedArray(final int[] nums, final int a, final int b, final int c) {
        if(null == nums || 0 == nums.length)
            return new int[]{};
        final int [] result = new int[nums.length];
        int left = 0, right = nums.length - 1, index = a > 0 ? nums.length - 1 : 0;
        while(left <= right) {
            final int l = compute(nums[left], a, b, c), r = compute(nums[right], a, b, c);
            if(0 < a) {
                result[index--] = l < r ? r : l;
                left += l < r ? 0 : 1;
                right -= l < r ? 1 : 0;
            } else {
                result[index++] = l < r ? l : r;
                left += l < r ? 1 : 0;
                right -= l < r ? 0 : 1;
            }
        }
        
        return result;
    }
    
    private int compute(final int x, final int a, final int b, final int c) {
        return a * x * x + b * x + c;
    }

}

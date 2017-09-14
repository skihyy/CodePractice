package com.yuyang.he.lc.tree;

import com.yuyang.he.vo.TreeNode;

public class LC108_Convert_Sorted_Array_To_Binary_Search_Tree
{

    public static void main(String[] args)
    {
        LC108_Convert_Sorted_Array_To_Binary_Search_Tree lc108 = new LC108_Convert_Sorted_Array_To_Binary_Search_Tree();
        System.out.println(lc108.sortedArrayToBST(new int[]{1,2,3,4,5}));
    }
    
    public TreeNode sortedArrayToBST(final int[] nums) {
        return 0 == nums.length ? null : helper(0, nums.length - 1, nums);
    }
    
    private TreeNode helper(final int start, final int end, final int [] nums) {
        if(start > end)
            return null;
        
        final int mid = (start + end) / 2;        
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(start, mid - 1, nums);
        root.right = helper(mid + 1, end, nums);
        
        return root;
    }

}

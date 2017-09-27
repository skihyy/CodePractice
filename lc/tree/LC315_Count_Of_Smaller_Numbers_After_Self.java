package com.yuyang.he.lc.tree;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LC315_Count_Of_Smaller_Numbers_After_Self
{

    public static void main(String[] args)
    {
        List<Integer> l = new LC315_Count_Of_Smaller_Numbers_After_Self().countSmaller(new int[] {-1,-1});
        // .countSmaller(new int[] { 26, 78, 27, 100, 33, 67, 90, 23, 66, 5, 38,
        // 7, 35, 23, 52, 22, 83, 51, 98, 69,
        // 81, 32, 78, 28, 94, 13, 2, 97, 3, 76, 99, 51, 9, 21, 84, 66, 65, 36,
        // 100, 41 });
        for (int i = 0; i < l.size(); i++)
            System.out.print(l.get(i) + ", ");
    }

    public final List<Integer> countSmaller(final int[] nums) {
        final int[] result = new int[nums.length];
        TreeNode root = null;
        for (int i = nums.length - 1; 0 <= i; i--)
            root = helper(root, nums, result, i, 0);
        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }

    // preSum is the sum of previous level
    private TreeNode helper(TreeNode root, final int[] nums, final int[] res, final int index, final int preSum) {
        if (null == root) {
            root = new TreeNode(nums[index], 0);
            res[index] = preSum;
        } else if (root.val == nums[index]) {
            root.duplicates++;
            res[index] = preSum + root.sum;
        } else if (root.val > nums[index]) {
            root.sum++;
            root.left = helper(root.left, nums, res, index, preSum);
        } else
            root.right = helper(root.right, nums, res, index, preSum + root.duplicates + root.sum);
        return root;
    }

    final class TreeNode {
        int val, sum, duplicates = 1; // sum is the number of nodes on its left
                                      // side
        TreeNode left, right;

        TreeNode(final int x, final int y) {
            val = x;
            sum = y;
        }
    }
}

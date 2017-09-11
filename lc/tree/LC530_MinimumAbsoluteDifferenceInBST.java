package com.yuyang.he.lc.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.yuyang.he.vo.TreeNode;

/**
 * @author yuyanghe
 * @date 2017年2月28日
 * @version 1.0
 * @since 2017年2月28日
 */
public class LC530_MinimumAbsoluteDifferenceInBST
{

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        System.out.println(new LC530_MinimumAbsoluteDifferenceInBST().getMinimumDifference(root));
    }

    public int getMinimumDifference(TreeNode root)
    {
        List<Integer> values = new ArrayList<Integer>();
        helper(root, values);
        Integer [] array = (Integer[]) values.toArray(new Integer[values.size()]);
        Arrays.sort(array);
        int[] diff = new int[array.length - 1];
        for (int i = 1; i < array.length; i++)
            diff[i - 1] = array[i] - array[i - 1];
        return Arrays.stream(diff).reduce(Integer.MAX_VALUE, (a, b) -> Integer.min(a, b));
    }

    private void helper(TreeNode root, List<Integer> values)
    {
        if (null == root)
            return;
        values.add(root.val);
        if (null != root.left)
            helper(root.left, values);
        if (null != root.right)
            helper(root.right, values);
    }

}

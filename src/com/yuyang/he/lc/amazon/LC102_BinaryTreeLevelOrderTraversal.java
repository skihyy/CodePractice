package com.yuyang.he.lc.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuyanghe
 * @date 2017年1月15日
 * @version 1.0
 * @since 2017年1月15日
 */
public class LC102_BinaryTreeLevelOrderTraversal
{
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, root, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, TreeNode root, int i)
    {
        if (null == root)
        {
            return;
        }

        if (i + 1 > res.size())
        {
            res.add(new ArrayList<Integer>());
        }
        res.get(i).add(root.val);
        helper(res, root.left, i + 1);
        helper(res, root.right, i + 1);
    }

    static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x)
        {
            val = x;
        }
    }
}

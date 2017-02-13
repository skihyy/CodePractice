package com.yuyang.he.lc.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuyanghe
 * @date 2017年2月10日
 * @version 1.0
 * @since 2017年2月10日
 */
public class LC129_SumRootToLeafNumbers
{
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(new LC129_SumRootToLeafNumbers().sumNumbers(root));
    }

    public int sumNumbers(TreeNode root)
    {
        List<Integer> nodeNum = new ArrayList<Integer>();
        StringBuilder sb = new StringBuilder();
        helper(nodeNum, root, sb);
        return nodeNum.stream().mapToInt(Integer::intValue).sum();
    }

    private void helper(List<Integer> n, TreeNode r, StringBuilder sb)
    {
        if (null == r)
            return;
        // if not null
        sb.append(r.val);
        // if it is the leaf
        if (null == r.left && null == r.right)
        {
            if (0 != sb.length())
                n.add(Integer.parseInt(sb.toString()));
        }
        if (null != r.left)
            helper(n, r.left, sb);
        if (null != r.right)
            helper(n, r.right, sb);
        sb.setLength(sb.length() - 1);
    }

    static class TreeNode
    {
        TreeNode left, right;
        int val;

        TreeNode(int x)
        {
            val = x;
        }
    }

}

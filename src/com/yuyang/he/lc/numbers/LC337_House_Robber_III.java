package com.yuyang.he.lc.numbers;

import com.yuyang.he.vo.TreeNode;

public class LC337_House_Robber_III
{

    public static void main(String[] args)
    {
        System.out.println(new LC337_House_Robber_III().rob(new TreeNode("4,2,3")));
    }

    public int rob(TreeNode root)
    {
        return helper(root, 0, 0);
    }

    // rob - the maximum value if rob parent node
    // notRob - the maximum value if not rob parent node
    private int helper(TreeNode root, int rob, int notRob)
    {
        if (null == root)
            return Math.max(rob, notRob);
        // now current node (root) is not null
        // curRob - the value if rob current node, so the parent node cannot be
        // robbed
        int curRob = notRob + root.val;
        notRob = Math.max(notRob, rob);
        rob = curRob;
        return Math.max(helper(root.left, rob, notRob), helper(root.right, rob, notRob));
    }

}

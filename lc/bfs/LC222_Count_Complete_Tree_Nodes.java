package com.yuyang.he.lc.bfs;

import com.yuyang.he.vo.TreeNode;

public class LC222_Count_Complete_Tree_Nodes
{

    public static void main(String[] args)
    {
        System.out.println(new LC222_Count_Complete_Tree_Nodes().countNodes(new TreeNode("1,2,3,4,5,6")));
    }
    
    public final int countNodes(final TreeNode root) {
        if(null == root)
            return 0;
        int level = 0; // know the level of the tree
        TreeNode left = root;
        while(null != left) {
            left = left.left;
            level++;
        }
        
        return (int)Math.pow(2.0, (level - 1) * 1.0) - 1 + countLastLevel(level, root, 1);
    }
    
    private int countLastLevel(final int level, final TreeNode root, final int curLv) {
        if(level > curLv)
            return countLastLevel(level, root.left, curLv + 1) + countLastLevel(level, root.right, curLv + 1);
        return null == root ? 0 : 1;
    }

}

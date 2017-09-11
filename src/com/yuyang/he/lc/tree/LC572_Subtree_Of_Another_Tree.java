package com.yuyang.he.lc.tree;

import com.yuyang.he.vo.TreeNode;

public class LC572_Subtree_Of_Another_Tree
{

    public static void main(String[] args)
    {
        new LC572_Subtree_Of_Another_Tree().isSubtree(new TreeNode("3,4,5,1,2"), new TreeNode("4,1,2"));
    }
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return helper(s, t, t);
    }
    
    private boolean helper(final TreeNode s, final TreeNode t, final TreeNode oldT) {        
        if(null == t && null == s) {
            return true;
        } else if(null != s && null != t) {
            if(s.val == t.val) {
                return helper(s.left, t.left, oldT) && helper(s.right, t.right, oldT);
            } else {
                return helper(s.left, oldT, oldT) || helper(s.right, oldT, oldT);
            }
        } else {
            return false;
        }
    }

}

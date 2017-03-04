package com.yuyang.he.lc.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.yuyang.he.vo.TreeNode;

public class LC114_FlattenBinaryTreeToLinkedList
{

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);

        new LC114_FlattenBinaryTreeToLinkedList().flatten(root);

        System.out.println();
    }

    public void flatten(TreeNode root)
    {
        Queue<TreeNode> queue = new LinkedList<TreeNode> ();
        helper(queue, root);
        TreeNode head = root, tmp;
        while(!queue.isEmpty())
        {
            tmp = queue.poll();
            head.right = tmp;
            head.left = null;
            head = head.right;
        }
        if(null != head)
            head.left = head.right = null;
    }

    private void helper(Queue<TreeNode> queue, TreeNode root)
    {
        if(null == root)
            return;
        if(null != root.left)
        {
            queue.add(root.left);
            helper(queue, root.left);
        }
        if(null != root.right)
        {
            queue.add(root.right);
            helper(queue, root.right);
        }
    }
}

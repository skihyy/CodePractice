package com.yuyang.he.lc.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.yuyang.he.vo.TreeNode;

/**
 * @author yuyanghe
 * @date 2017年1月19日
 * @version 1.0
 * @since 2017年1月19日
 */
public class LC173_BinarySearchTreeIterator
{
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(10);
        root.right.right = new TreeNode(15);
        LC173_BinarySearchTreeIterator i = new LC173_BinarySearchTreeIterator(root);
        while (i.hasNext())
        {
            System.out.println(i.next());
        }
    }

    Queue<Integer> queue;

    public LC173_BinarySearchTreeIterator(TreeNode root)
    {
        queue = new LinkedList<Integer>();
        if (null != root)
        {
            helper(root);
        }
    }

    private void helper(TreeNode root)
    {
        if (null != root.left)
        {
            helper(root.left);
        }
        queue.add(root.val);
        if (null != root.right)
        {
            helper(root.right);
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext()
    {
        return !queue.isEmpty();
    }

    /** @return the next smallest number */
    public int next()
    {
        return queue.isEmpty() ? 0 : queue.poll();
    }
}

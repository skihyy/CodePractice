package com.yuyang.he.vo;

import java.util.LinkedList;
import java.util.Queue;

import com.yuyang.he.lc.tree.LC449_SerializeAndDeserializeBST;

/**
 * @author yuyanghe
 * @date 2017年2月28日
 * @version 1.0
 * @since 2017年2月28日
 */
public class TreeNode
{
    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(int x)
    {
        val = x;
    }

    public TreeNode(String data)
    {
        if (null == data || 0 == data.length())
            return;

        String[] nodes = data.split(",");
        if (0 == nodes.length || "null".equals(nodes[0]))
            return;

        this.val = Integer.parseInt(nodes[0]);
        TreeNode tmp = null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(this);
        int index = 1;
        while (!queue.isEmpty() && nodes.length > index)
        {
            tmp = queue.poll();
            // left node
            if (nodes.length > index && !"null".equals(nodes[index]))
            {
                tmp.left = new TreeNode(Integer.parseInt(nodes[index]));
                queue.add(tmp.left);
            }
            index++;
            // right node
            if (nodes.length > index && !"null".equals(nodes[index]))
            {
                tmp.right = new TreeNode(Integer.parseInt(nodes[index]));
                queue.add(tmp.right);
            }
            index++;
        }
    }

    public String toString()
    {
        return new LC449_SerializeAndDeserializeBST().serialize(this);
    }
}

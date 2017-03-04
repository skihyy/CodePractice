package com.yuyang.he.lc.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.yuyang.he.vo.TreeNode;

/**
 * @author yuyanghe
 * @date 2017年3月3日
 * @version 1.0
 * @since 2017年3月3日
 */
public class LC449_SerializeAndDeserializeBST
{

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        LC449_SerializeAndDeserializeBST sd = new LC449_SerializeAndDeserializeBST();
        System.out.println(sd.serialize(root));
        // System.out.println(sd.deserialize("5,4,7,3,null,2,null,-1,null,9,null,"));
        System.out.println(sd.serialize(sd.deserialize(sd.serialize(root))));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root)
    {
        if (null == root)
            return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode tmp = null, nullNode = new TreeNode(Integer.MIN_VALUE);
        while (!queue.isEmpty())
        {
            tmp = queue.poll();
            if (Integer.MIN_VALUE != tmp.val)
                sb.append(tmp.val);
            else
                sb.append("null");
            sb.append(",");
            if (Integer.MIN_VALUE != tmp.val)
            {
                if (null != tmp.left)
                    queue.add(tmp.left);
                else
                    queue.add(nullNode);
                if (null != tmp.right)
                    queue.add(tmp.right);
                else
                    queue.add(nullNode);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data)
    {
        if (null == data || 0 == data.length())
            return null;

        String[] nodes = data.split(",");
        if (0 == nodes.length || "null".equals(nodes[0]))
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0])), tmp = null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
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
        return root;
    }

}

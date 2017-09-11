package com.yuyang.he.lc.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yuyang.he.vo.TreeNode;

public class LC637_Average_Of_Levels_In_Binary_Tree
{
    public static void main(String[] args)
    {
        TreeNode treeNode = new TreeNode("3,9,20,15,7,null,null");
        LC637_Average_Of_Levels_In_Binary_Tree lc637 = new LC637_Average_Of_Levels_In_Binary_Tree();
        System.out.println(lc637.averageOfLevels(treeNode));
    }

    // key -> level
    // value -> val of nodes at this level
    private Map<Integer, List<Integer>> map = new HashMap<>();

    public List<Double> averageOfLevels(TreeNode root)
    {
        helper(root, 0);
        List<Double> list = new ArrayList<>();
        int size = map.size();
        for (int i = 0; i < size; i++)
        {
            list.add(map.get(i).stream().mapToInt(val -> val).average().getAsDouble());
        }
        return list;
    }

    private void helper(TreeNode root, int level)
    {
        if (null == root)
            return;
        if (map.containsKey(level))
            map.get(level).add(root.val);
        else
            map.put(level, new ArrayList<Integer>(Arrays.asList(root.val)));
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }

}

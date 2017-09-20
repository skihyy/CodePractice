package com.yuyang.he.lc.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yuyang.he.vo.TreeNode;

public class LC652_Find_Duplicate_Subtrees
{

    public static void main(String[] args)
    {
        System.out.println(new LC652_Find_Duplicate_Subtrees().findDuplicateSubtrees(
                new TreeNode("0,1,1,2,null,3,null,null,3,null,null,null,2,3,null,null,3,null,null")));
    }

    private final StringBuilder sb = new StringBuilder();

    public List<TreeNode> findDuplicateSubtrees(final TreeNode root)
    {
        // serilization -> root
        final Map<String, List<TreeNode>> map = new HashMap<>();
        serialize(map, root);

        final List<TreeNode> d = new ArrayList<>();
        map.forEach((k, v) ->
        {
            if (1 < v.size())
                d.add(v.get(0));
        });
        return d;
    }

    private String serialize(Map<String, List<TreeNode>> map, TreeNode root)
    {
        if (null == root)
            return "";
        sb.setLength(0);
        sb.append("(");
        sb.append(serialize(map, root.left));
        sb.append(",");
        sb.append(root.val);
        sb.append(",");
        sb.append(serialize(map, root.right));
        sb.append(")");
        String currentSerialization = sb.toString();
        map.putIfAbsent(currentSerialization, new ArrayList<>());
        map.get(currentSerialization).add(root);
        return currentSerialization;
    }

}

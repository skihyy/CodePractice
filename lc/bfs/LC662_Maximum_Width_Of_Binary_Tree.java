package com.yuyang.he.lc.bfs;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.yuyang.he.vo.TreeNode;

public class LC662_Maximum_Width_Of_Binary_Tree
{

    public static void main(String[] args)
    {
        System.out.println(new LC662_Maximum_Width_Of_Binary_Tree()
                .widthOfBinaryTree(new TreeNode("1,3,2,5,3,null,null,null,null,null,9")));
    }

    public final int widthOfBinaryTree(final TreeNode root)
    {
        if (null == root)
            return 0;
        // level -> id
        final Map<Integer, Integer> start = new HashMap<>(), end = new HashMap<>();
        // root node
        start.put(0, 1);
        end.put(0, 1);
        dfs(1, 1, start, end, root);

        int maxWidth = 0;
        Set<Integer> keys = start.keySet();
        for (int i : keys)
        {
            final int left = start.get(i), right = end.get(i);
            maxWidth = Math.max(maxWidth, right - left);
        }
        return maxWidth;
    }

    private void dfs(final int lv, final int oldID, final Map<Integer, Integer> start, final Map<Integer, Integer> end,
            final TreeNode root)
    {
        if (null != root.left)
        {
            final int id = oldID * 2;
            start.putIfAbsent(lv, id);
            start.put(lv, Math.min(id, start.get(lv)));
            end.putIfAbsent(lv, id);
            end.put(lv, Math.max(id, start.get(lv)));
            dfs(lv + 1, id, start, end, root.left);
        }

        if (null != root.right)
        {
            final int id = oldID * 2 + 1;
            start.putIfAbsent(lv, id);
            start.put(lv, Math.min(id, start.get(lv)));
            end.putIfAbsent(lv, id);
            end.put(lv, Math.max(id, start.get(lv)));
            dfs(lv + 1, id + 1, start, end, root.right);
        }
    }

}

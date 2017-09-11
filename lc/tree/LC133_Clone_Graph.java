package com.yuyang.he.lc.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yuyanghe
 * @date 2017年3月12日
 * @version 1.0
 * @since 2017年3月12日
 */
public class LC133_Clone_Graph
{

    public static void main(String[] args)
    {
        UndirectedGraphNode node = new UndirectedGraphNode(0);
        node.neighbors.add(new UndirectedGraphNode(1));
        node.neighbors.add(new UndirectedGraphNode(2));
        node.neighbors.get(0).neighbors.add(node.neighbors.get(1));
        node.neighbors.get(1).neighbors.add(node.neighbors.get(0));
        node.neighbors.get(0).neighbors.add(node);
        node.neighbors.get(1).neighbors.add(node);
        node.neighbors.get(1).neighbors.add(node.neighbors.get(1));

        UndirectedGraphNode res = new LC133_Clone_Graph().cloneGraph(node);
        System.out.println(res);
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node)
    {
        if (null == node)
            return null;
        UndirectedGraphNode res = new UndirectedGraphNode(node.label);
        Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        map.put(node.label, res);
        helper(res, node, map);
        return res;
    }

    private void helper(UndirectedGraphNode res, UndirectedGraphNode node,
            Map<Integer, UndirectedGraphNode> map)
    {
        int size = node.neighbors.size();
        for (int i = 0; i < size; i++)
        {
            // the node has been generated
            if (map.containsKey(node.neighbors.get(i)))
            {
                if (!res.neighbors.contains(map.get(node.neighbors.get(i))))
                {
                    res.neighbors.add(map.get(node.neighbors.get(i)));
                    helper(res.neighbors.get(res.neighbors.size() - 1), node.neighbors.get(i), map);
                }
            }
            else
            {
                res.neighbors.add(new UndirectedGraphNode(node.neighbors.get(i).label));
                map.put(node.neighbors.get(i).label, res.neighbors.get(res.neighbors.size() - 1));
                helper(res.neighbors.get(res.neighbors.size() - 1), node.neighbors.get(i), map);
            }
        }
    }

    static class UndirectedGraphNode
    {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x)
        {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }

        public String toString()
        {
            StringBuilder sb = new StringBuilder();
            sb.append(label);
            sb.append('-');
            for (UndirectedGraphNode e : neighbors)
            {
                sb.append(e.label);
                sb.append(',');
            }
            return sb.toString();
        }
    }

}

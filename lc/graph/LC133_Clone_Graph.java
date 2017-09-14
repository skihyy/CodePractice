package com.yuyang.he.lc.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LC133_Clone_Graph
{

    public static void main(String[] args)
    {
        LC133_Clone_Graph lc133 = new LC133_Clone_Graph();
        
        UndirectedGraphNode n0 = lc133.new UndirectedGraphNode(0);
        UndirectedGraphNode n1 = lc133.new UndirectedGraphNode(1);
        UndirectedGraphNode n2 = lc133.new UndirectedGraphNode(2);

        n0.neighbors.add(n1);        
        n0.neighbors.add(n2);
        n1.neighbors.add(n0);
        n1.neighbors.add(n2);
        n2.neighbors.add(n0);
        n2.neighbors.add(n1);
        n2.neighbors.add(n2);
        
        UndirectedGraphNode n = lc133.cloneGraph(n0);
        System.out.println();
    }

    // key -> label
    // value -> visited label
    private Map<Integer, Set<Integer>> map = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node)
    {

        if (null == node)
            return null;

        helper(node);

        Map<Integer, UndirectedGraphNode> newMap = new HashMap<>();
        Set<Map.Entry<Integer, Set<Integer>>> set = map.entrySet();
        // create all nodes in the graph
        for (Map.Entry<Integer, Set<Integer>> e : set)
            newMap.put(e.getKey(), new UndirectedGraphNode(e.getKey()));

        // add links
        int key;
        Set<Integer> value;
        for (Map.Entry<Integer, Set<Integer>> e : set)
        {
            key = e.getKey();
            value = e.getValue();
            for (int i : value)
                newMap.get(key).neighbors.add(newMap.get(i));
        }

        return newMap.get(0);
    }

    // visit all
    private void helper(UndirectedGraphNode from)
    {
        boolean containAll = true;

        // the map contains all graph information, thus return
        if (map.containsKey(from.label))
        {
            Set<Integer> set = map.get(from.label);
            for (UndirectedGraphNode to : from.neighbors)
                if (!set.contains(to.label))
                {
                    containAll = false;
                    break;
                }

            if (containAll)
                return;
        }

        for (UndirectedGraphNode to : from.neighbors)
        {
            if (map.containsKey(from.label))
                map.get(from.label).add(to.label);
            else
            {
                Set<Integer> set = new HashSet<>();
                set.add(to.label);
                map.put(from.label, set);
            }

            helper(to);
        }
    }

    class UndirectedGraphNode
    {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x)
        {
            label = x;
            neighbors = new ArrayList<>();
        }
        
        public String toString() {
            return label + "";
        }
    }

}

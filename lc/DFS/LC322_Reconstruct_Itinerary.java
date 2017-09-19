package com.yuyang.he.lc.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC322_Reconstruct_Itinerary
{

    public static void main(String[] args)
    {
        System.out.println(new LC322_Reconstruct_Itinerary()
                .findItinerary(new String[][] { { "JFK", "KUL" }, { "JFK", "NRT" }, { "NRT", "JFK" } }));
    }

    // from -> to
    private final Map<String, Queue<String>> map = new HashMap<>();
    private final List<String> res = new ArrayList<>();

    public List<String> findItinerary(final String[][] tickets)
    {
        for (String[] ticket : tickets)
        {
            map.putIfAbsent(ticket[0], new PriorityQueue<>());
            map.get(ticket[0]).add(ticket[1]);
        }

        dfs("JFK");
        return res;
    }

    private void dfs(final String from)
    {
        Queue<String> tos = map.get(from);
        while (null != tos && !tos.isEmpty())
            dfs(tos.poll());
        res.add(0, from);
    }

}

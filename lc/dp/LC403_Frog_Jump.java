package com.yuyang.he.lc.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC403_Frog_Jump
{

    public static void main(String[] args)
    {
        System.out.println(new LC403_Frog_Jump().canCross(new int[] { 0, 1, 3, 6, 7 }));
    }

 // using a map to store all possible moving capabilities from each stone
    // running time O(n^2) (worst: for each stone, it can reach all other stones)
    // space O(n^2) (worst: n stones, with n possible steps)
    public final boolean canCross(final int[] stones) {
        if(null == stones || 0 == stones.length)
            return true;
        else if (0 != stones[0] || 1 != stones[1])
            return false;
        
        // stone # -> moving capabilities
        final Map<Integer, Set<Integer>> map = new HashMap<> ();
        // base case
        // at pos 0, moving power = 1
        map.put(0, new HashSet<>(Arrays.asList(1))); 
        // at pos 1, moving power = 0, or 1, or 2
        // but 0 is useless so I remove it
        map.put(1, new HashSet<>(Arrays.asList(1, 2)));
        // other cases, put empty list
        for(int i = 2; i < stones.length; i++)
            map.put(stones[i], new HashSet<> ());
        
        for(int i = 1; i < stones.length; i++) {
            final Set<Integer> steps = map.get(stones[i]);
            for(final int step : steps) {
                final int newLocation = stones[i] + step;
                if(map.containsKey(newLocation)) {// can reach this stone, adding all moving power
                    map.get(newLocation).add(step);
                    map.get(newLocation).add(step + 1);
                    if(0 != step - 1) // moving power = 0 is useless
                        map.get(newLocation).add(step - 1);
                }
            }
        }
        
        // if at the last location, the frog has moving power
        // meaning it reaches the other side
        return 0 != map.get(stones[stones.length - 1]).size();
    }

}

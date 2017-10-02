package com.yuyang.he.lc.numbers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LC305_Number_Of_Islands_II
{

    public static void main(String[] args)
    {
        final List<Integer> res = new LC305_Number_Of_Islands_II().numIslands2(3, 3,
                new int[][] { { 0, 1 }, { 1, 2 }, { 2, 1 }, { 1, 0 }, { 0, 2 }, { 0, 0 }, { 1, 1 } });
        for (final int i : res)
            System.out.print(i + " ");
    }
    
    public final List<Integer> numIslands2(final int m, final int n, final int[][] positions) {
        // stores how many islands now exist
        // and the cooridnations of each of the islands
        // island ID# -> all coordinations
        final Map<Integer, List<int []>> islands = new HashMap<> ();
        // stores the index of islands which becomes connected after a new operation
        final List<Integer> connections = new ArrayList<> (), result = new ArrayList<> ();
        int currentMaxIslandID = 0;
        for(int i = 0; i < positions.length; i++) {
            connections.clear();
            final Set<Integer> islandIDs = islands.keySet();
            for(int id : islandIDs) {
                final List<int []> island = islands.get(id);
                if(contains(island, positions[i][0], positions[i][1]))
                    connections.add(id);
            }
            final int connectedIslandSize = connections.size();
            if(0 == connectedIslandSize){ // new island!
                islands.putIfAbsent(currentMaxIslandID, new ArrayList<> ());
                islands.get(currentMaxIslandID++).add(new int[] {positions[i][0], positions[i][1]});
            } else if(1 == connectedIslandSize)
                islands.get(connections.get(0)).add(new int[] {positions[i][0], positions[i][1]});
            else if(1 < connectedIslandSize) {
                final List<int []> newIsland = islands.get(connections.get(0));
                newIsland.add(new int[] {positions[i][0], positions[i][1]});
                for(int j = 1; j < connectedIslandSize; j++) {
                    final int islandID = connections.get(j);
                    newIsland.addAll(islands.get(islandID));
                    islands.remove(islandID);
                }
            }
            result.add(islands.size());
        }
        return result;
    }
    
    private boolean contains(final List<int []> island, final int y, final int x) {
        for(final int [] coor : island)
            if((coor[0] == y && 1 == Math.abs(coor[1] - x)) || (coor[1] == x && 1 == Math.abs(coor[0] - y)))
                return true;
        return false;
    }

}

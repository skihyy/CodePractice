package com.yuyang.he.lc.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        final List<Integer> list = new ArrayList<> ();
        if(0 >= m || 0 >= n)
            return list;
        
        final int [][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        // id of tree will be the id of an island
        // island with same id meaning they are one island
        final int [] tree = new int[m * n]; // for union find
        Arrays.fill(tree, -1);
        int count = 0;
        for(final int [] position : positions) {
            // at beginning, the location is the same as the ID
            int newIslandID = position[0] * n + position[1];
            tree[newIslandID] = newIslandID;
            count++;
            // check surroundings
            for(final int [] direction : directions) {
                final int i = position[0] + direction[0], j = position[1] + direction[1], neighborLocation = i * n + j;
                // neighbor must be a island to check connections
                if(0 <= i && m > i && 0 <= j && n > j && -1 != tree[neighborLocation]) {
                    final int neighborID = finaNeighborID(tree, neighborLocation);
                    if(newIslandID != neighborID) { // belongs to another island
                        count--;
                        tree[newIslandID] = neighborID;
                        newIslandID = neighborID;
                    }
                }
            }
            list.add(count);
        }
        return list;
    }
    
    private int finaNeighborID(final int [] array, int location) {
        // the ID should be the same as the location (root node)
        // if not, go up and check its parent until the root is found
        while(location != array[location])
            location = array[location];
        return location;
    }

}

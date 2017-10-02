package com.yuyang.he.lc.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class LC317_Shortest_Distance_From_All_Buildings
{

    public static void main(String[] args)
    {
        System.out.println(new LC317_Shortest_Distance_From_All_Buildings()
                .shortestDistance(new int[][] { { 1, 0, 2, 0, 1 }, { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 } }));
    }
    
    public final int shortestDistance(final int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        final int [][] directions = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        // buildingsReached[i][j] = the number of buildings that can reach grid[i][j]
        final int [][] distances = new int[grid.length][grid[0].length], buildingsReached = new int[grid.length][grid[0].length];
        int buildings = 0;
        // bfs
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[0].length; j++)
                if(1 == grid[i][j]) { // start from building do dfs
                    buildings++;
                    final Queue<int []> queue = new LinkedList<> (); // iterative bfs
                    queue.add(new int[]{i, j});
                    final boolean [][] visited = new boolean[grid.length][grid[0].length];
                    int currentDistance = 1; // a.k.a. level of the tree
                    while(!queue.isEmpty()) {
                        final int currentLevelNodeSize = queue.size();
                        for(int a = 0; a < currentLevelNodeSize; a++) {
                            final int [] cur = queue.poll();
                            for(final int [] direction : directions) {
                                final int x = cur[0] + direction[0], y = cur[1] + direction[1];
                                if(0 <= x && grid.length > x && 0 <= y && grid[0].length > y && !visited[x][y] && 0 == grid[x][y]) { // valid
                                    distances[x][y] += currentDistance;
                                    buildingsReached[x][y]++;
                                    visited[x][y] = true;
                                    queue.add(new int[] {x, y});
                                }
                            }
                        }
                        currentDistance++;
                    }
                }
        
        int shortestDistance = Integer.MAX_VALUE;
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[0].length; j++)
                if(0 == grid[i][j] && buildings == buildingsReached[i][j] && shortestDistance > distances[i][j])
                    shortestDistance = distances[i][j];
        
        return shortestDistance == Integer.MAX_VALUE ? -1 : shortestDistance;
    }

}

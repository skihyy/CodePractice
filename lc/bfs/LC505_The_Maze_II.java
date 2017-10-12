package com.yuyang.he.lc.bfs;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC505_The_Maze_II
{

    public static void main(String[] args)
    {
        System.out
                .println(
                        new LC505_The_Maze_II().shortestDistance(
                                new int[][] { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 },
                                        { 1, 1, 0, 1, 1 }, { 0, 0, 0, 0, 0 } },
                                new int[] { 0, 4 }, new int[] { 4, 4 }));
    }
    
    public final int shortestDistance(final int[][] maze, final int[] start, final int[] destination) {
        if(null == maze || 0 == maze.length)
            return -1;
        // bfs
        final int [][] directions = new int [][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}, distance = new int[maze.length][maze[0].length];
        for(final int [] row : distance)
            Arrays.fill(row, Integer.MAX_VALUE);
        distance[start[0]][start[1]] = 1;
        // order by distance
        final Queue<int []> queue = new PriorityQueue<> ((i, j) -> Integer.compare(distance[i[0]][i[1]], distance[j[0]][j[1]]));
        queue.offer(start);
        while(!queue.isEmpty()){
            final int [] currentLocation = queue.poll();
            if(currentLocation[0] == destination[0] && currentLocation[1] == destination[1])
                continue;
            for(final int [] direction : directions) {
                int i = currentLocation[0], j = currentLocation[1], nextI = i + direction[0], nextJ = j + direction[1];
                while(0 <= nextI && maze.length > nextI && 0 <= nextJ && maze[0].length > nextJ && 0 == maze[nextI][nextJ]) {
                    i = nextI;
                    j = nextJ;
                    nextI += direction[0];
                    nextJ += direction[1];
                } // touch the wall now
                final int currentDistance = i - currentLocation[0] + j - currentLocation[1] + distance[currentLocation[0]][currentLocation[1]];
                // only bfs if the current distance is shorter
                if((i != currentLocation[0] || j != currentLocation[0]) && currentDistance < distance[i][j]) {
                    distance[i][j] = currentDistance;
                    queue.offer(new int[] {i, j});
                }
            }
        }
        return Integer.MAX_VALUE == distance[destination[0]][destination[1]] ? -1 : distance[destination[0]][destination[1]];
    }

}

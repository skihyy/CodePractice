package com.yuyang.he.lc.bfs;

import java.util.ArrayList;
import java.util.List;

public class LC417_Pacific_Atlantic_Water_Flow
{

    public static void main(String[] args)
    {
        final List<int[]> r = new LC417_Pacific_Atlantic_Water_Flow().pacificAtlantic(new int[][] { { 1, 2, 2, 3, 5 },
            { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 }, { 5, 1, 1, 2, 4 } });
        for(final int [] t : r)
            System.out.println(t[0] + " " + t[1]);
    }
    
    public final List<int[]> pacificAtlantic(final int[][] m) {
        final List<int []> result = new ArrayList<> ();
        
        if(null == m || 0 == m.length)
            return result;
        
        // check [i][j] can reach how many oceans
        final boolean [][] visitedPacific = new boolean[m.length][m[0].length], visitedAtlantic = new boolean[m.length][m[0].length], reachedByPacific = new boolean[m.length][m[0].length], reachedByAtlantic = new boolean[m.length][m[0].length];
        final int[][] directions = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        // pacific ocean
        for(int i = 0; i < m.length; i++) 
            bfs(visitedPacific, m, i, 0, reachedByPacific, directions);
        for(int i = 0; i < m[0].length; i++)
            bfs(visitedPacific, m, 0, i, reachedByPacific, directions);
        // atlantic ocean
        for(int i = 0; i < m.length; i++) 
            bfs(visitedAtlantic, m, i, m[0].length - 1, reachedByAtlantic, directions);
        for(int i = 0; i < m[0].length; i++)
            bfs(visitedAtlantic, m, m.length - 1, i, reachedByAtlantic, directions);
        
        for(int i = 0; i < m.length; i++) 
            for(int j = 0; j < m[0].length; j++)
                if(reachedByPacific[i][j] && reachedByAtlantic[i][j])
                    result.add(new int[] {i, j});
        return result;
    }
    
    private void bfs(final boolean[][] visited, final int [][] m, final int y, final int x, final boolean [][] canReach, final int[][] directions) {
        if(visited[y][x])
            return;
        visited[y][x] = true;
        canReach[y][x] = true;
        for(final int [] direction : directions) {
            final int i = y + direction[0], j = x + direction[1];
            if(0 <= i && m.length > i && 0 <= j && m[0].length > j && m[y][x] <= m[i][j] && !visited[i][j])
                bfs(visited, m, i, j, canReach, directions);
        }
    }

}

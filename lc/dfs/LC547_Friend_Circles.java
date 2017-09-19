package com.yuyang.he.lc.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class LC547_Friend_Circles
{

    public static void main(String[] args)
    {
        System.out.println(new LC547_Friend_Circles().findCircleNum(new int[][] {
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, 
                { 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
                { 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
                { 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 }, 
                { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, 
                { 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 }, 
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 } }));
    }

// bfs or dfs doesn't matter as long as nodes are visited
    
    public final int findCircleNum(final int[][] m) {       
        final int [] visited = new int[m.length];
        int count = 0;
        for(int i = 0; i < m.length; i++)
            if(0 == visited[i]) {
                dfs(m, visited, i);
                count++;
            }
        return count;
    }
    
    private void dfs(final int [][] m, final int [] visited, final int i) {
        for(int j = 0; j < m.length; j++) {
            if(1 == m[i][j] && 0 == visited[j]) {
                visited[j] = 1;
                dfs(m, visited, j);
            }
        }
    }

}

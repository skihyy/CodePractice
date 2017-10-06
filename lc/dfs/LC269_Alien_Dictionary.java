package com.yuyang.he.lc.dfs;

import java.util.Arrays;

public class LC269_Alien_Dictionary
{

    public static void main(String[] args)
    {
        System.out.println(new LC269_Alien_Dictionary().alienOrder(new String[]{"wrt","wrf","er","ett","rftt"}));
    }
    
    public final String alienOrder(final String[] words) {
        // dfs
        // build topological sorted order
        // if there is a circle, then return ""
        final boolean [][] adj = new boolean[26][26];
        // -1 - not existed
        // 0  - unvisited
        // 1  - visiting
        // 2  - visited
        final int [] visited = new int[26];
        Arrays.fill(visited, -1);
        
        // build adjacency matrix
        for(int i = 0; i < words.length; i++) {
            final char [] cc = words[i].toCharArray();
            for(final char c : cc)
                visited[c - 'a'] = 0; // existing character
            if(i > 0) {
                final int len = Math.min(words[i].length(), words[i - 1].length());
                for(int j = 0; j < len; j++) {
                    final char c1 = words[i].charAt(j), c2 = words[i - 1].charAt(j);
                    if(c1 != c2) {
                        adj[c1 - 'a'][c2 - 'a'] = true;
                        break;
                    }
                }
            }
        }
        
        // dfs
        final StringBuilder sb = new StringBuilder ();
        for(int i = 0; i < 26; i++)
            if(0 == visited[i])
                if(!dfs(adj, visited, sb, i))
                    return "";
        return sb.toString();
    }
    
    private boolean dfs(final boolean [][] adj, final int[] visited, final StringBuilder sb, final int cur) {
        visited[cur] = 1; // start
        for(int i = 0; i < 26; i++)
            if(adj[cur][i]) // connected
                if(1 == visited[i]) // circle
                    return false;
                else if(0 == visited[i])
                    if(!dfs(adj, visited, sb, i))
                        return false;
        visited[cur] = 2; // finished
        sb.append((char) (cur + 'a'));
        return true;
    }

}

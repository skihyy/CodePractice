package com.yuyang.he.lc.dp;

public class LC471_Encode_String_With_Shortest_Length
{

    public static void main(String[] args)
    {
        System.out.println(new LC471_Encode_String_With_Shortest_Length().encode("abbbabbbcabbbabbbc"));
    }
    
    // space O(n^2)
    // time O(n^3)
    public final String encode(final String s) {
        final int len = s.length();
        // i, j -> encoded form from i to j
        // dp[i][j] = min { dp[i][j], dp[i][k] + dp[k + 1][j]}, k from i + 1 to j - 1
        final String [][] dp = new String[len][len];
        for(int m = 0; m < len; m++) {
            final int limit = len - m; // for substring limit
            for(int i = 0; i < limit; i++) {
                final int j = m + i;
                final String current = s.substring(i, j + 1);
                dp[i][j] = current; // base case
                if(j - i < 4) // aaaa = 4[a] so at least 5 characters are needed for shoren
                    continue;
                
                // find min { dp[i][k] + dp[k + 1][j] }, k from i + 1 to j - 1
                for(int k = i; k < j; k++)
                    dp[i][j] = dp[i][j].length() < dp[i][k].length()  + dp[k + 1][j].length() ? dp[i][j] : dp[i][k] + dp[k + 1][j];
                
                // find shorest dp[i][j] from current
                final int curLen = current.length();
                for(int k = 1; k <= curLen; k++) {
                    final String repeat = current.substring(0, k);
                    // check if the current substring can be shorten
                    final int repeatLen = repeat.length();
                    if(null != repeat && 0 == curLen % repeatLen && 0 == current.replaceAll(repeat, "").length()) {
                        // using dp[i][i + k - 1] instead of repeat to make sure the shortest length
                        // k start from 1, so i + k should - 1
                        final String newRepeat = curLen / repeatLen + "[" + dp[i][i + k - 1] + "]";
                        dp[i][j] = dp[i][j].length() < newRepeat.length() ? dp[i][j] : newRepeat;
                    }
                }
            }
        }
        return dp[0][len - 1];
    }

}

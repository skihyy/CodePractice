package com.yuyang.he.lc.amazon;

/**
 * @author yuyanghe
 * @date 2017年1月16日
 * @version 1.0
 * @since 2017年1月16日
 */
public class LC223_RectangleArea
{
    public static void main(String[] args)
    {

    }

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H)
    {
        int x = Math.min(G, C) > Math.max(E, A) ? (Math.min(G, C) - Math.max(E, A)) : 0;
        int y = Math.min(D, H) > Math.max(B, F) ? (Math.min(D, H) - Math.max(B, F)) : 0;
        return (D - B) * (C - A) + (G - E) * (H - F) - x * y;
    }
}

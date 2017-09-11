package com.yuyang.he.cc189_1_3;

/**
 * @author yuyanghe
 * @version 1.0
 * @date 2016年12月24日
 * @since 2016年12月24日
 */
public class URLify {
    public static void main(String[] args) {
        char[] url = "Mr John Smith    ".toCharArray();
        System.out.println(url);
        new URLify().urlify(url, 13);

        for (int i = 0; i < url.length; ++i) {
            System.out.print(url[i]);
        }
        System.out.println();
    }

    public void urlify(char[] cc, int len) {
        char[] tmp = new char[cc.length];

        for (int i = 0; i < cc.length; ++i) {
            tmp[i] = cc[i];
        }

        for (int i = 0, j = 0; i < len; ++i) {
            if (' ' == tmp[i]) {
                cc[j++] = '%';
                cc[j++] = '2';
                cc[j++] = '0';
            } else {
                cc[j++] = tmp[i];
            }
        }
    }
}

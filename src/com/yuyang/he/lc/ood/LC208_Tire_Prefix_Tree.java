package com.yuyang.he.lc.ood;

/**
 * @author yuyanghe
 * @date 2017年3月9日
 * @version 1.0
 * @since 2017年3月9日
 */
public class LC208_Tire_Prefix_Tree
{
    public static void main(String[] args)
    {
        LC208_Tire_Prefix_Tree tree = new LC208_Tire_Prefix_Tree();
        tree.insert("hello");
        tree.insert("world");
        System.out.println(tree.search("hello"));
        System.out.println(tree.search("wo"));
        System.out.println(tree.startsWith("he"));
        System.out.println(tree.startsWith("wo"));
    }

    private Char root = new Char();

    /** Inserts a word into the trie. */
    public void insert(String word)
    {
        char[] cc = word.trim().toLowerCase().toCharArray();
        int pos = -1;
        Char tmp = root;
        for (int i = 0; i < cc.length; i++)
        {
            pos = cc[i] - 'a';
            if (null == tmp.next[pos])
                tmp.next[pos] = new Char();
            if (cc.length - 1 == i)
                tmp.next[pos].isWord = true;
            tmp = tmp.next[pos];
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word)
    {
        char[] cc = word.trim().toLowerCase().toCharArray();
        int pos = -1;
        Char tmp = root;
        for (int i = 0; i < cc.length; i++)
        {
            pos = cc[i] - 'a';
            if (null == tmp.next[pos])
                return false;
            if (cc.length - 1 == i && !tmp.next[pos].isWord)
                return false;
            tmp = tmp.next[pos];
        }
        return true;
    }

    /**
     * Returns if there is any word in the trie that starts with the given
     * prefix.
     */
    public boolean startsWith(String prefix)
    {
        char[] cc = prefix.trim().toLowerCase().toCharArray();
        int pos = -1;
        Char tmp = root;
        for (int i = 0; i < cc.length; i++)
        {
            pos = cc[i] - 'a';
            if (null == tmp.next[pos])
                return false;
            tmp = tmp.next[pos];
        }
        return true;
    }

    static class Char
    {
        boolean isWord = false;
        Char[] next = new Char[26];

        Char()
        {
        }
    }
}

package com.yuyang.he.lc.tree;

import java.util.ArrayList;
import java.util.List;

public class LC425_Word_Squares
{

    public static void main(String[] args)
    {
        final List<List<String>> result = new LC425_Word_Squares().wordSquares(new String[] {"area","lead","wall","lady","ball"});
        for(final List<String> list : result) {
            for(final String s : list)
                System.out.println(s);
            System.out.println();
        }
    }

    private final StringBuilder sb = new StringBuilder ();
    private int size;
    
    // each node represents a character
    final class TireTree {
        // this means if ending here would make up a word
        boolean isEnd = false;
        //char current;
        // there are 26 characters from 'a' to 'z'
        final TireTree [] next = new TireTree[26];
    }
    
    public final List<List<String>> wordSquares(final String[] words) {
        List<List<String>> result = new ArrayList<> ();
        if(null == words || 0 == words.length)
            return result;
        final TireTree root = new TireTree();
        for(final String word : words)
            makeUpTree(root, word.toCharArray(), 0);
        size = words[0].length();
        for(final String word : words) {
            final List<String> answer = new ArrayList<> ();
            answer.add(word);
            finalAllResults(answer, result, root);
        }
            
        return result;
    }
    
    private void finalAllResults(final List<String> answer, final List<List<String>> result, final TireTree root) {
        final int currentSize = answer.size();
        if(currentSize == size) {
            result.add(new ArrayList<>(answer));
            return;
        }
        // find prefix by now
        final char [] prefix = new char[currentSize];
        for(int i = 0; i < currentSize; i++)
            prefix[i] = answer.get(i).charAt(currentSize);
        // find all words
        final List<String> allMatchWords = new ArrayList<> ();
        findByPrefix(allMatchWords, root, prefix, 0);
        for(final String matchWord : allMatchWords) {
            answer.add(matchWord);
            finalAllResults(answer, result, root);
            answer.remove(answer.size() - 1);
        }
    }
    
    // create a tire tree
    private void makeUpTree(final TireTree root, final char [] cc, final int index) {
        if(cc.length == index) { // end of the word
            root.isEnd = true;
            return;
        }            
        // no character now
        if(null == root.next[cc[index] - 'a'])  {
            root.next[cc[index] - 'a'] = new TireTree();
            //root.next[cc[index] - 'a'].current = cc[index];
        }            
        // go to the next character
        makeUpTree(root.next[cc[index] - 'a'], cc, index + 1);            
    }
    
    // find words by prefix, and store them into a list
    private void findByPrefix(final List<String> list, final TireTree root, final char [] prefix, final int index) {
        if(prefix.length == index + 1) { // get all words with this prefix
            sb.setLength(0);
            for(final char c : prefix)
                sb.append(c);
            if(null != root.next[prefix[prefix.length - 1] - 'a'])
                getWords(list, root.next[prefix[prefix.length - 1] - 'a']);
            return;
        }
        if(null != root.next[prefix[index] - 'a'])
                findByPrefix(list, root.next[prefix[index] - 'a'], prefix, index + 1);
    }
    
    // get all words with this prefix into a list 
    private void getWords(final List<String> list, final TireTree root) {
        if(root.isEnd)
            list.add(sb.toString());
        for(int i = 0; i < 26; i++)
            if(null != root.next[i]) {
                sb.append((char)('a' + i));
                getWords(list, root.next[i]);
                sb.setLength(sb.length() - 1);
            }
    }
}

package com.yuyang.he.lc.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LC418_Sentence_Screen_Fitting
{

    public static void main(String[] args)
    {
        System.out.println(new LC418_Sentence_Screen_Fitting().wordsTyping(new String[] { "f","p","a"},8,7));
    }

    public final int wordsTyping(final String[] sentence, final int rows, final int cols) {
        final Integer [] lengths = Arrays.stream(sentence).mapToInt(i -> i.length()).boxed().collect(Collectors.toList()).toArray(new Integer[sentence.length]);
        final int lengthOfSentence = Arrays.stream(lengths).mapToInt(i -> i).sum() + lengths.length - 1; // add spaces
        // before finding a loop point, how many sentences can 0 - i-th line contain
        final Map<Integer, Integer> map = new HashMap<> ();
        int curWord = 0, countPerLoop = 0, rowsPerLoop = 0;
        boolean loopPoint = false;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(0 == curWord && (cols - j) > lengthOfSentence) {
                    final int numOfSentence = (cols - j) / (lengthOfSentence + 1); // 1 is the space after a whole sentence
                    j += (lengthOfSentence + 1) * numOfSentence;
                    countPerLoop += numOfSentence;
                }                
                while(j < cols && cols - j >= lengths[curWord]) {
                    j += lengths[curWord++] + 1;
                    if(curWord == lengths.length) {
                        countPerLoop++;
                        curWord = 0;
                        if(lengths[0] > cols - j) { // a looping point is found
                            loopPoint = true;
                            break;
                        }
                    }
                }
            }
            map.put(i + 1, countPerLoop);
            if(loopPoint) {
                rowsPerLoop = i + 1;
                break;
            }                
        }
        int count = countPerLoop, remainingRows = 0;
        if(loopPoint) {
            count = countPerLoop * (rows / rowsPerLoop);
            remainingRows = rows % rowsPerLoop;
        }
        return count + map.getOrDefault(remainingRows, 0);
    }

}

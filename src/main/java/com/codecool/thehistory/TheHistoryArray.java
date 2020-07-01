package com.codecool.thehistory;
import java.util.Arrays;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TheHistoryArray implements TheHistory {

    /**
     * This implementation should use a String array so don't change that!
     */
    private String[] wordsArray = new String[0];

    @Override
    public void add(String text) {
        List<String> words = new ArrayList<String>();
        BreakIterator breakIterator = BreakIterator.getWordInstance();
        breakIterator.setText(text);
        int lastIndex = breakIterator.first();
        while (BreakIterator.DONE != lastIndex) {
            int firstIndex = lastIndex;
            lastIndex = breakIterator.next();
            if (lastIndex != BreakIterator.DONE && Character.isLetterOrDigit(text.charAt(firstIndex))) {
                words.add(text.substring(firstIndex, lastIndex));
            }
        }
        String[] tmpArray = words.toArray(new String[words.size()]);
        wordsArray = tmpArray;



    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        int index = 0;
        String[] tmpArray = new String[wordsArray.length - 1];
        for(int i = 0; i < wordsArray.length; i++){
            if(!wordsArray[i].equals(wordToBeRemoved)){
                tmpArray[index] = wordsArray[i];
                index++;
            }
        }



    }

    @Override
    public int size() {

        return wordsArray.length;
    }

    @Override
    public void clear() {
        wordsArray = new String[0];
    }

    public void replaceOneWord(String from, String to) {
        for (int i = 0; i < wordsArray.length; i++) {
            if (wordsArray[i].equals(from)) wordsArray[i] = to;
        }
    }


    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        int fromWordLen = fromWords.length;
        int toWordLen = toWords.length;
        int maxLen = 0;
        if (fromWordLen < toWordLen){
            maxLen = fromWordLen;
        } else if(fromWordLen > toWordLen){
            maxLen = toWordLen;
        } else {
            maxLen = toWordLen;
        }
        for(int i = 0; i < wordsArray.length; i++){
            for(int j = 0; j < maxLen; j++){
                if(wordsArray[i].equals(fromWords[j])){
                    wordsArray[i] = toWords[j];
                }
            }
        }

    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArray) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }
}

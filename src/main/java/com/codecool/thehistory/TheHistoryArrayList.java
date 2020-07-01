package com.codecool.thehistory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class TheHistoryArrayList implements TheHistory {
    /**
     * This implementation should use a String ArrayList so don't change that!
     */
    private List<String> wordsArrayList = new ArrayList<>();

    @Override
    public void add(String text) {
        text = text.trim().replaceAll("\\s{2,}|\\n|\\t", " ");
        wordsArrayList.add(text);
    }

    @Override
    public void removeWord(String wordToBeRemoved) {

        wordsArrayList.remove(wordToBeRemoved);
    }

    @Override
    public int size() {


        return wordsArrayList.size();
    }

    @Override
    public void clear() {

        wordsArrayList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        Collections.replaceAll(wordsArrayList, from, to);
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
        for(int i = 0; i < wordsArrayList.size(); i++){
            for(int j = 0; j < maxLen; j++){
                if(wordsArrayList.get(i).equals(toWords[j])){
                    wordsArrayList.set(i, toWords[j]);
                }
            }
        }



    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArrayList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}

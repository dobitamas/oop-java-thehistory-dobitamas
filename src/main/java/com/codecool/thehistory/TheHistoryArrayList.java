package com.codecool.thehistory;

import java.util.*;

public class TheHistoryArrayList implements TheHistory {
    /**
     * This implementation should use a String ArrayList so don't change that!
     */
    private List<String> wordsArrayList = new ArrayList<>();

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        wordsArrayList = new ArrayList<>(Arrays.asList(text.split("\\s")));
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        ArrayList<String> temp = new ArrayList<>();
        for (String word: wordsArrayList)
            if (!word.equals(wordToBeRemoved)) {
                temp.add(word);
            }
        wordsArrayList = temp;

    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsArrayList.size();
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsArrayList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        Collections.replaceAll(wordsArrayList, from, to);
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
        boolean equalReplace = fromWords.length == toWords.length;
        List<String> temp = new ArrayList<>();
        int fromLen = fromWords.length;
        int toLen = toWords.length;
        for (int i = 0; i < wordsArrayList.size(); i++) {
            boolean expressionFound = false;
            if (wordsArrayList.get(i).equals(fromWords[0])) {
                expressionFound = true;
                for (int j = 0; j < fromWords.length; j++) {
                    if ((wordsArrayList.size()-i) < fromWords.length) {
                        expressionFound = false;
                        break;
                    } else if (!(wordsArrayList.get(i+j).equals(fromWords[j]))) {
                        expressionFound = false;
                    }
                }
                if (expressionFound) {
                    if (equalReplace) {
                        for (int j = 0; j < toWords.length; j++) {
                            wordsArrayList.set(i+j, toWords[j]);
                        }
                        i += toLen - 1;
                    } else {
                        temp.addAll(Arrays.asList(toWords));
                        i += fromLen - 1;
                    }
                }
            }
            if (!expressionFound && !equalReplace) {
                temp.add(wordsArrayList.get(i));
            }
        }
        if (!equalReplace) {
            wordsArrayList = temp;
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

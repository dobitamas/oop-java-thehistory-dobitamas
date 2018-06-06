package com.codecool.thehistory;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Arrays;

public class TheHistoryLinkedList implements TheHistory {
    /**
     * This implementation should use a String LinkedList so don't change that!
     */
    private List<String> wordsLinkedList = new LinkedList<>();

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        wordsLinkedList = new LinkedList<>(Arrays.asList(text.split("\\s")));
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
//        wordsLinkedList.removeIf(s -> s.equals(wordToBeRemoved));
        ListIterator<String> li = wordsLinkedList.listIterator();
        while (li.hasNext()) {
            if (li.next().equals(wordToBeRemoved)) {
                li.remove();
            }
        }
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsLinkedList.size();
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsLinkedList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        //noinspection ResultOfMethodCallIgnored
        Collections.replaceAll(wordsLinkedList, from, to);
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsLinkedList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}

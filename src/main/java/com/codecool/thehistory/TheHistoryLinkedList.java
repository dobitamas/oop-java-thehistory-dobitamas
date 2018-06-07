package com.codecool.thehistory;

import java.util.*;

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
        if (!Arrays.equals(fromWords, toWords)) {
            boolean equalReplace = fromWords.length == toWords.length;
            List<String> temp = new ArrayList<>();
            int fromLen = fromWords.length;
            int toLen = toWords.length;

            ListIterator<String> li = wordsLinkedList.listIterator();
            while (li.hasNext()) {
                boolean expressionFound;
                String word = li.next();
                if (word.equals(fromWords[0])) {
                    expressionFound = true;
                    int moveBack = 0;
                    for (int i = 0; i < fromWords.length; i++) {
                        if (!li.hasNext() && i < fromWords.length - 1 || !word.equals(fromWords[i])) {
                            expressionFound = false;
                            moveBack = i;
                            break;
                        }
                        if (li.hasNext()) {
                            word = li.next();
                            moveBack++;
                        }
                    }
                    for (int j = moveBack; j > 0; j--) {
                        if (li.hasPrevious()) {
                            li.previous();
                        }
                    }
                    if (expressionFound) {
                        if (li.hasPrevious()) {
                            li.previous();
                        } else {
                            li.next();
                        }
                        if (equalReplace) {
                            for (String toWord : toWords) {
                                li.next();
                                li.set(toWord);
                            }
                        } else {
                            for (int j = 0; j < fromLen; j++) {
                                li.next();
                                li.remove();
                            }
                            for (String toword : toWords) {
                                li.add(toword);
                            }
                        }
                    }
                }
            }
        }
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

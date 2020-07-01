package com.codecool.thehistory;



import java.text.BreakIterator;
import java.util.*;

public class TheHistoryLinkedList implements TheHistory {
    /**
     * This implementation should use a String LinkedList so don't change that!
     */
    private List<String> wordsLinkedList = new LinkedList<>();

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
        wordsLinkedList = new LinkedList(Arrays.asList(tmpArray));
        System.out.println(wordsLinkedList);
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        int index = 0;
        for(int i = 0; i < wordsLinkedList.size();i++){
            if(wordsLinkedList.get(i).equals(wordToBeRemoved)){
                index = i;
            }
        }
        wordsLinkedList.remove(index);
    }

    @Override
    public int size() {
        return wordsLinkedList.size();
    }

    @Override
    public void clear() {

        wordsLinkedList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {

        Collections.replaceAll(wordsLinkedList, from, to);
        System.out.println(wordsLinkedList);
    }


    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        int fromWordLen = fromWords.length;
        int toWordLen = toWords.length;
        int maxLen = 0;
        if (fromWordLen < toWordLen) {
            maxLen = fromWordLen;
        } else if (fromWordLen > toWordLen) {
            maxLen = toWordLen;
        } else {
            maxLen = toWordLen;
        }
        System.out.println("Ezt akarom kicserélni" + Arrays.toString(fromWords));
        System.out.println("Erre akarom kicserélni" + Arrays.toString(toWords));
        System.out.println("Ez a listám" + wordsLinkedList);


        String[] tmpArray = new String[wordsLinkedList.size()];
        for (int i = 0; i < wordsLinkedList.size(); i++) {
            for (int j = 0; j < maxLen; j++) {
                if (wordsLinkedList.get(i).equals(fromWords[j])) {
                    tmpArray[i] = toWords[j];
                }
            }
        }
        wordsLinkedList = new LinkedList(Arrays.asList(tmpArray));
        System.out.println("Ez lett belőle" + wordsLinkedList);
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

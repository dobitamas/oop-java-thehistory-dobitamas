package com.codecool.thehistory;

import java.util.Arrays;

public class TheHistoryArray implements TheHistory {

    /**
     * This implementation should use a String array so don't change that!
     */
    private String[] wordsArray = new String[0];

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        wordsArray = text.split("\\s");
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        String[] temp = new String[wordsArray.length];
        int removeCounter = 0;
        for (int i = 0, j = 0; i < wordsArray.length; i++)
            if (!wordsArray[i].equals(wordToBeRemoved)) {
                temp[j++] = wordsArray[i];
            } else {
                removeCounter++;
            }
        wordsArray = Arrays.copyOf(temp, temp.length - removeCounter);
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsArray.length;
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsArray = new String[0];
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        for (int i=0; i < wordsArray.length; i++) {
            if (wordsArray[i].equals(from)) {
                wordsArray[i] = to;
            }
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
        boolean equalReplace = fromWords.length == toWords.length;

        String[] temp = new String[wordsArray.length + 100];
        int origStartIndex = 0;
        int tempStartIndex = 0;

        for (int i=0; i < wordsArray.length; i++) {
            boolean expressionFound;
            if (wordsArray[i].equals(fromWords[0])) {
                expressionFound = true;
                for (int j = 0; j < fromWords.length; j++) {
                    if ((wordsArray.length-i) < fromWords.length) {
                        expressionFound = false;
                        break;
                    } else if (!(wordsArray[i+j].equals(fromWords[j]))) {
                        expressionFound = false;
                    }
                }

                if (expressionFound) {
                    if (equalReplace) {
                        System.arraycopy(toWords, 0, wordsArray, i, fromWords.length);
                    } else {
                        int fromLen = fromWords.length;
                        int toLen = toWords.length;
                        int newArrayLen = tempStartIndex + i - origStartIndex + toLen;
                        if (newArrayLen > temp.length) {
                            String[] newTemp = new String[temp.length + newArrayLen + 50];
                            System.arraycopy(temp, 0, newTemp, 0, temp.length);
                            temp = newTemp;
                        }

                        int originalCopyLen = Math.max(i-origStartIndex, 0);
                        System.arraycopy(wordsArray, origStartIndex, temp, tempStartIndex, originalCopyLen);
                        System.arraycopy(toWords, 0, temp, tempStartIndex+i-origStartIndex, toLen);
                        tempStartIndex += i-origStartIndex+toLen;
                        origStartIndex = i+fromLen;
                        i += fromLen - 1;
                    }
                }
            }
        }

        if (origStartIndex < wordsArray.length && !equalReplace) {
            System.arraycopy(wordsArray, origStartIndex, temp, tempStartIndex, wordsArray.length - origStartIndex);
        }

        if (!equalReplace) {
            int i = temp.length - 1;
            int nullCounter = 0;
            while (temp[i] == null) {
                nullCounter++;
                i--;
                if (i == -1) {
                    break;
                }
            }

            if (nullCounter != temp.length) {
                String[] finalTemp = new String[temp.length - nullCounter];
                System.arraycopy(temp, 0, finalTemp, 0, temp.length - nullCounter);
                wordsArray = finalTemp;
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

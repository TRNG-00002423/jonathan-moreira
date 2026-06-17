package com.collections.partnera;
import java.util.Comparator;
import java.util.Map;

public class WordCountComparator implements Comparator<Map.Entry<String,Integer>>{
    @Override
    public int compare(Map.Entry<String,Integer> word1, Map.Entry<String,Integer> word2) {
        
        return word2.getValue().compareTo(word1.getValue());
    }
}

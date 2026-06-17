package com.collections.partnera;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.com.collections.partnera.WordCountComparator;

public class Main {
    public static void main(String[] args) {
        String paragraph = "Hello, hello! World.";
        String [] words = paragraph.toLowerCase().split("[^A-Za-z]+");

        for(String word : words)
            System.out.println(word);

        Map<String,Integer> wordCount = new HashMap<>();
        for(String word : words){
            int count = wordCount.getOrDefault(word, 0);
            wordCount.put(word,count + 1);
        }

        topFrequentWords(2, wordCount);

    }

    public static void topFrequentWords(int n, Map<String,Integer> dic){
        List <Map.Entry<String, Integer>> words = new ArrayList<>();

        for (Map.Entry<String, Integer> en : dic.entrySet()) {
            System.out.println(en);
            words.add(en);
            
        }

        Collections.sort(words, new WordCountComparator());
        System.out.println(words);
    }
}
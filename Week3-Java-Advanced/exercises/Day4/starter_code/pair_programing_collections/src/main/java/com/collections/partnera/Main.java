package com.collections.partnera;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import main.java.com.collections.partnera.WordCountComparator;

public class Main {
    public static void main(String[] args) {
        String paragraph = """
            Java collections maps sets queues lambdas
            Java maps and sets and more Java
            """;
        String [] words = paragraph.toLowerCase().split("[^A-Za-z]+");

        for(String word : words)
            System.out.println(word);

        Map<String,Integer> wordCount = new HashMap<>();
        for(String word : words){
            int count = wordCount.getOrDefault(word, 0);
            wordCount.put(word,count + 1);
        }

        topFrequentWords(2, wordCount);

        TreeSet<String> vocabulary = new TreeSet<>();

        for (String word : words) {
            if (!word.isBlank()) {
                vocabulary.add(word);
            }
        }

        System.out.println(vocabulary.first());
        System.out.println(vocabulary.last());

    }

    public static void topFrequentWords(int n, Map<String,Integer> dic){
        List <Map.Entry<String, Integer>> words = new ArrayList<>();

        for (Map.Entry<String, Integer> en : dic.entrySet()) {
            words.add(en);      
        }

        Collections.sort(words, new WordCountComparator());

        int count = 0;
        System.out.println("\nTop Frequent Words");
        for(Map.Entry<String, Integer> w : words){
            if(count == n)
                break;

            System.out.println(w);
            count++;
        }
    }
}
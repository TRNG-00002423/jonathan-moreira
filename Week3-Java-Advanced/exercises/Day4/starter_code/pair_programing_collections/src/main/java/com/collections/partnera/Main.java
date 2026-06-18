package com.collections.partnera;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
        List<Map.Entry<String, Integer>> words = new ArrayList<>(dic.entrySet());
        Comparator<Map.Entry<String, Integer>> byCountDesc = 
            Comparator.comparingInt((Map.Entry<String, Integer> e) -> e.getValue()).reversed();
        
        Collections.sort(words, byCountDesc);

        System.out.println("\nTop Frequent Words");
        words.stream()
             .limit(n)
             .forEach(System.out::println);
    }
}
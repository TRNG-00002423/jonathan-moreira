package com.collections.partnera;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        String paragraph = """
            Java collections maps sets queues lambdas
            Java maps and sets and more Java
            """;
        String [] words = paragraph.toLowerCase().split("[^A-Za-z]+");
        if (words.length == 0)
            log.warn("No tokens found — paragraph may be empty");

        Map<String,Integer> wordCount = new HashMap<>();
        for(String word : words){
            int count = wordCount.getOrDefault(word, 0);
            wordCount.put(word,count + 1);
            log.debug("Token: {}", word);
        }
        log.info("Unique words found: {}", wordCount.size());

        topFrequentWords(2, wordCount);

        TreeSet<String> vocabulary = new TreeSet<>();

        for (String word : words) {
            if (!word.isBlank()) {
                vocabulary.add(word);
            }
        }

        log.info("First: {}", vocabulary.first());
        log.info("Last: {}", vocabulary.last());

    }

    public static void topFrequentWords(int n, Map<String,Integer> dic){
        List<Map.Entry<String, Integer>> words = new ArrayList<>(dic.entrySet());
        Comparator<Map.Entry<String, Integer>> byCountDesc = 
            Comparator.comparingInt((Map.Entry<String, Integer> e) -> e.getValue()).reversed();
        
        Collections.sort(words, byCountDesc);

        log.info("\nTop Frequent Words");
        words.stream()
             .limit(n)
             .forEach(w -> log.info("Top word: {}", w));
    }
}
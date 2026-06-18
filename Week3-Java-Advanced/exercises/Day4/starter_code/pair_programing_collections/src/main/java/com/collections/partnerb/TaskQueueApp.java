package com.collections.partnerb;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Partner B — drain PriorityQueue in priority order. */
public class TaskQueueApp {
    private static final Logger log = LoggerFactory.getLogger(TaskQueueApp.class);
    public static void main(String[] args) {
        Queue<Task> q = new PriorityQueue<>();
        q.offer(new Task(3, "Clean room"));
        q.offer(new Task(1, "Clean bathroom"));
        q.offer(new Task(4, "Cut grass"));
        q.offer(new Task(2, "Do laundry"));

        log.info("{}",q.peek());
        log.info("Size after peek() {}", q.size());

        // Remove tasks too low priority to action this sprint
        Predicate<Task> isLowPriority = t -> t.getPriority() >= 3;
        q.removeIf(isLowPriority);
        if(q.isEmpty())
            log.warn("No tokens found — queue may be empty");

        while(!q.isEmpty())
            log.debug("{}",q.poll());
        
    }
}
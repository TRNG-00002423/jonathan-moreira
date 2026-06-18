package com.collections.partnerb;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Predicate;

/** Partner B — drain PriorityQueue in priority order. */
public class TaskQueueApp {
    public static void main(String[] args) {
        Queue<Task> q = new PriorityQueue<>();
        // TODO: offer tasks out of order, poll and print, peek demo
        q.offer(new Task(3, "Clean room"));
        q.offer(new Task(1, "Clean bathroom"));
        q.offer(new Task(4, "Cut grass"));
        q.offer(new Task(2, "Do laundry"));

        System.out.println(q.peek());
        System.out.println("Size after peek()" + q.size());

        // Remove tasks too low priority to action this sprint
        Predicate<Task> isLowPriority = t -> t.getPriority() >= 3;
        q.removeIf(isLowPriority);

        while(!q.isEmpty())
            System.out.println(q.poll());
        
    }
}
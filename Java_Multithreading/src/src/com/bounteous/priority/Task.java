package com.bounteous.priority;

import java.util.function.Function;

public class Task<T, K> implements Comparable<Task> {
    private Priority priority;
    private T input;
    Function<T, K> operation;

    public Task(Priority priority, T input, Function<T, K> operation) {
        this.priority = priority;
        this.input = input;
        this.operation = operation;
    }

    public T getInput() {
        return input;
    }

    public Priority getPriority() {
        return priority;
    }

    // the way I defined the enum and the compareTo will give smaller value to higher priority tasks
    // so they will be retrieved from queue first
    @Override
    public int compareTo(Task o) {
        return this.priority.compareTo(o.priority);
    }
}

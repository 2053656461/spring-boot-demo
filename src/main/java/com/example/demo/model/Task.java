package com.example.demo.model;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicLong;

/**
 * A simple task entity held in memory.
 */
public class Task {

    private static final AtomicLong SEQUENCE = new AtomicLong(1000);

    private final Long id;
    private final String title;
    private final boolean done;
    private final Instant createdAt;

    public Task(String title, boolean done) {
        this.id = SEQUENCE.incrementAndGet();
        this.title = title;
        this.done = done;
        this.createdAt = Instant.now();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isDone() {
        return done;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}

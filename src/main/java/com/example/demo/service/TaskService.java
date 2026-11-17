package com.example.demo.service;

import com.example.demo.model.Task;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * In-memory task store. Data is lost when the application stops.
 */
@Service
public class TaskService {

    private final Map<Long, Task> store = new ConcurrentHashMap<>();

    public List<Task> findAll() {
        return store.values().stream()
                .sorted(Comparator.comparing(Task::getId))
                .toList();
    }

    public Optional<Task> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public Task create(String title, boolean done) {
        Task task = new Task(title.trim(), done);
        store.put(task.getId(), task);
        return task;
    }
}

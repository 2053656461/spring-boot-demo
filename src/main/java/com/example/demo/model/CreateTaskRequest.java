package com.example.demo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Request body for creating a task.
 */
public class CreateTaskRequest {

    @NotBlank(message = "title must not be blank")
    @Size(max = 120, message = "title must be at most 120 characters")
    private String title;

    private boolean done;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}

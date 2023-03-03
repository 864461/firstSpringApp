package com.todoapplication.myfirstwebapp.todo;

import javax.validation.constraints.Size;
import java.time.LocalDate;

public class ToDo {
    private int id;

    @Size(min=10, message="Enter at-least 10 characters")
    private String description;
    private String userName;
    private LocalDate targetDate;
    private boolean done;


    public ToDo(int id, String description,String userName, LocalDate targetDate, boolean done) {
        this.id = id;
        this.userName = userName;
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }


    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", userName='" + userName + '\'' +
                ", targetDate=" + targetDate +
                ", done=" + done +
                '}';
    }
}

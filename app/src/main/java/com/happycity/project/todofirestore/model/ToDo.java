package com.happycity.project.todofirestore.model;

/**
 * Created by Ha Truong on 10/16/2017.
 * This is a ToDoFireStore
 * into the com.happycity.project.todofirestore.model
 */

public class ToDo {
    private String id;
    private String title;
    private String description;

    public ToDo(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public ToDo() {
    }

    public String getId() {
        return id;
    }

    public ToDo setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ToDo setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ToDo setDescription(String description) {
        this.description = description;
        return this;
    }
}

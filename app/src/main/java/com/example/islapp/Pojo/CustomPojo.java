package com.example.islapp.Pojo;

import java.util.ArrayList;

public class CustomPojo {

    private final ArrayList<CustomPojo> customPojo = new ArrayList<>();
    //POJO class consists of get method and set method
    private String name;
    private String time, content;
    private int i;

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    private boolean done;

    public CustomPojo() {

    }

    //getting content value
    public String getContent() {
        return content;
    }

    //setting content value
    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInt(int i) {
        this.i = i;
    }

}

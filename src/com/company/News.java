package com.company;

import java.sql.Timestamp;

public class News {
    private int Id;
    private String heading;
    private String text;
    private Timestamp time;
    public News(){}

    public News(int id, String heading, String text) {
        Id = id;
        this.heading = heading;
        this.text = text;
    }

    public News(int id, String heading, String text, Timestamp time) {
        Id = id;
        this.heading = heading;
        this.text = text;
        this.time = time;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}


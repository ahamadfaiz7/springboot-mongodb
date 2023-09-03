package com.mongo.faiz.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.InputStream;

@Document(collection = "photos")
public class Video {
    private String title;
    private InputStream stream;

    public Video(String title, InputStream stream) {
        this.title = title;
        this.stream = stream;
    }

    public Video() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public InputStream getStream() {
        return stream;
    }

    public void setStream(InputStream stream) {
        this.stream = stream;
    }
}

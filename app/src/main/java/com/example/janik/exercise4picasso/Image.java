package com.example.janik.exercise4picasso;

/**
 * Created by janik on 24.09.2017.
 */

public class Image {
    private String name;
    private String url;

    public Image(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }
}

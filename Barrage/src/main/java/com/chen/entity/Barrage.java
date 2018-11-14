package com.chen.entity;

public class Barrage {
    private String text;

    public Barrage() {
    }

    public Barrage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Barrage{" +
                "text='" + text + '\'' +
                '}';
    }
}

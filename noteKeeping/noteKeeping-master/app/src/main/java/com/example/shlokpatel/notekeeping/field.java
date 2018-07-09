package com.example.shlokpatel.notekeeping;

public class field {
    String text,date;
    int prior;

    public field(String text, String date, int prior) {
        this.text = text;
        this.date = date;
        this.prior = prior;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrior() {
        return prior;
    }

    public void setPrior(int prior) {
        this.prior = prior;
    }
}

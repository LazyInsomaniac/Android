package com.example.shlokpatel.githubclone;

import java.util.ArrayList;

public class Result {
    int total_count;
    boolean incomplete_results;
    ArrayList<item> items;

    public Result() {
    }

    public Result(int total_count, boolean incomplete_results, ArrayList<item> items) {
        this.total_count = total_count;
        this.incomplete_results = incomplete_results;
        this.items = items;
    }

    public int getTotal_count() {
        return total_count;
    }

    public boolean isIncomplete_results() {
        return incomplete_results;
    }

    public ArrayList<item> getItems() {
        return items;
    }
}

package com.example.sambhav.pokeapi;

public class item {
    String name,url;
    int id;
    int base_experience;
    int height;
    int weight;

    public item() {

    }


    public item(String name,String url, int id, int base_experience, int height, int weight) {
        this.name = name;
        this.url = url;
        this.id = id;
        this.base_experience = base_experience;
        this.height = height;
        this.weight = weight;

    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getBase_experience() {
        return base_experience;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }
}

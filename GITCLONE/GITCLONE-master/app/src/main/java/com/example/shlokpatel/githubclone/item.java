package com.example.shlokpatel.githubclone;

public class item {
    String login,avatar_url,html_url;
    int id;

    public item() {
    }

    public item(String login, String avatar_url, String html_url, int id) {
        this.login = login;
        this.avatar_url = avatar_url;
        this.html_url = html_url;
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public int getId() {
        return id;
    }
}

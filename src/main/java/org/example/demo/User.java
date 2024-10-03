package org.example.demo;

public class User {
    private String username;
    private String password;
    private String email;
    private String url;


    public User(String username, String password, String email, String url) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.url = url;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

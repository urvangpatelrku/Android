package com.rku_21soeca21002.demovolley;

public class Users {
    private int id;
    private String name;
    private String email;
    private String number;
    private String website;

    public Users(int id, String name, String email, String number, String website) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.number = number;
        this.website = website;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}

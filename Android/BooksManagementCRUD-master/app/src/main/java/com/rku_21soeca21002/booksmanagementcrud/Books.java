package com.rku_21soeca21002.booksmanagementcrud;

public class Books {
    private int id;
    private String title;
    private String price;
    private String author;

    public Books(int id, String title, String price, String author) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

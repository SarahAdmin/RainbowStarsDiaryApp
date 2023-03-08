package com.example.rainbowstarsdiary;

public class Entry {
    private int id;
    private int date;
    private int time;
    private String book_title;
    private int pagesRead;
    private int rating;
    private String tComments;

    public Entry(int id, int date, int time, String book_title, int pagesRead, int rating,
                 String tComments) {
        super();
        this.id = id;
        this.date = date;
        this.time = time;
        this.book_title = book_title;
        this.pagesRead = pagesRead;
        this.rating = rating;
        this.tComments = tComments;
    }

    public Entry(int date, int time, String book_title, int pagesRead, int rating,
                 String tComments) {
        this.date = date;
        this.time = time;
        this.book_title = book_title;
        this.pagesRead = pagesRead;
        this.rating = rating;
        this.tComments = tComments;
    }

    public int getId() {
        return id;
    }
    public int getDate() {
        return date;
    }
    public void setDate(int date) {
        this.date = date;
    }
    public int getTime() {
        return time;
    }
    public void setTime (int time) {
        this.time = time;
    }
    public String getBook_title() {
        return book_title;
    }
    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }
    public int getPagesRead() {
        return pagesRead;
    }
    public void setPagesRead(int pagesRead) {
        this.pagesRead = pagesRead;
    }

    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public String gettComments() {
        return tComments;
    }
    public void settComments(String tComments) {
        this.tComments = tComments;
    }
    @Override
    public String toString() {
        return "Diary Entry [id=" + id + ",date="+ date + ",time=" + time + ",book_title" + book_title +
                ",pages_read= " + pagesRead + ",rating=" + rating + ",teacher comments=" + tComments +"]";
    }
}

package bvs.objects;

import java.util.ArrayList;

public class Book {
    private final String isbn;
    private final String title;
    private final int year;
    private final String city;
    private final String publisher;
    private final int edition;
    private ArrayList<String> authors;

    public Book(String isbn, String title, int year, String city, String publisher, int edition, ArrayList<String> authors) {
        this.isbn = isbn;
        this.title = title;
        this.year = year;
        this.city = city;
        this.publisher = publisher;
        this.edition = edition;
        this.authors = authors;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getCity() {
        return city;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getEdition() {
        return edition;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }
}
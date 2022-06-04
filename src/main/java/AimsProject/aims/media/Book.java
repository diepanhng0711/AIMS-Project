package AimsProject.aims.media;

import AimsProject.aims.media.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class Book extends Media {
    //private String title;
    //private String category;
    //private float cost;
    private List<String> authors = new ArrayList<String>();
    private List<String> contentTokens = new ArrayList<String>();
    private Map<String, Integer> wordFrequency = new TreeMap<String, Integer>();

    public Book() {
        super("", "", "", 0.0f);
    }

    public Book(String id, String title, String category, float cost, List<String> authors) {
        super(id, title, category, cost);
        //this.title = title;
        //this.category = category;
        //this.cost = cost;
        this.authors = authors;
    }

    public Book(Book book) {
        super(book.getId(), book.getTitle(), book.getCategory(), book.getCost());
        this.authors = book.getAuthors();
    }

    public void addAuthor(String authorName) {
        for(String author: this.authors) {
            if (author.equals(authorName)) {
                System.out.println("This author has already been in the authorslist. Cannot add!");
                return ;
            }
        }
        this.authors.add(authorName);
        return ;
    }

    public void removeAuthor(String authorName) {
        int flag = 0;
        for(String author: this.authors) {
            if (author.equals(authorName)) {
                this.authors.remove(authorName);
                System.out.println("This author has already been removed!");
                flag = 1;
            }
        }
        if (flag == 0) System.out.println("Cannot find the author's name in this list!");
        return ;
    }

    public void processContent(String string) {

    }

    public List<String> getAuthors() {
        return this.authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

}
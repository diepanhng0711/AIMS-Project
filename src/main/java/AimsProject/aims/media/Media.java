package AimsProject.aims.media;

import AimsProject.aims.disc.*;
import AimsProject.aims.media.*;
import AimsProject.aims.disc.track.*;

public class Media implements Comparable<Media> {
    private String id;
    private String title;
    private String category;
    private float cost;

    public Media(String id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }


    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return this.cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean equals(Media media) {
        if (this.id.equals(media.getId())) {
            return true;
        }
        return false;
    }

    public int compareTo(Media media) {
        return this.getTitle().compareTo(media.getTitle());
    }

    public void printMedia() {
        if (this instanceof DigitalVideoDisc) {
            DigitalVideoDisc disc = new DigitalVideoDisc((DigitalVideoDisc) this);  //down-casting
            System.out.println("DVD - [" + disc.getTitle() + "] - [" + disc.getCategory() + "] - [" + disc.getDirector() + "] - [" + disc.getLength() + "]: [" + disc.getCost() + " $]");
        } else if (this instanceof Book) {
            Book book = new Book((Book) this);                                      //down-casting
            System.out.println("--> Book: [" + book.getTitle() + "]");
            System.out.println(" <+> Category: [" + book.getCategory() + "]");
            System.out.print(" <+>Author(s):");

            for (String author: book.getAuthors()) {
                System.out.print(" [" + author + "]");
            }
            System.out.println();
            System.out.println(" <+> Cost: [" + book.getCost() + " $]");
        } else if (this instanceof CompactDisc) {
            CompactDisc compactDisc = new CompactDisc((CompactDisc) this);          //down-casting

            System.out.println("--> CD: [" + compactDisc.getTitle() + "]");
            System.out.println("--> Artist: [" + compactDisc.getArtist() + "]");
            System.out.println("--> Tracks list: ");
            System.out.println();
            int serialNum = 1;
            for (Track track: compactDisc.getTracks()) {
                System.out.println(serialNum + ". " + track.getTitle());
                System.out.println(" --> Length: " + track.getLength());
                System.out.println();
                serialNum++;
            }
            System.out.println("--> Length of CD: [" + compactDisc.getLength() + "]");
            System.out.println("--> Cost: [" + compactDisc.getCost() + " $]");
        }
        System.out.println();
        System.out.println("***************************************************");
    }
}


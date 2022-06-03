package AimsProject.aims.disc;

import AimsProject.aims.media.*;

public class DigitalVideoDisc extends Disc implements Playable {
    //private String title;
    //private String category;
    //private String director;
    //private int length;
    //private float cost;

    public DigitalVideoDisc() {
        super("", "", "", "", 0, 0.0f);
    }

    public DigitalVideoDisc(String title) {
        super("", title, "", "", 0, 0.0f);
    }

    public DigitalVideoDisc(String title, String category) {
        super("",title, category, "", 0, 0.0f);
    }

    public DigitalVideoDisc(String title, String category, String director) {
        super("",title, category, director, 0, 0.0f);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super("",title, category,director, length, cost);
    }

    public DigitalVideoDisc(String id, String title, String category, String director, int length, float cost) {
        super(id, title, category, director, length, cost);
    }

    public DigitalVideoDisc(DigitalVideoDisc dvd) {
        super(dvd.getId(), dvd.getTitle(), dvd.getCategory(), dvd.getDirector(), dvd.getLength(), dvd.getCost());
    }

    /*public void setTitle(String title) {
        this.title = title;
    }*/

    /*public void setCategory(String category) {
        this.category = category;
    }*/

    /*public void setDirector(String director) {
        this.director = director;
    }

    public void setLength(int length) {
        this.length = length;
    }*/

    /*public void setCost(float cost) {
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }*/

    /*public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }*/

    /*public float getCost() {
        return cost;
    }*/

    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    /*public int compareTo(DigitalVideoDisc disc) {
        return this.getTitle().compareTo(disc.getTitle());
    }*/

    public void printInfo() {
        System.out.println("----------DVD INFO----------");
        System.out.println("Title: " + this.getTitle());
        System.out.println("Category: " + this.getCategory());
        System.out.println("Director: "+ this.getDirector());
        System.out.println("Length: " + this.getLength());
        System.out.println("Cost: " + this.getCost());
    }
}
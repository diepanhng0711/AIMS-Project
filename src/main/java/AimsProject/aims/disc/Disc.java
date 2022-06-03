package AimsProject.aims.disc;

import AimsProject.aims.media.Media;

public class Disc extends Media {
    private int length;
    private String director;

    public Disc() {
        super("", "", "", 0.0f);
        this.director = "";
        this.length = 0;
    }

    public Disc(String title) {
        super("", title, "", 0.0f);
        //this.title = title;
    }

    public Disc(String title, String category) {
        super("",title, category, 0.0f);
        //this.title = title;
        //this.category = category;
    }

    public Disc(String title, String category, String director) {
        super("",title, category, 0.0f);
        //this.title = title;
        //this.category = category;
        this.director = director;
    }

    public Disc(String title, String category, String director, int length, float cost) {
        super("",title, category, cost);
        //this.title = title;
        //this.category = category;
        this.director = director;
        this.length = length;
        //this.cost = cost;
    }

    public Disc(String id, String title, String category, String director, int length, float cost) {
        super(id, title, category, cost);
        //this.title = title;
        //this.category = category;
        this.director = director;
        this.length = length;
        //this.cost = cost;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getDirector() {
        return this.director;
    }

    public void setDirector(String director) {
        this.director = director;
    }


}


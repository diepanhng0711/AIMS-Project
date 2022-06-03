package AimsProject.aims.disc.track;

import AimsProject.aims.disc.*;
import AimsProject.aims.media.*;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return this.title;
    }

    public int getLength() {
        return this.length;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setLength(int length) {
        this.length = length;
    }


    public void play() {
        System.out.println("Playing Track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    public boolean equals(Track track) {
        if (this.title.equals(track.getTitle()) && this.length == track.getLength()) {
            return true;
        }
        return false;
    }
}

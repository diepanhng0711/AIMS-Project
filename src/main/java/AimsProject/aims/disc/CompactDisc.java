package AimsProject.aims.disc;

import AimsProject.aims.media.*;

import java.util.ArrayList;

import AimsProject.aims.disc.track.Track;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    public ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc() {
        super("", "", "", "", 0, 0.0f);
    }

    public CompactDisc(String discTitle) {
        super("", discTitle, "", "", 0, 0.0f);
    }

    public CompactDisc(String discTitle, String category) {
        super("",discTitle, category, "", 0, 0.0f);
    }

	/*public CompactDisc(String discTitle, String category, String director) {
		super("",discTitle, category, director, 0, 0.0f);
	}*/

    public CompactDisc(String discTitle, String category, String director, int discLength, float cost) {
        super("",discTitle, category,director, discLength, cost);
    }

    public CompactDisc(String id, String discTitle, String category, String director, int discLength, float cost) {
        super(id, discTitle, category, director, discLength, cost);
    }

    public CompactDisc(String id, String discTtile ,String artist, float cost) {
        super(id, discTtile, "", "", 0, cost);
        this.artist = artist;
    }

    public CompactDisc(CompactDisc disc) {
        super(disc.getId(), disc.getTitle(), disc.getCategory(), disc.getDirector(), disc.getLength(), disc.getCost());
        this.artist = disc.getArtist();
        this.tracks = disc.getTracks();
    }

    public boolean contains(Track newTrack) {
        //TO DO
        return true;
    }

    public void addTrack(Track newTrack) {
        for(Track track: this.tracks) {
            if (newTrack.equals(track)) {
                System.out.println("The track [" + newTrack.getTitle() + "] is already in the list!");
                System.out.println();
                return ;
            }
        }
        this.tracks.add(newTrack);
        this.setLength(this.getLength() + newTrack.getLength());
        System.out.println("The track [" + newTrack.getTitle() + "] has been added!");
        System.out.println();
    }

    public void removeTrack(Track removeTrack) {
        int checkflag = 0;
        for(Track track: tracks) {
            if (removeTrack.equals(track)) {
                tracks.remove(removeTrack);
                checkflag = 1;
                break;
            }
        }

        if (checkflag == 0) {
            System.out.println("The track [" + removeTrack.getTitle() + "] doesn't exist in the list!");
        }
    }

    public void play() {
        System.out.println("*** The title of the currently playing compact disc: [" + this.getTitle() + "] ***");
        System.out.println(" ===>>> Tracks list <<<====");
        System.out.println();
        int serialNum = 1;
        for (Track track: tracks) {
            System.out.println(serialNum + ". " + track.getTitle());
            System.out.println("Track length: " + track.getLength());
            System.out.println();
        }
    }

    public int getLength() {
        int sum = 0;
        for (Track track: tracks) {
            sum += track.getLength();
        }
        return sum;
    }

    public int getLength(ArrayList<Track> tracks) {
        int totalLength = 0;
        for (Track track: tracks) {
            totalLength += track.getLength();
        }
        super.setLength(totalLength);
        return totalLength;
    }

    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public ArrayList<Track> getTracks() {
        return this.tracks;
    }

    public void setTracks(ArrayList<Track> tracks) {
        this.tracks = tracks;
    }
}

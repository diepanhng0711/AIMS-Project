package AimsProject.aims.order;

import java.util.ArrayList;
import java.util.Random;

import AimsProject.aims.disc.CompactDisc;
import AimsProject.aims.disc.DigitalVideoDisc;
import AimsProject.aims.media.Media;
import AimsProject.aims.media.Book;
import AimsProject.aims.utils.MyDate;
import AimsProject.aims.disc.track.Track;

public class Order {
    public static final int MAX_NUMBER_ORDERED = 10;

    public static final int MAX_LIMITED_ORDERS = 5;

    private static int nbOrders = 0;

    private int qtyOrdered = 0;

    //private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];

    public ArrayList<Media> itemsOrdered = new ArrayList<Media>();


    public Order() {
        /*if (nbOrders >= 5) {
            System.out.println("Full of orders! Cannot add another order!");
            return ;
        }*/         //Wrong if syntax since a new Order instance is still created after returning a null value to exit the constructor of this class
        nbOrders++;
        //System.out.println("A new order has been created!");
    }

    public static int getNumberOfOrders() {
        return nbOrders;
    }

    public int getQtyOrdered () {
        return this.qtyOrdered;
    }

    public void setQtyOrdered(int qtyOrdered) {
        this.qtyOrdered = qtyOrdered;
    }

    public Media getMedia(int index) {
        return itemsOrdered.get(index);
    }

    public void addMedia(Media media) {
        if (qtyOrdered < MAX_NUMBER_ORDERED) {
            for (Media item: itemsOrdered) {
                if (item.getId() == media.getId()) {
                    System.out.println("This item has already been added to the order!");
                    return;
                }
            }
            itemsOrdered.add(media);
            qtyOrdered++;
            System.out.println("The new media has been added successfully!");
        } else {
            System.out.println("The order is already full!");
        }
    }

    //xóa đĩa trực tiếp
    public void removeMedia(Media media) {
        if (qtyOrdered == 0) {
            System.out.println("Empty media list!");
        } else {
            itemsOrdered.remove(media);
            qtyOrdered--;
            System.out.println("Removed [" + media.getTitle() + "] successfully!");
        }
    }

    //xóa đĩa theo chỉ số index
    public void removeMedia(int index) {
        if (qtyOrdered == 0) {
            System.out.println("Empty media list!");
        } else {
            itemsOrdered.remove(itemsOrdered.get(index));
            qtyOrdered--;
            System.out.println("Removed [" + index + "] successfully!");
        }
    }

    public void removeMedia(String id) {
        if (qtyOrdered == 0) {
            System.out.println("Empty media list!");
        } else {
            int checkflag = 0;
            for (Media item: itemsOrdered) {
                String comID = new String(item.getId());
                if(id.equals(comID)) {
                    itemsOrdered.remove(item);
                    qtyOrdered--;
                    checkflag = 1;
                    break;
                }
            }

            if (checkflag == 1) System.out.println("Removed [" + id + "] successfully!");
            else System.out.println("Cannot find the media with the ID [" + id + "] in this order list!" );
        }
    }

    public float totalCost() {
        float total = 0.0f;
        for(Media item: itemsOrdered) {
            total += item.getCost();
        }
        return total;
    }

    public Media getALuckyItem() {
        Random rd = new Random();
        int luckynumber = rd.nextInt(this.qtyOrdered);
        this.itemsOrdered.get(luckynumber).setCost(0);
        return this.itemsOrdered.get(luckynumber);
    }

    //Handling NullPointerException
    public void printAnOrder() throws NullPointerException {
        System.out.println("***********************Order***********************");
        MyDate dateOrdered = new MyDate();
        System.out.println();
        System.out.println("Date: " + dateOrdered.getLocalDate());
        System.out.println("Ordered Items:");

        for (Media item: itemsOrdered) {
            if (item instanceof DigitalVideoDisc) {
                DigitalVideoDisc disc = new DigitalVideoDisc((DigitalVideoDisc) item);  //down-casting
                System.out.println("DVD - [" + disc.getTitle() + "] - [" + disc.getCategory() + "] - [" + disc.getDirector() + "] - [" + disc.getLength() + "]: [" + disc.getCost() + " $]");
            } else if (item instanceof Book) {
                Book book = new Book((Book) item);                                      //down-casting
                System.out.println("--> Book: [" + book.getTitle() + "]");
                System.out.println(" <+> Category: [" + book.getCategory() + "]");
                System.out.print(" <+> Author(s):");

                for (String author: book.getAuthors()) {
                    System.out.print(" [" + author + "]");
                }
                System.out.println();
                System.out.println(" <+> Cost: [" + book.getCost() + " $]");
            } else if (item instanceof CompactDisc) {
                CompactDisc compactDisc = new CompactDisc((CompactDisc) item);          //down-casting

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
            }
            System.out.println();
        }
        System.out.println("Total cost: [" + this.totalCost() + " $]");
        System.out.println("***************************************************");
    }

}
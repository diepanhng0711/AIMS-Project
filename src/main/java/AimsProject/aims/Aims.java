package AimsProject.aims;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import AimsProject.aims.disc.CompactDisc;
import AimsProject.aims.disc.DigitalVideoDisc;
import AimsProject.aims.media.Book;
import AimsProject.aims.media.Media;
import AimsProject.aims.order.Order;
import AimsProject.aims.disc.track.Track;

public class Aims {
    public static void main(String args[]) {
        // IOException Handling with try-catch
        try {
            ArrayList<Order> anOrder = new ArrayList<Order>();

            while (true) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Order Management Application: ");
                System.out.println("--------------------------------");
                System.out.println("1. Create new order");
                System.out.println("2. Add item to the order");
                System.out.println("3. Delete item by id");
                System.out.println("4. Display the items list of order");
                System.out.println("0. Exit");
                System.out.println("--------------------------------");
                System.out.print("Please enter your selection: 0-1-2-3-4: -->  ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("\n1. Create new order\n");
                        if (Order.getNumberOfOrders() == 5) {
                            System.out.println("Full of orders! Cannot add another order!\n");
                            break;
                        }
                        Order newOrder = new Order();
                        anOrder.add(newOrder);
                        System.out.println("Number of existing orders: " + anOrder.size() + "\n");
                        break;
                    case 2:
                        if (Order.getNumberOfOrders() == 0) {
                            System.out.println("\nNo exisiting order! Please create a new order first!\n");
                            break;
                        }
                        System.out.println("\n2. Add item to the order\n");
                        System.out.println("Please enter <1. DigitalVideoDisc> / <2.CompactDisc> / <3. Book>");
                        System.out.print("  --> ");
                        int type = sc.nextInt();

                        if (type == 1) {
                            System.out.println("Please enter the information of the disc following this format");
                            System.out.println("---<ID - Title - Category - Director - Length - Cost>---");
                            System.out.print("--> ID: \n");
                            String nID = sc.next();
                            sc.nextLine();
                            System.out.println("--> Title: ");
                            String nTitle = sc.nextLine();
                            // sc.nextLine();
                            System.out.println("--> Category: ");
                            String nCategory = sc.nextLine();
                            // sc.next();
                            System.out.println("--> Director: ");
                            String nDirector = sc.nextLine();
                            // sc.nextLine();
                            System.out.println("--> Length: ");
                            int nLength = sc.nextInt();
                            sc.nextLine();
                            System.out.println("--> Cost: ");
                            float nCost = sc.nextFloat();

                            DigitalVideoDisc newDisc = new DigitalVideoDisc(nID, nTitle, nCategory, nDirector, nLength,
                                    nCost);
                            anOrder.get(anOrder.size() - 1).addMedia(newDisc);
                        } else if (type == 2) {
                            System.out.println("Please enter the compact disc information first following this format");
                            System.out.println("---<ID - Title - Artist - Cost>---");
                            System.out.print("--> ID: \n");
                            String nID = sc.next();
                            sc.nextLine();
                            System.out.println("--> Title: ");
                            String nDiscTitle = sc.nextLine();
                            // sc.nextLine();
                            System.out.println("--> Artist: ");
                            String nArtist = sc.nextLine();
                            // sc.nextLine();
                            System.out.println("--> Cost: ");
                            float nCost = sc.nextFloat();

                            CompactDisc newCompactDisc = new CompactDisc(nID, nDiscTitle, nArtist, nCost);

                            System.out.print("Enter the number of tracks in this compact disc: ");
                            int numTrack = sc.nextInt();
                            sc.nextLine();

                            for (int i = 0; i < numTrack; i++) {
                                sc.nextLine();
                                System.out.println("Input track --->");
                                System.out.println("--> Track's title: ");
                                String nTrack = sc.nextLine();
                                // sc.nextLine();
                                System.out.println("--> Track's length: ");
                                int nLength = sc.nextInt();

                                Track newTrack = new Track(nTrack, nLength);
                                newCompactDisc.addTrack(newTrack);
                            }
                            anOrder.get(anOrder.size() - 1).addMedia(newCompactDisc);
                        } else if (type == 3) {
                            System.out.println("Please enter the information of the book following this format");
                            System.out.println("---<ID - Title - Category - Number of author - Authors' list - Cost>---");
                            System.out.print("--> ID: \n");
                            String nID = sc.next();
                            sc.nextLine();
                            // sc.nextLine();
                            System.out.println("--> Title: ");
                            String nTitle = sc.nextLine();
                            // sc.nextLine();
                            System.out.println("--> Category: ");
                            String nCategory = sc.nextLine();
                            // sc.nextLine();
                            System.out.println("--> Enter the number of authors: ");
                            int numberofAuthors = sc.nextInt();
                            sc.nextLine();

                            System.out.println("--> Enter the authors's list");
                            List<String> Authors = new ArrayList<String>();
                            for (int i = 0; i < numberofAuthors; i++) {
                                System.out.println("--> Author " + (i + 1) + ": ");
                                String nAuthor = sc.nextLine();
                                Authors.add(nAuthor);
                                //sc.next();
                            }

                            System.out.println("--> Cost: ");
                            float nCost = sc.nextFloat();

                            Book newBook = new Book(nID, nTitle, nCategory, nCost, Authors);
                            anOrder.get(anOrder.size() - 1).addMedia(newBook);
                        } else {
                            System.out.println("Wrong choice!");
                        }
                        break;
                    case 3:
                        if (Order.getNumberOfOrders() == 0) {
                            System.out.println("\nNo exisiting order! Please create a new order first!\n");
                            break;
                        }
                        // int checkflag = 0;

                        System.out.println("\n3. Delete item by id\n");
                        System.out.print("--> Please enter the id of the media you want to delete: ");
                        String ID = sc.next();
                        sc.nextLine();

                        anOrder.get(anOrder.size() - 1).removeMedia(ID);
                        break;
                    case 4:
                        if (Order.getNumberOfOrders() == 0) {
                            System.out.println("\nNo exisiting order! Please create a new order first!\n");
                            break;
                        }

                        int numList = 0;

                        do {
                            System.out.println("\n4. Display the items list of order\n");

                            System.out.print("--> Enter the order list's number: ");
                            numList = sc.nextInt();
                        } while (numList < 1 || numList > Order.getNumberOfOrders());
                        anOrder.get(numList - 1).printAnOrder();
                        break;
                    case 0:
                        System.out.println("\n0. Exit\n");
                        sc.close();
                        System.out.println("Exiting the program~... Have a good day!");
                        System.exit(0);
                    default:
                        System.out.println("\nWrong selection! Please make the right selection!\n");
                        break;
                }
            }
        } catch (Exception e) {
            //The default method to display exceptions detected by the JUT Enterpreter
            //e.printStackTrace();

            System.out.println("IOException detected! Exiting the program!!!");
        }

    }
}
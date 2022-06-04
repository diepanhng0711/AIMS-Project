package AimsProject.main;

import AimsProject.aims.media.*;
import AimsProject.aims.disc.*;
import AimsProject.aims.disc.track.*;
import AimsProject.aims.order.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class AimsMainGUIController {
    static ArrayList<Order> anOrder = new ArrayList<Order>();
    static int insertedOrderID = 0;

    @FXML
    private Button selection1;
    @FXML
    private Button selection2;

    //Bắt sự kiện tạo đơn hàng (SELECTION 1)
    public void addOrder(ActionEvent event) throws IOException {
        if (Order.getNumberOfOrders() == 5) {
            //Vượt quá số đơn hàng tối đa cho phép (5)
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Error");
            alert.setHeaderText("ERROR");
            alert.setContentText("Full of orders! Cannot add another order!");

            alert.show();
        } else {
            Order order = new Order();
            anOrder.add(order);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Create a new order");
            alert.setHeaderText("CREATED SUCCESSFULLY");
            alert.setContentText("A new order has been created!\nNumber of orders: " + Order.getNumberOfOrders());

            alert.show();
        }
    }

    //Bắt sự kiện: Thêm sản phẩm vào đơn hàng (SELECTION 2)
    public void addMediaProduct(ActionEvent event) throws IOException {
        int orderID = 0;
        if (Order.getNumberOfOrders() == 0) {
            //Chưa có đơn hàng nào tồn tại trong hệ thống => báo lỗi
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Error");
            alert.setHeaderText("ERROR");
            alert.setContentText("No order has been created yet!\nPlease create a new order first!");

            alert.show();
        } else {
            TextInputDialog dialog = new TextInputDialog();

            dialog.setTitle("Add new products in the selected order");
            dialog.setHeaderText("ENTER THE ORDER");
            dialog.setContentText("Order ID (1 - 5): ");

            Optional<String> result = dialog.showAndWait();

            if (result.isPresent()) {
                orderID = Integer.parseInt(result.get());
                //Xử lý ngoại lệ nhập giá trị không hợp lệ không phải số nguyên
                try {
                    if (orderID > Order.getNumberOfOrders() || orderID < 1) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);

                    alert.setTitle("Error");
                    alert.setHeaderText("ERROR");
                    alert.setContentText("Order ID is not existed!\nPlease enter a valid order ID!");

                    alert.show();
                    } else {
                        insertedOrderID = orderID;
                        System.out.println("Order ID: " + orderID);
                        //Chuyển sang scene thêm sản phẩm
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(this.getClass().getResource("AddMediaProduct.fxml"));

                        Parent addWindow = loader.load(); //Có thể sử dụng try/catch để bắt IOException
                        Scene scene = new Scene(addWindow);

                        stage.setTitle("Order " + orderID);
                        stage.setScene(scene);
                    }
                }
                catch (NumberFormatException e) {
                    Alert alert1 = new Alert(Alert.AlertType.ERROR);

                    alert1.setTitle("Error");
                    alert1.setHeaderText("ERROR");
                    alert1.setContentText("Invalid order ID!\nPlease enter a number between 1 and 5!");

                    alert1.show();
                }
            }
        }
    }

    //Bắt sự kiện xóa một đơn yêu cầu (SELECTION 3)
    public void deleteAnOrder(ActionEvent event) throws IOException {
        int orderID = 0;
        if (Order.getNumberOfOrders() == 0) {
            //Chưa có đơn hàng nào tồn tại trong hệ thống => báo lỗi
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Error");
            alert.setHeaderText("ERROR");
            alert.setContentText("No order has been created yet!\nPlease create a new order first!");

            alert.show();
        } else {
            TextInputDialog dialog = new TextInputDialog();

            dialog.setTitle("Delete an order");
            dialog.setHeaderText("ENTER THE ORDER TO DELETE");
            dialog.setContentText("Order ID (1 - 5): ");

            Optional<String> result = dialog.showAndWait();

            if (result.isPresent()) {
                orderID = Integer.parseInt(result.get());
                //Xử lý ngoại lệ nhập giá trị không hợp lệ không phải số nguyên
                try {
                    if (orderID > Order.getNumberOfOrders() || orderID < 1) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);

                        alert.setTitle("Error");
                        alert.setHeaderText("ERROR");
                        alert.setContentText("Order ID is not existed!\nPlease enter a valid order ID!");

                        alert.show();
                    } else {
                        System.out.println("Order ID: " + orderID);
                        //Xóa order được chọn
                        anOrder.remove(orderID - 1);
                        Order.decreaseNumberOfOrders();
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);

                        alert.setTitle("Delete an order");
                        alert.setHeaderText("DELETED SUCCESSFULLY");
                        alert.setContentText("Order " + orderID + " has been deleted!\nNumber of orders: " + Order.getNumberOfOrders());

                        alert.show();
                    }
                }
                catch (NumberFormatException e) {
                    Alert alert1 = new Alert(Alert.AlertType.ERROR);

                    alert1.setTitle("Error");
                    alert1.setHeaderText("ERROR");
                    alert1.setContentText("Invalid order ID!\nPlease enter a number between 1 and 5!");

                    alert1.show();
                }
            }
        }
    }

    //Bắt sự kiện in ra thông tin đơn hàng  (SELECTION 4)
    //Tạm thời sử dụng cửa sổ Console cho đến khi đủ rảnh làm GUI tiếp. HIHI Thích thì thích không thích thì thích :>>>
    public void showAllProductsOfOrder(ActionEvent event) {
        int orderID = 0;
        if (Order.getNumberOfOrders() == 0) {
            //Chưa có đơn hàng nào tồn tại trong hệ thống => báo lỗi
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Error");
            alert.setHeaderText("ERROR");
            alert.setContentText("No order has been created yet!\nPlease create a new order first!");

            alert.show();
        } else {
            TextInputDialog dialog = new TextInputDialog();

            dialog.setTitle("Show all products of an order");
            dialog.setHeaderText("ENTER THE ORDER");
            dialog.setContentText("Order ID (1 - 5): ");

            Optional<String> result = dialog.showAndWait();

            if (result.isPresent()) {
                orderID = Integer.parseInt(result.get());
                //Xử lý ngoại lệ nhập giá trị không hợp lệ không phải số nguyên
                try {
                    if (orderID > Order.getNumberOfOrders() || orderID < 1) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);

                        alert.setTitle("Error");
                        alert.setHeaderText("ERROR");
                        alert.setContentText("Order ID is not existed!\nPlease enter a valid order ID!");

                        alert.show();
                    } else {
                        System.out.println("Order ID: " + orderID);
                        //In ra thông tin của đơn hàng được chọn
                        anOrder.get(orderID - 1).printAnOrder();
                    }
                } catch (NumberFormatException e) {
                    Alert alert1 = new Alert(Alert.AlertType.ERROR);

                    alert1.setTitle("Error");
                    alert1.setHeaderText("ERROR");
                    alert1.setContentText("Invalid order ID!\nPlease enter a number between 1 and 5!");

                    alert1.show();
                }
            }
        }
    }

    //Bắt sự kiện CHÓ ĐỎ RED DOG trúng thưởng, Mà vừa đang bận vừa lười, mình làm sau hen hihi (SELECTION 5)
    public void getALuckyItem(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Get a lucky item");
        alert.setHeaderText("NOTIFICATION");
        alert.setContentText("Sorry! This promotion is not available now!\nWe'll come back soon! So stay tuned!");

        alert.show();
    }

    //Bắt sự kiện cà thẻ cà visa các kiểu thanh toán (Make payment) (Minh họa thôi chứ chưa đủ trình để làm huhu :<)
    public void makePayment(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Make payment");
        alert.setHeaderText("Do you want to pay all these orders?");

        int payCost = 0;
        for (int i = 0; i < anOrder.size(); i++) {
            payCost += anOrder.get(i).totalCost();
        }

        alert.setContentText("Total cost = " + payCost + " $");
        alert.getButtonTypes().remove(ButtonType.OK);
        alert.getButtonTypes().addAll(ButtonType.NO, ButtonType.YES);

        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            //Xóa toàn bộ đơn hàng
            for (int i = 0; i < anOrder.size(); i++) {
                anOrder.remove(i);
            }

            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);

            alert1.setTitle("Make payment");
            alert1.setHeaderText("PAYMENT SUCCESSFULLY");
            alert1.setContentText("All orders have been paid!\nYour payment fee is " + payCost + " $\n" + "Thank you very much! See you again!");

            alert1.show();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        } else {
            //Không thanh toán
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);

            alert1.setTitle("Make payment");
            alert1.setHeaderText("PAYMENT CANCELED");
            alert1.setContentText("You have canceled the payment!");

            alert1.show();
        }
    }

    //Bắt sự kiện thoát mà không thanh toán (Quit)
    public void quit(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Quit");
        alert.setHeaderText("Do you want to quit without payment?");

        alert.showAndWait();

        if (alert.getResult() == ButtonType.OK) {
            //Xóa toàn bộ đơn hàng
            for (int i = 0; i < anOrder.size(); i++) {
                anOrder.remove(i);
            }

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        }
    }

    //Bắt sự kiện hiện ra tổng hiện tại khi chọn menu Utils/Total Cost
    public void showTotalCost(ActionEvent event) {
        int totalCost = 0;
        for (int i = 0; i < anOrder.size(); i++) {
            totalCost += anOrder.get(i).totalCost();
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Total cost");
        alert.setHeaderText("TOTAL COST");
        alert.setContentText("Total cost = " + totalCost + " $");

        alert.show();
    }

    //Bắt sự kiện hiển thị trang GitHub của tác giả khi chọn mục "About Me" trong mục "Help" của menu
    public void showGitHubProfile(ActionEvent event) throws IOException {
        //Chuyển sang scene thêm sản phẩm
        Stage stage = new Stage();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("AboutMeWebpage.fxml"));
        Scene scene = new Scene(loader.load());


        stage.setTitle("About Me");
        stage.setScene(scene);
        stage.show();
    }

    //Bắt sự kiện hiển thị thông tin về chương trình khi chọn mục "About AIMS" trong mục "Help" của menu
    public void showAboutAIMS(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("About AIMS");
        alert.setHeaderText("About AIMS");
        alert.setContentText("AIMS - An Internet Media Store" + "\n" +
                            "Version: 1.0" + "\n" +
                            "Author: diepanhng0711");
        alert.showAndWait();
    }

    //Bắt sự kiện help trong menu khi chọn mục AIMS Help
    public void showAIMSHelp(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("AIMS Help");
        alert.setHeaderText("AIMS Help");
        alert.setContentText("Contact me for help!" + "\n" +
                            "Facebook: https://www.facebook.com/diepanhng0711" + "\n" +
                            "GitHub: https://github.com/diepanhng0711" + "\n" +
                            "Tel: +84 946 103 302" + "\n" +
                            "Email: diepanhng0711@gmail.com");
        alert.showAndWait();
    }

}
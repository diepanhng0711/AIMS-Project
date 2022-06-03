package AimsProject.main;

import AimsProject.aims.media.*;
import AimsProject.aims.disc.*;
import AimsProject.aims.disc.track.*;
import AimsProject.aims.order.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.Optional;

public class AimsMainGUIController {
    ArrayList<Order> anOrder = new ArrayList<Order>();

    @FXML
    private Button selection1;
    @FXML
    private Button selection2;

    //Bắt sự kiện tạo đơn hàng (SELECTION 1)
    public void addOrder(ActionEvent event) {
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
    public void addMediaProduct(ActionEvent event) {
        if (Order.getNumberOfOrders() == 0) {
            //Chưa có đơn hàng nào tồn tại trong hệ thống => báo lỗi
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Error");
            alert.setHeaderText("ERROR");
            alert.setContentText("No order has been created yet!\nPlease create a new order first!");

            alert.show();
        } else {
            TextInputDialog dialog = new TextInputDialog();

            dialog.setTitle("Add a new product");
            dialog.setHeaderText("ENTER THE ORDER");
            dialog.setContentText("Order ID (1 - 5): ");

            int orderID = 0;
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
}
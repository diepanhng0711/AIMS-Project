package AimsProject.main;

import AimsProject.aims.media.*;
import AimsProject.aims.disc.*;
import AimsProject.aims.disc.track.*;
import AimsProject.aims.order.*;
import AimsProject.aims.order.Order;
//import AimsProject.main.AimsMainGUIController;

import AimsProject.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class AddMediaProduct implements Initializable {
    @FXML
    private Button Back;

    @FXML
    private TableView<Media> table;
    @FXML
    private TableColumn<Media, Integer> idColumn;
    //@FXML
    //private TableColumn<Media, String> typeColumn;
    @FXML
    private TableColumn<Media, String> titleColumn;
    @FXML
    private TableColumn<Media, String> categoryColumn;
    @FXML
    private TableColumn<Media, Float> costColumn;

    private ObservableList<Media> mediaList;                //List thay đổi => table thay đổi

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mediaList = FXCollections.observableArrayList();

        AimsMainGUIController.anOrder.get(AimsMainGUIController.insertedOrderID - 1).addMedia(new DigitalVideoDisc("ID01", "The Avengers", "Action", "Tony Stark", 50,  100.0f));
        AimsMainGUIController.anOrder.get(AimsMainGUIController.insertedOrderID - 1).addMedia(new DigitalVideoDisc("ID02", "The Avengers", "Action", "Tony Stark", 50,  100.0f));
        for(Media m : AimsMainGUIController.anOrder.get(AimsMainGUIController.insertedOrderID - 1).itemsOrdered) {
            mediaList.add(new Media(m.getId(), m.getTitle(), m.getCategory(), m.getCost()));
        }

        AimsMainGUIController.anOrder.get(AimsMainGUIController.insertedOrderID - 1).printAnOrder();
        System.out.println(AimsMainGUIController.insertedOrderID);

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));     //Phải đúng với tên thuộc tính được khai báo ở class
        //typeColumn.setCellValueFactory(new PropertyValueFactory<Media, String>("type"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));

        //MÀY KHÔNG ĐƯỢC QUÊN CÁI NÀY, QUÁ NHIỀU LẦN RỒI
        table.setItems(mediaList);

        //Đưa cái gì vào bảng thì tự nhấc mông lên mà đặt class được hiện trong bảng vào javafx.base trong module file, nhớ chưa?!!!
    }

    //Bắt sự kiện: thêm đĩa CD (CompactDisc)
    public void addCD(ActionEvent event) throws IOException {
        CompactDisc newCD = new CompactDisc();
        Dialog<List<String>> cdDialog = new Dialog<>();
        cdDialog.setTitle("Add a new CD");
        cdDialog.setHeaderText("CD information");

        ButtonType buttonTypeOk = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        cdDialog.getDialogPane().getButtonTypes().addAll(buttonTypeOk, buttonTypeCancel);

        // Nhập thông tin của CD
        // Tạo layout GridPane
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new javafx.geometry.Insets(20, 50, 10, 10));

        TextField id = new TextField();
        id.setPromptText("ID");

        TextField title = new TextField();
        title.setPromptText("Title");

        TextField artist = new TextField();
        artist.setPromptText("Artist");

        TextField category = new TextField();
        category.setPromptText("Category");

        TextField cost = new TextField();
        cost.setPromptText("Cost");

        grid.add(new Label("ID:"), 0, 0);
        grid.add(id, 1, 0);
        grid.add(new Label("Title:"), 0, 1);
        grid.add(title, 1, 1);
        grid.add(new Label("Artist:"), 0, 2);
        grid.add(artist, 1, 2);
        grid.add(new Label("Category:"), 0, 3);
        grid.add(category, 1, 3);
        grid.add(new Label("Cost:"), 0, 4);
        grid.add(cost, 1, 4);

        Node addButton = cdDialog.getDialogPane().lookupButton(buttonTypeOk);
        addButton.setDisable(true);

        //Khi người dùng nhập thông tin thì button OK sẽ được bật
        id.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.trim().isEmpty()) {
                addButton.setDisable(true);
            } else {
                addButton.setDisable(false);
            }
        });

        title.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.trim().isEmpty()) {
                addButton.setDisable(true);
            } else {
                addButton.setDisable(false);
            }
        });

        artist.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.trim().isEmpty()) {
                addButton.setDisable(true);
            } else {
                addButton.setDisable(false);
            }
        });

        category.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.trim().isEmpty()) {
                addButton.setDisable(true);
            } else {
                addButton.setDisable(false);
            }
        });

        cost.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.trim().isEmpty()) {
                addButton.setDisable(true);
            } else {
                addButton.setDisable(false);
            }
        });

        cdDialog.getDialogPane().setContent(grid);

        cdDialog.setResultConverter(dialogButton -> {
            if (dialogButton == buttonTypeOk) {
                newCD.setId(id.getText());
                newCD.setTitle(title.getText());
                newCD.setArtist(artist.getText());
                newCD.setCategory(category.getText());
                newCD.setCost(Float.parseFloat(cost.getText()));
            }
            return null;
        });

        cdDialog.showAndWait();

        if(newCD.getId() != null && newCD.getTitle() != null && newCD.getArtist() != null && newCD.getCategory() != null && newCD.getCost() != 0.0f) {
            AimsMainGUIController.anOrder.get(AimsMainGUIController.insertedOrderID - 1).addMedia(newCD);
            mediaList.add(new Media(newCD.getId(), newCD.getTitle(), newCD.getCategory(), newCD.getCost()));

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("AddCD.fxml"));

            Parent sampleParent = loader.load();
            Scene scene = new Scene(sampleParent);

            stage.setScene(scene);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please fill valid data in all the fields");
            alert.show();
        }

    }

    //Bắt sự kiện thêm đĩa DVD
    public void addDVD(ActionEvent event) throws IOException {
        DigitalVideoDisc newDVD = new DigitalVideoDisc();
        Dialog<List<String>> dvdDialog = new Dialog<>();
        dvdDialog.setTitle("Add a new DVD");
        dvdDialog.setHeaderText("CD information");

        ButtonType buttonTypeOk = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        dvdDialog.getDialogPane().getButtonTypes().addAll(buttonTypeOk, buttonTypeCancel);

        // Nhập thông tin của DVD
        // Tạo layout GridPane
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new javafx.geometry.Insets(20, 50, 10, 10));

        TextField id = new TextField();
        id.setPromptText("ID");

        TextField title = new TextField();
        title.setPromptText("Title");

        TextField category = new TextField();
        category.setPromptText("Category");

        TextField director = new TextField();
        director.setPromptText("Director");

        TextField length = new TextField();
        length.setPromptText("Length");

        TextField cost = new TextField();
        cost.setPromptText("Cost");

        grid.add(new Label("ID:"), 0, 0);
        grid.add(id, 1, 0);
        grid.add(new Label("Title:"), 0, 1);
        grid.add(title, 1, 1);
        grid.add(new Label("Category:"), 0, 2);
        grid.add(category, 1, 2);
        grid.add(new Label("Director:"), 0, 3);
        grid.add(director, 1, 3);
        grid.add(new Label("Length:"), 0, 4);
        grid.add(length, 1, 4);
        grid.add(new Label("Cost:"), 0, 5);
        grid.add(cost, 1, 5);

        Node addButton = dvdDialog.getDialogPane().lookupButton(buttonTypeOk);
        addButton.setDisable(true);

        //Khi người dùng nhập thông tin thì button OK sẽ được bật
        id.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.trim().isEmpty()) {
                addButton.setDisable(true);
            } else {
                addButton.setDisable(false);
            }
        });

        title.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.trim().isEmpty()) {
                addButton.setDisable(true);
            } else {
                addButton.setDisable(false);
            }
        });

        category.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.trim().isEmpty()) {
                addButton.setDisable(true);
            } else {
                addButton.setDisable(false);
            }
        });

        director.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.trim().isEmpty()) {
                addButton.setDisable(true);
            } else {
                addButton.setDisable(false);
            }
        });

        length.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.trim().isEmpty()) {
                addButton.setDisable(true);
            } else {
                addButton.setDisable(false);
            }
        });

        cost.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.trim().isEmpty()) {
                addButton.setDisable(true);
            } else {
                addButton.setDisable(false);
            }
        });

        dvdDialog.getDialogPane().setContent(grid);

        dvdDialog.setResultConverter(dialogButton -> {
            if (dialogButton == buttonTypeOk) {
                newDVD.setId(id.getText());
                newDVD.setTitle(title.getText());
                newDVD.setCategory(category.getText());
                newDVD.setDirector(director.getText());
                newDVD.setLength(Integer.parseInt(length.getText()));
                newDVD.setCost(Float.parseFloat(cost.getText()));
            }
            return null;
        });

        dvdDialog.showAndWait();

        if(newDVD.getId() != null && newDVD.getTitle() != null && newDVD.getCategory() != null && newDVD.getDirector() != null && newDVD.getLength() != 0 && newDVD.getCost() != 0.0f) {
            AimsMainGUIController.anOrder.get(AimsMainGUIController.insertedOrderID - 1).addMedia(newDVD);
            mediaList.add(new Media(newDVD.getId(), newDVD.getTitle(), newDVD.getCategory(), newDVD.getCost()));
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please fill valid data in all the fields");
            alert.show();
        }
    }

    //Bắt sự kiện thêm Book mới
    public void addBook(ActionEvent event) {

    }


    //Bắt sự kiện cho button Back: quay lại cửa sổ AIMS ban đầu
    public void goBack(ActionEvent event) throws IOException {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("AimsMainGUIController.fxml"));

        Parent sampleParent = loader.load();
        Scene scene = new Scene(sampleParent);

        stage.setScene(scene);
    }
}

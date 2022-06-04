package AimsProject.main;

import AimsProject.aims.disc.CompactDisc;
import AimsProject.aims.disc.track.Track;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddCD implements Initializable {
    @FXML
    private Button backButton;
    @FXML
    private Button addButton;
    @FXML
    private Button OKButton;
    @FXML
    private Button deleteButton;

    @FXML
    private TableView<Track> table;
    @FXML
    private TableColumn<Track, String> titleColumn;
    @FXML
    private TableColumn<Track, Integer> lengthColumn;
    @FXML
    private TextField titleField;
    @FXML
    private TextField lengthField;

    private ObservableList<Track> trackList;

    //Khởi tạo TableView cho AddCD để thêm/xóa track trong CD
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        trackList = FXCollections.observableArrayList();

        int index = AimsMainGUIController.anOrder.get(AimsMainGUIController.insertedOrderID - 1).itemsOrdered.size() - 1;

        if (AimsMainGUIController.anOrder.get(AimsMainGUIController.insertedOrderID - 1).itemsOrdered.get(index) instanceof CompactDisc) {
            CompactDisc cd = (CompactDisc) AimsMainGUIController.anOrder.get(AimsMainGUIController.insertedOrderID - 1).itemsOrdered.get(index);
            for (Track t : cd.getTracks()) {
                trackList.add(new Track(t.getTitle(), t.getLength()));
            }
        }
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        lengthColumn.setCellValueFactory(new PropertyValueFactory<>("length"));

        table.setItems(trackList);
    }

    //Bắt sự kiện thêm track mới sau khi ấn OK
    public void addNewTrack(ActionEvent event) {
        //Hai track được coi là bằng nhau khi phải đồng thời có cùng tên và có cùng độ dài
        //Nếu độ dài khác nhau thì đây vẫn là 2 track khác nhau
        //Nếu có track đó rồi thì báo lỗi

        //Check độ dài trackList hiện tại
        Track newTrack = new Track();

        for(Track t : trackList) {
            if(t.getTitle().equals(titleField.getText()) && t.getLength() == Integer.parseInt(lengthField.getText())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("This track is already in the list!");
                alert.show();
                return;
            }
        }
        //Thêm thông tin track mới
        newTrack.setTitle(titleField.getText());
        newTrack.setLength(Integer.parseInt(lengthField.getText()));

        trackList.add(newTrack);

        //Thêm track vào trackList của CD hiện tại trong Order hiện tại
        int index = AimsMainGUIController.anOrder.get(AimsMainGUIController.insertedOrderID - 1).itemsOrdered.size() - 1;
        if (AimsMainGUIController.anOrder.get(AimsMainGUIController.insertedOrderID - 1).itemsOrdered.get(index) instanceof CompactDisc) {
            ((CompactDisc) AimsMainGUIController.anOrder.get(AimsMainGUIController.insertedOrderID - 1).itemsOrdered.get(index)).addTrack(newTrack);
        }

        //Thêm track mới vào trackList

    }

    //Bắt sự kiện xóa 1 track trong list
    public void deleteTrack(ActionEvent event) {
        //Xóa track được chọn trong list
        Track selectedTrack = table.getSelectionModel().getSelectedItem();
        trackList.remove(selectedTrack);
        int index = AimsMainGUIController.anOrder.get(AimsMainGUIController.insertedOrderID - 1).itemsOrdered.size() - 1;
        if (AimsMainGUIController.anOrder.get(AimsMainGUIController.insertedOrderID - 1).itemsOrdered.get(index) instanceof CompactDisc) {
            ((CompactDisc) AimsMainGUIController.anOrder.get(AimsMainGUIController.insertedOrderID - 1).itemsOrdered.get(index)).removeTrack(selectedTrack);
        }
    }

    //Quay lại cửa sổ Add Media Product
    public void goBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("AddMediaProduct.fxml"));

        Parent sampleParent = loader.load();
        Scene scene = new Scene(sampleParent);

        stage.setScene(scene);
    }


}

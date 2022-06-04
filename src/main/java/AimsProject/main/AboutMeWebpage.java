package AimsProject.main;

import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AboutMeWebpage implements Initializable {
    @FXML
    private TextField addressBar;
    @FXML
    private WebView webView;
    @FXML
    private WebEngine webEngine;

    //Cần 1 web engine để load đến trang Web, nhận HTML về, đưa HTML cho WebView hiển thị
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        webEngine = webView.getEngine();
        webEngine.load("https://github.com/diepanhng0711");

        //Bắt sự thay đổi của WebEngine
        webEngine.getLoadWorker().stateProperty().addListener((observableValue, oldValue, newState) -> {
            //Xử lý: chuyển web (trạng thái stateProperty thay đổi) => thay đổi textField addressBar
            if (newState == Worker.State.SUCCEEDED) {
                addressBar.setText(webEngine.getLocation());
            }
        });
    }

    //Bắt sự kiện cho addressBar, khi nhập địa chỉ, nhấn Enter => load địa chỉ người dùng đã nhập vào
    public void keyHandle(KeyEvent key) {
        if (key.getCode().equals(KeyCode.ENTER)) {
            String address = addressBar.getText();
            webEngine.load(address);               //Dùng engine load trang web vào
        }
    }

    //Bắt sự kiện thay đổi của 2 phím quay lại/ tiến (BackHandle/ ForwardHandle)
    //TRANG ĐẦU TIÊN BẮT ĐẦU TỪ VỊ TRÍ 0
    public void backHandle(ActionEvent event) {
        if (webEngine.getHistory().getCurrentIndex() > 0) {            //>0 => có lịch sử
            webEngine.getHistory().go(-1);             //-1: -1 bước <=> 1: +1 bước
        }
    }

    public void forwardHandle(ActionEvent event) {
        if (webEngine.getHistory().getCurrentIndex() + 1 < webEngine.getHistory().getEntries().size()) {      //Kiểm tra xem có phải là trang cuối cùng không
            webEngine.getHistory().go(1);
        }
    }
}

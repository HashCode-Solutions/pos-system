package lk.possystem.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Sandun Sampath
 * @since - 10/9/2021 | 2021-October-09[Saturday]
 */
public class DashBoardFormController {

    public AnchorPane context;
    public TextField txtCurrentDate;

    public void initialize() throws IOException {
        loadDefault();
        genarateTime();
    }

    private void genarateTime() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, e ->{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
            txtCurrentDate.setText(LocalTime.now().format(formatter));
        }),new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        txtCurrentDate.setText(LocalDate.now().toString());

    }

    private void loadDefault() throws IOException {
        setUi("CustomerForm");
    }

    private void setUi(String location) throws IOException {
        context.getChildren().clear();
        context.getChildren().add(FXMLLoader.load(this.getClass().getResource("/lk/possystem/view/" + location + ".fxml")));
    }

    public void customerOnAction(ActionEvent actionEvent) throws IOException {
        loadDefault();
    }

}

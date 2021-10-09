/**
 * @author Sandun Sampath
 * @since - 10/9/2021 | 2021-October-09[Saturday]
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("POS System");
        primaryStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("lk/possystem/view/DashBoardForm.fxml"))));
        primaryStage.show();
    }
}

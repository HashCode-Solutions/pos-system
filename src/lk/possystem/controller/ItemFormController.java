package lk.possystem.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import lk.possystem.db.DBConnection;
import lk.possystem.model.Item;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @author Sandun Sampath
 * @since - 10/9/2021 | 2021-October-09[Saturday]
 */
public class ItemFormController implements Initializable {

    public JFXTextField txtItmId;
    public JFXTextField txtDesc;
    public JFXTextField txtPrice;
    public JFXTextField txtQty;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void saveOnAction(ActionEvent actionEvent) {
        Item item = new Item(txtItmId.getText(), txtDesc.getText(), Double.parseDouble(txtPrice.getText()),
                Integer.parseInt(txtPrice.getText()));

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO item VALUES(?,?,?,?)");
            statement.setObject(1,item.getItemId());
            statement.setObject(2,item.getDescription());
            statement.setObject(3,item.getPrice());
            statement.setObject(4,item.getQtyOnHand());
            int result = statement.executeUpdate();

            if (result > 0){
                new Alert(Alert.AlertType.CONFIRMATION,"Item Save Successfully", ButtonType.OK).show();
            }else {
                new Alert(Alert.AlertType.WARNING,"Item Save Unsuccessfully", ButtonType.OK).show();
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


}

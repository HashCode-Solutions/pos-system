package lk.possystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import lk.possystem.db.DBConnection;
import lk.possystem.model.Customer;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @author Sandun Sampath
 * @since - 10/9/2021 | 2021-October-09[Saturday]
 */
public class CustomerFormController implements Initializable {

    public JFXTextField txtCustId;
    public JFXTextField txtCustName;
    public JFXTextField txtAddress;
    public JFXTextField txtSalary;
    public JFXButton btnSave;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void saveOnAction(ActionEvent actionEvent) {

        Customer customer = new Customer(txtCustId.getText(), txtCustName.getText(), txtAddress.getText(),
                Double.parseDouble(txtSalary.getText()));

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO customer VALUES(?,?,?,?)");
            statement.setObject(1,customer.getId());
            statement.setObject(2,customer.getName());
            statement.setObject(3,customer.getAddress());
            statement.setObject(4,customer.getSalary());
            int result = statement.executeUpdate();

            if (result > 0){
                new Alert(Alert.AlertType.CONFIRMATION,"Customer Save Successfully", ButtonType.OK).show();
            }else {
                new Alert(Alert.AlertType.WARNING,"Customer Save Unsuccessfully", ButtonType.OK).show();
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

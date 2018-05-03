package org.staffdb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import util.DateUtil;

public class StaffEditDialogController {

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField cityField;

    @FXML
    private TextField telephoneField;

    @FXML
    private TextField birthdayField;

    private Stage dialogStage;
    private boolean okClicked = false;
    private StaffEntity staffEntity;

    /**
     * Controller initialization
     */
    @FXML
    private void initialize() {
    }

    /**
     * sets Stage for this window
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the staff
     *
     * @param staffEntity
     */
    public void setPerson(StaffEntity staffEntity) {
        this.staffEntity = staffEntity;

        firstNameField.setText(staffEntity.getFirstName());
        lastNameField.setText(staffEntity.getLastName());
        addressField.setText(staffEntity.getAddres());
        telephoneField.setText(staffEntity.getTelephone());
        cityField.setText(staffEntity.getCity());
        birthdayField.setText(DateUtil.format(staffEntity.getBirthday()));
        birthdayField.setPromptText("dd.mm.yyyy");
    }

    /**
     * Returns true on user OK click, otherwise false
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    public void handleOk(ActionEvent actionEvent) {

        if (isInputValid()) {
            staffEntity.setFirstName(firstNameField.getText());
            staffEntity.setLastName(lastNameField.getText());
            staffEntity.setAddres(addressField.getText());
            staffEntity.setTelephone(telephoneField.getText());
            staffEntity.setCity(cityField.getText());
            staffEntity.setBirthday(DateUtil.parse(birthdayField.getText()));

            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    public void handleCancel(ActionEvent actionEvent) {
        dialogStage.close();
    }

    /**
     * User input check
     *
     * @return true, user entered correct data
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }
        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
            errorMessage += "No valid last name!\n";
        }
        if (addressField.getText() == null || addressField.getText().length() == 0) {
            errorMessage += "No valid address!\n";
        }

        if (telephoneField.getText() == null || telephoneField.getText().length() == 0) {
            errorMessage += "No valid telephone!\n";
        }

        if (cityField.getText() == null || cityField.getText().length() == 0) {
            errorMessage += "No valid city!\n";
        }

        if (birthdayField.getText() == null || birthdayField.getText().length() == 0) {
            errorMessage += "No valid birthday!\n";
        } else {
            if (!DateUtil.validDate(birthdayField.getText())) {
                errorMessage += "No valid birthday. Use the format dd.mm.yyyy!\n";
            }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Показываем сообщение об ошибке.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}

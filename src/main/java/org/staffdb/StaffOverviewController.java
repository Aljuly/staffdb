package org.staffdb;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import util.DateUtil;

public class StaffOverviewController {

    @FXML
    private TableView<StaffEntity> staffTable;
    @FXML
    private TableColumn<StaffEntity, String> firstNameColumn;
    @FXML
    private TableColumn<StaffEntity, String> lastNameColumn;

    @FXML
    private Label idLabel;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLable;
    @FXML
    private Label addressLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label telephoneLabel;
    @FXML
    private Label birthdayLabel;

    //Link on the main application
    private MainApp mainApp;

    public StaffOverviewController() {
        //this is default constructor
    }

    /**
     * Class-controller initialization
     */
    @FXML
    public void initialize() {
        this.firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        this.lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());

        // Clear additional info about staff
        showStaffDetails(null);

        // Listening selection changes. If changed, then show
        // additional staff info
        staffTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showStaffDetails(newValue));
    }

    /**
     * Called by the main application, which gives the link on himself
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Adding data from the ObservableList
        staffTable.setItems(mainApp.getStaffData());
    }

    /**
     * Заполняет все текстовые поля, отображая подробности об адресате.
     * Если указанный адресат = null, то все текстовые поля очищаются.
     *
     * @param staffEntity — адресат типа Person или null
     */
    private void showStaffDetails(StaffEntity staffEntity) {
        if (staffEntity != null) {
            // Заполняем метки информацией из объекта person.
            firstNameLabel.setText(staffEntity.getFirstName());
            lastNameLable.setText(staffEntity.getLastName());
            addressLabel.setText(staffEntity.getAddres());
            telephoneLabel.setText(staffEntity.getTelephone());
            cityLabel.setText(staffEntity.getCity());
            birthdayLabel.setText(DateUtil.format(staffEntity.getBirthday()));

        } else {
            // If staffEntity = null then remove all text
            firstNameLabel.setText("");
            lastNameLable.setText("");
            addressLabel.setText("");
            telephoneLabel.setText("");
            cityLabel.setText("");
            birthdayLabel.setText("");
        }
    }

    /**
     * Calls on Delete button click
     */
    @FXML
    private void handleDeleteStaff() {
        int selectedIndex = staffTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            staffTable.getItems().remove(selectedIndex);
        } else {
            // Ничего не выбрано.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");
            alert.showAndWait();
        }
    }

    /**
     * Вызывается, когда пользователь кликает по кнопке New...
     * Открывает диалоговое окно с дополнительной информацией нового адресата.
     */
    @FXML
    private void handleNewStaff() {
        StaffEntity tempPerson = new StaffEntity();
        boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
        if (okClicked) {
            mainApp.getStaffData().add(tempPerson);
        }
    }

    /**
     * Вызывается, когда пользователь кликает по кнопка Edit...
     * Открывает диалоговое окно для изменения выбранного адресата.
     */
    @FXML
    private void handleEditStaff() {
        StaffEntity selectedPerson = staffTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
            if (okClicked) {
                showStaffDetails(selectedPerson);
            }

        } else {
            // Ничего не выбрано.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Staff Selected");
            alert.setContentText("Please select a staff in the table.");

            alert.showAndWait();
        }
    }

}

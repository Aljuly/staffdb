package org.staffdb;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
     * Class-controller initialisation
     */
    @FXML
    public void initialize() {
        this.firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        this.lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
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


}

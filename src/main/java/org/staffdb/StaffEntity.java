package org.staffdb;

import javafx.beans.property.*;

import java.time.LocalDate;

public class StaffEntity {

    private final IntegerProperty id;
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty addres;
    private final StringProperty city;
    private final StringProperty telephone;
    private final ObjectProperty<LocalDate> birthday;

    /**
     * Default constructor
     */
    public StaffEntity() {
        this(null, null);
    }

    /**
     * Workhorse constructor
     * @param firstName
     * @param lastName
     */
    public StaffEntity(String firstName, String lastName) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);

        this.id = new SimpleIntegerProperty(0);
        this.addres = new SimpleStringProperty("");
        this.city = new SimpleStringProperty("");
        this.telephone = new SimpleStringProperty("");
        this.birthday = new SimpleObjectProperty<>(LocalDate.of(1980, 1, 1));
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getAddres() {
        return addres.get();
    }

    public StringProperty addresProperty() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres.set(addres);
    }

    public String getCity() {
        return city.get();
    }

    public StringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getTelephone() {
        return telephone.get();
    }

    public StringProperty telephoneProperty() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone.set(telephone);
    }

    public LocalDate getBirthday() {
        return birthday.get();
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }
}

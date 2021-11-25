package com.muhardin.endy.belajar.spring.javafx.controller;

import com.muhardin.endy.belajar.spring.javafx.dao.ContactDao;
import com.muhardin.endy.belajar.spring.javafx.entity.Contact;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component @Slf4j
@FxmlView("RootLayout.fxml")
public class HomeController {

    @Autowired private ContactDao contactDao;
    @Autowired private FormContactController formContactController;

    @FXML
    private TableView<Contact> tblContact;

    @FXML private TableColumn<Contact, String> colNama;
    @FXML private TableColumn<Contact, String> colEmail;
    @FXML private TableColumn<Contact, String> colNoHp;

    @FXML
    public void initialize() {
        colNama.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNama()));
        colEmail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
        colNoHp.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNoHp()));

        tblContact.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tblContact.getSelectionModel().selectedItemProperty().addListener((observableValue, oldSelection, newSelection) -> {
            if(newSelection != null) {
                formContactController.setContact(newSelection);
            }
        });

        populateContactTable();
    }

    public void populateContactTable() {
        ObservableList<Contact> contactList = FXCollections.observableArrayList();
        contactDao.findAll().forEach(contactList::add);
        tblContact.setItems(contactList);
    }
}

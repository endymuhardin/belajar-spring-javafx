package com.muhardin.endy.belajar.spring.javafx.controller;

import com.muhardin.endy.belajar.spring.javafx.dao.ContactDao;
import com.muhardin.endy.belajar.spring.javafx.entity.Contact;
import com.muhardin.endy.belajar.spring.javafx.entity.JenisKelamin;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component @Slf4j @FxmlView
public class FormContactController {

    @Autowired private ContactDao contactDao;

    @FXML private TextField txtNama;
    @FXML private TextField txtEmail;
    @FXML private TextField txtNoHp;
    @FXML private DatePicker dtTanggalLahir;
    @FXML private RadioButton rbPria;
    @FXML private RadioButton rbWanita;
    @FXML private TextArea txtAlamat;
    @FXML private ComboBox<String> cbProvinsi;

    @FXML
    public void initialize() {
        List<String> daftarProvinsi = new ArrayList<>();
        daftarProvinsi.add("DKI Jakarta");
        daftarProvinsi.add("Jawa Barat");
        cbProvinsi.setItems(FXCollections.observableList(daftarProvinsi));
    }

    public void btnSaveClicked(){
        Contact ct = Contact.builder()
                .nama(txtNama.getText())
                .email(txtEmail.getText())
                .noHp(txtNoHp.getText())
                .tanggalLahir(dtTanggalLahir.getValue())
                .jenisKelamin(rbPria.isSelected() ? JenisKelamin.PRIA : (rbWanita.isSelected() ? JenisKelamin.WANITA : null))
                .alamat(txtAlamat.getText())
                .provinsi(cbProvinsi.getSelectionModel().getSelectedItem())
                .build();

        contactDao.save(ct);
        clearForm();
    }

    public void btnResetClicked() {
        clearForm();
    }

    private void clearForm() {
        txtNama.setText(null);
        txtEmail.setText(null);
        txtNoHp.setText(null);
        dtTanggalLahir.setValue(null);
        rbPria.setSelected(false);
        rbWanita.setSelected(false);
        txtAlamat.setText(null);
        cbProvinsi.getSelectionModel().clearSelection();
    }
}

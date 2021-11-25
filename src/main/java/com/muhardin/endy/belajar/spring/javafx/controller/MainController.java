package com.muhardin.endy.belajar.spring.javafx.controller;

import com.muhardin.endy.belajar.spring.javafx.entity.Contact;
import com.muhardin.endy.belajar.spring.javafx.entity.JenisKelamin;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@Component @Slf4j @FxmlView
public class MainController implements Initializable {
    @FXML private Button btnSave;
    @FXML private TextField txtNama;
    @FXML private TextField txtEmail;
    @FXML private TextField txtNoHp;
    @FXML private DatePicker dtTanggalLahir;
    @FXML private RadioButton rbPria;
    @FXML private RadioButton rbWanita;
    @FXML private TextArea txtAlamat;
    @FXML private ComboBox<String> cbProvinsi;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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

        System.out.println("Contact : "+ct.toString());
    }

    public void btnResetClicked() {
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

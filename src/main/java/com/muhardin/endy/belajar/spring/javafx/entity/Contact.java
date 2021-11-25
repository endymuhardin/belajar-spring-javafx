package com.muhardin.endy.belajar.spring.javafx.entity;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data @Builder
public class Contact {
    private String id;
    private String nama;
    private String email;
    private String noHp;
    private String alamat;
    private LocalDate tanggalLahir;
    private JenisKelamin jenisKelamin;
    private String provinsi;
            
}

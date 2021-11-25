package com.muhardin.endy.belajar.spring.javafx.entity;

import java.time.LocalDate;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@Entity @Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Contact {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @NotNull @NotEmpty
    private String nama;

    @NotNull @NotEmpty
    private String email;

    @NotNull @NotEmpty
    private String noHp;

    @NotNull @NotEmpty
    private String alamat;

    @NotNull @Past
    private LocalDate tanggalLahir;

    @NotNull @Enumerated(EnumType.STRING)
    private JenisKelamin jenisKelamin;

    @NotNull @NotEmpty
    private String provinsi;
            
}

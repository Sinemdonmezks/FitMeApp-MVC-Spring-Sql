package com.sinem.FitMeApp.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "tblmusteri")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Musteri {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String namesurname;
    @Enumerated(EnumType.STRING)
    private  EGender gender;
    private  String address;
    private String phone;
    private  int dogumtarihi;
    private  String email;
    private  String username;
    private  String password;
    private  String il;
    private  String meslek;
}

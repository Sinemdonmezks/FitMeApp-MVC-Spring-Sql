package com.sinem.FitMeApp.dto.request;

import com.sinem.FitMeApp.repository.entity.EGender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MusteriSaveRequestDto {
    private String namesurname;
    private  String email;
    private  String password;
    @Enumerated(EnumType.STRING)
    private EGender gender;
}

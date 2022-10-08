package com.sinem.FitMeApp.mapper;

import com.sinem.FitMeApp.dto.request.MusteriLoginRequestDto;
import com.sinem.FitMeApp.dto.request.MusteriSaveRequestDto;
import com.sinem.FitMeApp.dto.response.MusteriSaveResponseDto;
import com.sinem.FitMeApp.repository.entity.Musteri;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MusteriMapper {
    MusteriMapper INSTANCE= Mappers.getMapper(MusteriMapper.class);

    MusteriLoginRequestDto toMusteriLoginRequestDto(final Musteri musteri);
    Musteri toMusteri(final MusteriLoginRequestDto dto);

    MusteriSaveResponseDto toMusteriSaveResponseDto(final Musteri musteri);
    Musteri toMusteri(final MusteriSaveResponseDto dto);

MusteriSaveRequestDto toMusteriSaveRequestDto(final Musteri musteri);
Musteri toMusteri(final MusteriSaveRequestDto dto);


}

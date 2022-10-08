package com.sinem.FitMeApp.service;

import com.sinem.FitMeApp.dto.request.MusteriSaveRequestDto;
import com.sinem.FitMeApp.dto.response.MusteriSaveResponseDto;
import com.sinem.FitMeApp.mapper.MusteriMapper;
import com.sinem.FitMeApp.repository.IMusteriRepository;
import com.sinem.FitMeApp.repository.entity.Musteri;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MusteriService {
    private final IMusteriRepository musteriRepository;

    public Musteri save(Musteri musteri){
        return musteriRepository.save(musteri);
    }

    public Musteri update(Musteri musteri){
        return musteriRepository.save(musteri);
    }

    public MusteriSaveResponseDto saveDto(Musteri musteri) {
        musteriRepository.save(musteri);
        return MusteriMapper.INSTANCE.toMusteriSaveResponseDto(musteri);
    }

    public MusteriSaveResponseDto saveWithRequestDto(MusteriSaveRequestDto dto) {


        Musteri musteri = MusteriMapper.INSTANCE.toMusteri(dto);
        musteriRepository.save(musteri);
        return MusteriMapper.INSTANCE.toMusteriSaveResponseDto(musteri);

    }

    public Optional<Musteri> login (String email, String password){
        Optional<Musteri> musteri=musteriRepository.findOptionalByEmailAndPassword(email,password);

        if (musteri.isEmpty()){

            System.out.println("Kullanıcı Bulunamadı");
            return Optional.ofNullable(null);
        }
        return musteri;
    }

    public Optional<Musteri> findById(Long musteriId) {
        return musteriRepository.findById(musteriId);
    }
}

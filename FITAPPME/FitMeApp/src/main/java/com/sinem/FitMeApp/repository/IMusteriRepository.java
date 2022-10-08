package com.sinem.FitMeApp.repository;

import com.sinem.FitMeApp.repository.entity.Musteri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IMusteriRepository extends JpaRepository<Musteri,Long> {

    Optional<Musteri> findOptionalByEmailAndPassword(String email, String password);

    @Query(value = "select * from tblmusteri as u where u.email=?1 and u.password=?2", nativeQuery = true)
    Optional<Musteri> findOptionalByEmailAndPassword2(String email, String password);
}




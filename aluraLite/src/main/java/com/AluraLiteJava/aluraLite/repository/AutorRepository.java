package com.AluraLiteJava.aluraLite.repository;

import com.AluraLiteJava.aluraLite.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    @Query(value = "SELECT * FROM autor WHERE data_nascimento <= :ano AND (data_falecimento >= :ano OR data_falecimento IS NULL)", nativeQuery = true)
    List<Autor> searchAliveAutorByYear(@Param("ano") Integer ano);

}

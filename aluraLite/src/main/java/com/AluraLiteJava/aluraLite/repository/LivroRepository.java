package com.AluraLiteJava.aluraLite.repository;


import com.AluraLiteJava.aluraLite.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByIdiomaIgnoreCase(String idioma);


}
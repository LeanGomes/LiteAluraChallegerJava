package com.AluraLiteJava.aluraLite.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro (
            @JsonAlias("title") String titulo,
            @JsonAlias("download_count") Long download,
            @JsonAlias("languages")List<String> idioma,
            @JsonAlias("authors") List<DadosAutor> autor)

    {

    }
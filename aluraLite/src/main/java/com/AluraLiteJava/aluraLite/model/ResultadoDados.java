package com.AluraLiteJava.aluraLite.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ResultadoDados(@JsonAlias("results") List<DadosLivro> livros) {
}
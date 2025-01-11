package br.com.alura.screenmatchh.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosFilm(@JsonAlias("Runtime") String duracaoFilm) {
}

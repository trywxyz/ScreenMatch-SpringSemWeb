package br.com.alura.screenmatchh.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpisodeos(@JsonAlias("Title") String titulo,
                             @JsonAlias("Genre")String Genero,
                             @JsonAlias("imdRating")String avaliacao,
                             @JsonAlias("Released")String dataLancamento) {
}

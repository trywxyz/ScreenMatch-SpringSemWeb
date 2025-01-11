package br.com.alura.screenmatchh.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosFilme(@JsonAlias("Title") String title,
                         @JsonAlias("Runtime") String totalTempFilme,
                         @JsonAlias("imdbRating") String avaliacao,
                         @JsonProperty("imdbVotes") String votos) {


 }

package br.com.alura.screenmatchh.model;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Date;

public class Episodios {
    private Integer temporada;
    private String titulo;
    private Integer numeroEpisodio;
    private Double avaliacao;
    private LocalDate dataLancamento;


    public Episodios(Integer numeroTemporada, DadosEpisodeos dadosEpisodeos){
        this.temporada = numeroTemporada;
        this.titulo = dadosEpisodeos.titulo();
        try{
            this.avaliacao = Double.valueOf(dadosEpisodeos.avaliacao());
        }catch (NumberFormatException ex){
            this.avaliacao = 0.0;
        }

        try{
            this.dataLancamento = LocalDate.parse(dadosEpisodeos.dataLancamento());
        }catch (DateTimeException ex){
            this.dataLancamento = null;
        }



    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getTemporada() {
        return temporada;
    }

    public void setTemporada(Integer temporada) {
        this.temporada = temporada;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Integer getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(Integer numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    @Override
    public String toString() {
        return "Episodios{" +
                "temporada=" + temporada +
                ", titulo='" + titulo + '\'' +
                ", numeroEpisodio=" + numeroEpisodio +
                ", avaliacao=" + avaliacao +
                ", dataLancamento=" + dataLancamento +
                '}';
    }
}

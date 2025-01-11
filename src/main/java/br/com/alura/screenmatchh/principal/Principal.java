package br.com.alura.screenmatchh.principal;

import br.com.alura.screenmatchh.model.DadosFilme;
import br.com.alura.screenmatchh.service.ConsumoAPI;
import br.com.alura.screenmatchh.service.ConvertDados;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner leia = new Scanner(System.in);
    //https://www.omdbapi.com/?i=tt3896198&apikey=3d608cd1
    private final String ENDERECO = "https://www.omdbapi.com/?i=";
    private final String API_KEY = "&apikey=3d608cd1";
    private ConsumoAPI consumoApiKey = new ConsumoAPI();
    private ConvertDados convertDados = new ConvertDados();

    public void exibirMenu() {
        System.out.println("------------------------------------");
        System.out.println("Bem vindo ao menu");
        System.out.println("Para testes recomendo utilizar o (tt3896198)");
        System.out.println("Digite o nome do filme para buscar: ");
        // le o valor que foi digitado
        var nomeFilme = leia.nextLine();
        //transforma o valor digitado em uma URL com ENDERECO que é uma
        // variavel, replace para transformar os espaços em +, e API_KEY que é uma variavel também
        var json = consumoApiKey.obterDados(ENDERECO + nomeFilme.replace(" ", "+") + API_KEY);

        //Ele transforma uma classe ConverteDados em um subclasse dentro da minha variavel dados,
        // Dentro de converteDados é passa argumento json e o argumento classe para identificar oque vai entrar como argumento na minha classe
        DadosFilme dados = convertDados.obterDados(json, DadosFilme.class);

        System.out.println(dados);

    }
}

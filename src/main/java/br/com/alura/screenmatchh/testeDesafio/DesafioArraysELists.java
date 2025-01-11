package br.com.alura.screenmatchh.testeDesafio;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DesafioArraysELists {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> palavras = Arrays.asList("java", "stream", "lambda");
        List<String> palavrasDuplicadas = Arrays.asList("apple", "banana", "apple", "orange", "banana");

        //filtra por numeros pares
        numeros.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

        //converter para letra maiuscula
        palavras.stream().map(String::toUpperCase).forEach(System.out::println);

        //filtrar numeros impares multiplicar por 2 e colete os resultados em uma nova lista
        List<Integer> resultado = numeros.stream().filter(n -> n % 2 == 1).map(n -> n * 2).collect(Collectors.toList());
        System.out.println(resultado);

        //remova as duplicadas e imprima o resultado
        List<String> palavrasUnicas = palavras.stream().distinct().collect(Collectors.toList());
        System.out.println(palavrasUnicas);

    }
}

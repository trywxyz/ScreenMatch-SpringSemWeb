package br.com.alura.screenmatchh.testeDesafio;

import java.util.*;
import java.util.stream.Collectors;

public class DesafioArrayEList2 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(10, 20, 30, 40, 50);
        List<String> palavras = Arrays.asList("java", "stream", "lambda", "code");
        List<String> nomes = Arrays.asList("Alice", "Bob", "Charlie");

        //1 - Dada a lista de números inteiros a seguir, encontre o maior número dela.
        Optional<Integer> max = numeros.stream().max(Integer::compare);
        max.ifPresent(System.out::println);

        //2 -Dada a lista de palavras (strings) abaixo, agrupe-as pelo seu tamanho. No código a seguir, há um exemplo prático do resultado esperado.
        Map<Integer, List<String>> agrupamento = palavras.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(agrupamento);

        //3 - Concatenando elementos da lista
        String resultado = nomes.stream().collect(Collectors.joining(", "));
        System.out.println(resultado);

        //4 - Reduzindo uma lista de inteiros
        int somaDosQuadrados = numeros.stream().filter(n -> n % 2 == 0).map(n -> n * n).reduce(0, Integer::sum);
        System.out.println(somaDosQuadrados);

    }
}

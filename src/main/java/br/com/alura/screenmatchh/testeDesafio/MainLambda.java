package br.com.alura.screenmatchh.testeDesafio;

interface Multiplicacao {
    int multiplicacao(int a, int b);

}

public class MainLambda {
    public static void main(String[] args) {
        Multiplicacao multiplicacao = (a, b) -> a * b;
        System.out.println(multiplicacao.multiplicacao(10,3));

    }
}

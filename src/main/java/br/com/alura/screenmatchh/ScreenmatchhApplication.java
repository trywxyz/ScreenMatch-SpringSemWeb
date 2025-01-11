package br.com.alura.screenmatchh;

import br.com.alura.screenmatchh.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchhApplication implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(ScreenmatchhApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Principal principal = new Principal();
        //principal.exibirMenu() manda para a classe Principal.java e carrega oque está exibido la
        principal.exibirMenu();

    }
}

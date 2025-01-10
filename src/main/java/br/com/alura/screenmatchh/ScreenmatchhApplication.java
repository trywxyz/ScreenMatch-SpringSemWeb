package br.com.alura.screenmatchh;

import br.com.alura.screenmatchh.model.DadosSerie;
import br.com.alura.screenmatchh.service.ConsumoAPI;
import br.com.alura.screenmatchh.service.ConvertDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Converter;

import java.lang.constant.Constable;

@SpringBootApplication
public class ScreenmatchhApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(ScreenmatchhApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoAPI();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?i=tt3896198&apikey=3d608cd1");
		System.out.println(json);


		ConvertDados convertDados = new ConvertDados();
		DadosSerie dados = convertDados.obterDados(json, DadosSerie.class);
		System.out.println(dados);

	}
}

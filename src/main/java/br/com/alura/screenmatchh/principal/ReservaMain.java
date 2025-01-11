package br.com.alura.screenmatchh.principal;

import br.com.alura.screenmatchh.model.DadosEpisodeos;
import br.com.alura.screenmatchh.model.DadosFilm;
import br.com.alura.screenmatchh.model.DadosFilme;
import br.com.alura.screenmatchh.model.Episodios;
import br.com.alura.screenmatchh.service.ConsumoAPI;
import br.com.alura.screenmatchh.service.ConvertDados;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReservaMain {
    public static void main(String[] args) {

        var consumoApi = new ConsumoAPI();
        ConsumoAPI consumoApii = new ConsumoAPI(); //As duas formas de criar variavel JAVA estão certas!


        //Imprimi a API inteira
        var json = consumoApi.obterDados("https://www.omdbapi.com/?i=tt3896198&apikey=3d608cd1");
        System.out.println(json);


        //Retorna dados especificos buscados na API(DadosSerie[title=Guardians of the Galaxy Vol. 2, totalTempFilme=136 min, avaliacao=7.6, votos=780,354])
        ConvertDados convertDados = new ConvertDados();
        DadosFilme dados = convertDados.obterDados(json, DadosFilme.class);
        System.out.println(dados);
//---------------------------------------
        //Busca pelos dados do filme(DadosEpisodeos[titulo=Guardians of the Galaxy Vol. 2, Genero=Action, Adventure, Comedy, avaliacao=null, dataLancamento=05 May 2017])
        json = consumoApi.obterDados("https://www.omdbapi.com/?i=tt3896198&apikey=3d608cd1");
        DadosEpisodeos dadosEpisodeo = convertDados.obterDados(json, DadosEpisodeos.class);

        System.out.println(dadosEpisodeo);

//-----------------------------
        //Busca apenas o tempo do Filme pela API(DadosFilm[duracaoFilm=136 min])
        json = consumoApii.obterDados("https://www.omdbapi.com/?i=tt3896198&apikey=3d608cd1");
        DadosFilm dadosFilm = convertDados.obterDados(json, DadosFilm.class);
        System.out.println(dadosFilm);
//-----------------------------------

//-----------------------------------
// Foreach para percorrer todos os indices de temporada
//		List<DadosTemporada> temporadas = new ArrayList<>();
//		for(int i = 1; i <= dadosSerie.totalTemporadas(); i++) {
//			json = consumoApi.obterDados("https://www.omdbapi.com/?t="+ serie + "&season=" + i + "&apikey=6585022c");
//			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
//			temporadas.add(dadosTemporada);
//		}
//
//		temporadas.forEach(System.out::println);
//
// -----------------------------------

//Funções lambda
//        temporadas.forEach(t -> t.episodeos().forEach(e -> System.out.println(e.titulo())))
//        temporadas.forEach(System.out::prinln);
//        temporada((parametro) -> expressao)

// -----------------------------------
        List<String> nomes = Arrays.asList("Jacque", "Iasmin", "Paulo", "Rodrigo", "Nico");
        // .asList tem como função atribuir os nomes ao Array
        // .sorted() Ordena os nomes que estão no Array acima em ordem alfabetica
        // .limit limita os nomes a serem exibidos
        //Como no começo já é declarado que está utilizando a variavel List nomes.stream() então utilizar (n ->) poderia ser qualquer letra
        // .filter Filtra pela busca com "N"
        // .map faz o mapeamento no array e pega apenas o String que começa com "N" no caso o NICO
        // .forEach ele faz uma verificação no Array por completo
        nomes.stream()
                .sorted()
                .limit(3)
                .filter(n -> n.startsWith("N"))
                .map(n -> n.toUpperCase())
                .forEach(System.out::println);


// -----------------------------------
        //.flatMap() serve para fazer uma junção de uma lista dentro de outra lista
        //.collect(Collectors.toList() cria uma lista e deixa você adicionar novas coisas
        //.toList é uma lista imutavel

//        List<DadosFilme> dadosFilmes = filmes.stream().flatMap(f -> f.totalTempFilme().stream()).collect(Collectors.toList());
//                .toList();


        //Sorted ele está pegando a lista e comparando todos da lista de (DadosFilme::avaliacao)
        //.reversed() faz ao contrario do maior ao menor
        //.limit está limitando o maximo da avaliacao em 5

//        dadosFilmes.stream()
//                .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
//                .sorted(Comparator.comparing(DadosFilme::avaliacao).reversed())
//                .limit(5)
//                .forEach(System.out::println);

// -----------------------------------

//        List<Episodios> ep = temporadas.stream().flatMap(f -> f.episodeos().stream().map(d -> new Episodios(t.numero(), d))).collect(Collectors.toList());

//        ep.forEach(System.out::println);

// -----------------------------------


//        List<Episodio> episodios = temporadas.stream()
//                .flatMap(t -> t.episodios().stream()
//                        .map(d -> new Episodio(t.numero(), d)))
//                .collect(Collectors.toList());
//
//        episodios.forEach(System.out::println);
//
//        System.out.println("A partir de que ano você deseja ver os episódios? ");
//        var ano = leitura.nextInt();
//        leitura.nextLine();
//
//        LocalDate dataBusca = LocalDate.of(ano, 1, 1);
//
//        episodios.stream()
//                .filter(e -> e.getDataLancamento() != null && e.getDataLancamento().isAfter(dataBusca))
//        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//        episodios.stream()
//                .filter(e -> e.getDataLancamento() != null && e.getDataLancamento().isAfter(dataBusca))
//                .forEach(e -> System.out.println(
//                        "Temporada: " + e.getTemporada() +
//                                " Episódio: " + e.getTitulo() +
//                                " Data lançamento: " + e.getDataLancamento().format(formatador)
//                ));

//-------------------------------------------
        //Fazendo busca pelo nome digitado

//        System.out.println("Digite um trecho do título do episódio");
//        var trechoTitulo = leitura.nextLine();
//        Optional<Episodio> episodioBuscado = episodios.stream()
//                .filter(e -> e.getTitulo().toUpperCase().contains(trechoTitulo.toUpperCase()))
//                .findFirst();
//        if(episodioBuscado.isPresent()){
//            System.out.println("Episódio encontrado!");
//            System.out.println("Temporada: " + episodioBuscado.get().getTemporada());
//        } else {
//            System.out.println("Episódio não encontrado!");
//        }


//-------------------------------------------
        //Vendo as avaliações das temporadas

//        Map<Integer, Double> avaliacoesPorTemporada = episodios.stream()
//                .filter(e -> e.getAvaliacao() > 0.0)
//                .collect(Collectors.groupingBy(Episodio::getTemporada,
//                        Collectors.averagingDouble(Episodio::getAvaliacao)));
//        System.out.println(avaliacoesPorTemporada);


//-------------------------------------------
        //Como imprimir estatisticas de forma organizada

//        DoubleSummaryStatistics est = episodios.stream()
//                .filter(e -> e.getAvaliacao() > 0.0)
//                .collect(Collectors.summarizingDouble(Episodio::getAvaliacao));
//        System.out.println("Média: " + est.getAverage());
//        System.out.println("Melhor episódio: " + est.getMax());
//        System.out.println("Pior episódio: " + est.getMin());
//        System.out.println("Quantidade: " + est.getCount());
    }
}

package com.guilherme.GabaritoConsumer.Service;

import com.guilherme.GabaritoConsumer.Model.Questoes;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class QuestoesService {
    private WebClient webClient;

    public QuestoesService() {
        this.webClient =
                WebClient.builder().baseUrl("http://localhost:8080/questoes").build();
    }

    private static String uri = "";

    public Questoes localizar(int id) {
        Mono<Questoes> monoQuestoes = webClient.method(HttpMethod.GET)
                .uri(uri + "/" + id)
                .retrieve()
                .bodyToMono(Questoes.class);
        return monoQuestoes.block();
    }


    public List<Questoes> pesquisar() {
        Mono<List<Questoes>> monoListQuestoes = webClient.method(HttpMethod.GET)
                .uri(uri)
                .retrieve()
                .bodyToFlux(Questoes.class)
                .collectList();
        return monoListQuestoes.block();
    }

    public List<Questoes> pesquisarProva(int idProva){
        Mono<List<Questoes>> monoListQuestoes = webClient.method(HttpMethod.GET)
                .uri(uri + "/prova/" + idProva)
                .retrieve()
                .bodyToFlux(Questoes.class)
                .collectList();
        return monoListQuestoes.block();
    }

    public Questoes salvar(Questoes questoes) {
        Mono<Questoes> monoQuestoes = webClient.method(HttpMethod.POST)
                .uri(uri)
                .body(BodyInserters.fromValue(questoes))
                .retrieve()
                .bodyToMono(Questoes.class);
        return monoQuestoes.block();
    }

    public void excluir(int id) {
        webClient.get()
                .uri(uri + "/excluir/" + id)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
}

package com.guilherme.GabaritoConsumer.Service;

import com.guilherme.GabaritoConsumer.Model.Prova;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ProvaService {
    private WebClient webClient;

    public ProvaService() {
        this.webClient =
                WebClient.builder().baseUrl("http://localhost:8080/prova").build();
    }

    private static String uri = "";

    public Prova localizar(int id) {
        Mono<Prova> monoProva = webClient.method(HttpMethod.GET)
                .uri(uri + "/" + id)
                .retrieve()
                .bodyToMono(Prova.class);
        return monoProva.block();
    }


    public List<Prova> pesquisar() {
        Mono<List<Prova>> monoListProva = webClient.method(HttpMethod.GET)
                .uri(uri)
                .retrieve()
                .bodyToFlux(Prova.class)
                .collectList();
        return monoListProva.block();
    }

    public Prova salvar(Prova prova) {
        Mono<Prova> monoProva = webClient.method(HttpMethod.POST)
                .uri(uri)
                .body(BodyInserters.fromValue(prova))
                .retrieve()
                .bodyToMono(Prova.class);
        return monoProva.block();
    }

    public void excluir(int id) {
        webClient.get()
                .uri(uri + "/excluir/" + id)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
}

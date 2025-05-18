package com.info.FuncionarioConsumer.service;

import com.info.FuncionarioConsumer.model.Tabelas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class TabelasService {
    private WebClient webClient;

    public TabelasService() {
        this.webClient =
                WebClient.builder().baseUrl("http://localhost:8080/tabelas").build();
    }

    private static String uri = "";

    public Tabelas localizar(int id){
        Mono<Tabelas> monoTabelas = webClient.method(HttpMethod.GET)
                .uri(uri + "/" + id)
                .retrieve()
                .bodyToMono(Tabelas.class);
        return monoTabelas.block();
    }

    public Tabelas salvar(Tabelas Tabelas){
        Mono<Tabelas> monoTabelas = webClient.method(HttpMethod.POST)
                .uri(uri)
                .body(BodyInserters.fromValue(Tabelas))
                .retrieve()
                .bodyToMono(Tabelas.class);
        return monoTabelas.block();
    }
}

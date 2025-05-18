package com.info.FuncionarioConsumer.service;

import com.info.FuncionarioConsumer.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class FuncionarioService {

    private WebClient webClient;

    public FuncionarioService() {
        this.webClient =
                WebClient.builder().baseUrl("http://localhost:8080/funcionario").build();
    }

    private static String uri = "";

    public Funcionario localizar(int id) {
        Mono<Funcionario> monoFuncionario = webClient.method(HttpMethod.GET)
                .uri(uri + "/" + id)
                .retrieve()
                .bodyToMono(Funcionario.class);
        return monoFuncionario.block();
    }


    public List<Funcionario> pesquisar() {
        Mono<List<Funcionario>> monoListFuncionario = webClient.method(HttpMethod.GET)
                .uri(uri)
                .retrieve()
                .bodyToFlux(Funcionario.class)
                .collectList();
        return monoListFuncionario.block();
    }

    public Funcionario salvar(Funcionario Funcionario) {
        Mono<Funcionario> monoFuncionario = webClient.method(HttpMethod.POST)
                .uri(uri)
                .body(BodyInserters.fromValue(Funcionario))
                .retrieve()
                .bodyToMono(Funcionario.class);
        return monoFuncionario.block();
    }

    public void excluir(int id) {
        webClient.get()
                .uri(uri + "/excluir/" + id)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
}
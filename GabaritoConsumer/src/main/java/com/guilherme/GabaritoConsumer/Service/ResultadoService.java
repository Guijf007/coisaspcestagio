package com.guilherme.GabaritoConsumer.Service;

import com.guilherme.GabaritoConsumer.Model.Resultado;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ResultadoService {
    private WebClient webClient;

    public ResultadoService() {
        this.webClient =
                WebClient.builder().baseUrl("http://localhost:8080/resultado").build();
    }

    private static String uri = "";

    public Resultado localizar(int id) {
        Mono<Resultado> monoResultado = webClient.method(HttpMethod.GET)
                .uri(uri + "/" + id)
                .retrieve()
                .bodyToMono(Resultado.class);
        return monoResultado.block();
    }


    public List<Resultado> pesquisar() {
        Mono<List<Resultado>> monoListResultado = webClient.method(HttpMethod.GET)
                .uri(uri)
                .retrieve()
                .bodyToFlux(Resultado.class)
                .collectList();
        return monoListResultado.block();
    }

    public Resultado salvar(Resultado Resultado) {
        Mono<Resultado> monoResultado = webClient.method(HttpMethod.POST)
                .uri(uri)
                .body(BodyInserters.fromValue(Resultado))
                .retrieve()
                .bodyToMono(Resultado.class);
        return monoResultado.block();
    }

    public void excluir(int id) {
        webClient.get()
                .uri(uri + "/excluir/" + id)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
}

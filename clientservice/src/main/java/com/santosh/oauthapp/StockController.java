package com.santosh.oauthapp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class StockController {

  @Autowired
  WebClient webClient;

  @GetMapping("/")
  public Mono<Stock> getLatestToll() {
    //call downstream service
    Flux<Stock> response = this.webClient.get()
        .uri("http://localhost:8081/api/stocks")
        .retrieve()
        .bodyToFlux(Stock.class);
    List<Stock> tolldata = response.collectList().block();
    return Mono.just(tolldata.get(0));
  }
}

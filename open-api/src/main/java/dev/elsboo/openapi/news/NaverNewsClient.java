package dev.elsboo.openapi.news;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.util.List;

public class NaverNewsClient {
    @Value("${naver-openapi.id}")
    private String id;

    @Value("${naver-openapi.secret}")
    private String secret;

    public List<NaverNews> getNews() {
        return getNewsResponse().block().getItems();
    }

    private Mono<NaverNewsResponse> getNewsResponse() {
        WebClient webClient = WebClient.builder()
            .baseUrl("https://openapi.naver.com")
            .build();
        Mono<NaverNewsResponse> naverNewsMono = webClient.get()
            .uri(uriBuilder -> uriBuilder.path("/v1/search/news.json")
                .queryParam("query", "배달의민족")
                .queryParam("display", 100)
                .queryParam("start", 1)
                .queryParam("sort", "date")
                .build()
            )
            .header("X-Naver-Client-Id", id)
            .header("X-Naver-Client-Secret", secret)
            .retrieve()
            .bodyToMono(NaverNewsResponse.class);
        return naverNewsMono;
    }
}

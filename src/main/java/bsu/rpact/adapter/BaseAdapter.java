package bsu.rpact.adapter;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;

@Component
public class BaseAdapter {
    protected String restPreambule = "http://localhost:7166/embed_image";
    protected String apiTestPreambule = "https://catfact.ninja/fact";
    protected WebClient webClient;

    @PostConstruct
    public void initWebClient() {
        final int size = 16 * 1024 * 1024;
        final ExchangeStrategies strategies = ExchangeStrategies.builder()
                .codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(size))
                .build();
        webClient = WebClient.builder()
                .baseUrl(restPreambule)
                .exchangeStrategies(strategies)
                .build();
    }

}

package bsu.rpact.adapter;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;

@Component
public class BaseAdapter {
    protected String restPreambule = "https://localhost:7166/embed_image";
    protected WebClient webClient;

    @PostConstruct
    public void initWebClient() {
        webClient = WebClient.builder()
                .baseUrl(restPreambule)
                .build();
    }

}

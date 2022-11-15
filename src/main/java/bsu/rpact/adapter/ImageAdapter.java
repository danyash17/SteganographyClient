package bsu.rpact.adapter;

import bsu.rpact.entity.ImageProcessRequest;
import bsu.rpact.entity.ImageProcessResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class ImageAdapter extends BaseAdapter{

    public ImageProcessResponse post(ImageProcessRequest request){
        return webClient.post()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(request), ImageProcessRequest.class)
                .retrieve()
                .bodyToMono(ImageProcessResponse.class)
                .block();
    }

    public void testApi(){
        WebClient.create(apiTestPreambule)
                .get()
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }


}

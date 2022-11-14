package bsu.rpact.adapter;

import bsu.rpact.entity.ImageProcessRequest;
import bsu.rpact.entity.ImageProcessResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
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

}

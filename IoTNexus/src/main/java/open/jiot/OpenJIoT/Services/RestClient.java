package open.jiot.OpenJIoT.Services;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class RestClient {

    public void sendRequest(String url, Object body) {
        WebClient webClient = WebClient
                .builder()
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
        webClient.post()
                .uri(url)
                .bodyValue(body)
                .retrieve();
    }
}

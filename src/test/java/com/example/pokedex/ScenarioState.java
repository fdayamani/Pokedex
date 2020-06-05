package com.example.pokedex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;
import static java.net.http.HttpClient.newHttpClient;

@Component
@ConfigurationPropertiesScan("com.example.pokedex")
@Scope(SCOPE_CUCUMBER_GLUE)
public class ScenarioState {
    @Autowired private Props props;
    private HttpResponse<String> response;

    public void execute(String endpoint) throws IOException, InterruptedException {
        HttpClient client = newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(UriComponentsBuilder.newInstance()
                        .scheme(props.getScheme())
                        .host(props.getHost())
                        .port(props.getPort())
                        .path(endpoint)
                        .build()
                        .toUri())
                .build();

        response = client.send(request, HttpResponse.BodyHandlers.ofString());

    }

    public HttpResponse<String> getResponse() {
        return response;
    }

}

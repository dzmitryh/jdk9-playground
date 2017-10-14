package com.lgi;

import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class HttpClient {
    public static void main(String[] args) {
        jdk.incubator.http.HttpClient httpClient = jdk.incubator.http.HttpClient.newHttpClient();
        try {
            HttpRequest request = HttpRequest.newBuilder().GET()
                    .uri(new URI("http://google.com"))
                    .build();
            CompletableFuture<HttpResponse<String>> future =
                    httpClient.sendAsync(request, HttpResponse.BodyHandler.asString());
            System.out.println(future.get().body());
        } catch (URISyntaxException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

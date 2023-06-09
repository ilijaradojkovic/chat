package com.example.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ChatApplication {


    @Bean
    public WebClient getWebClient(){
        return WebClient.builder().build();
    }

    public static void main(String[] args) {
        SpringApplication.run(ChatApplication.class, args);
    }

}

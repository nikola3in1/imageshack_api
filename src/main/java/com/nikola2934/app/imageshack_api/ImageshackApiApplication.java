package com.nikola2934.app.imageshack_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan("com.nikola2934.app")
public class ImageshackApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImageshackApiApplication.class, args);
    }


    @Bean
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}

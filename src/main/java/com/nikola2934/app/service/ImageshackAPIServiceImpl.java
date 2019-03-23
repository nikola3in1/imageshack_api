package com.nikola2934.app.service;

import com.nikola2934.app.model.Login;
import com.nikola2934.app.model.Upload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Arrays;

@Service
public class ImageshackAPIServiceImpl implements ImageshackAPIService {

    private final String apiKey = "LCDOWQZ7dda2349e1e76c246c6b613ccad839437";
    private final String url = "https://api.imageshack.com/v2/";

    private final String email = "nikola.3in1@gmail.com";
    private final String password = "Nm14031997";
    private String authToken = "";


    @Autowired
    RestTemplate restTemplate;

    @Override
    public String login() {
        String path = "user/login";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
        body.add("user", email);
        body.add("password", password);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(body, headers);

        ResponseEntity<Login> response = restTemplate.postForEntity(url + path, request, Login.class);
        this.authToken = response.getBody().getResult().getAuth_token();
        return this.authToken;
    }


    @Override
    public String getAuthToken() {
        return this.authToken;
    }

    @Override
    public String upload(String imgPath) {
        restTemplate.getMessageConverters()
                .add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

        String path = "images";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_FORM_URLENCODED));
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", new File(imgPath));

        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(body, headers);

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(url + path)
                // Add query parameter
                .queryParam("api_key", apiKey)
                .queryParam("auth_token", authToken);


        System.out.println(builder.build().encode().toUri());

        ResponseEntity<Upload> response = restTemplate.postForEntity(
                builder.build().encode().toUri(),
                request,
                Upload.class);
//                restTemplate.postForEntity("https://api.imageshack.com/v2/images?auth_token="+authToken+"&api_key=LCDOWQZ7dda2349e1e76c246c6b613ccad839437", request, Upload.class);

        System.out.println(url+path+"?auth_token="+authToken);
//        System.out.println(response.getStatusCode() + " "+response.getStatusCodeValue());
//        System.out.println(response.toString());
//        return response.getBody().getResult().getImages()[0].toString();
        System.out.println(response.getBody().getError().toString());
        System.out.println(response.getStatusCode());
        return "cao";
    }

}

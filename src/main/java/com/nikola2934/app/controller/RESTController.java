package com.nikola2934.app.controller;

import com.nikola2934.app.service.CamService;
import com.nikola2934.app.service.ImageshackAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@RequestMapping("/rest/api/**")
public class RESTController {

    @Autowired
    private ImageshackAPIService imgApiService;

    @Autowired
    private CamService camService;

    @GetMapping("/login")
    public String test() {
        imgApiService.login();
        return imgApiService.getAuthToken();
    }

    @GetMapping("/cam")
    public String camTest() {
        for (int i = 0; i < 10; i++) {
            camService.capture();
        }
        return "done";
    }

    @GetMapping("/upload")
    public String upload() {
        imgApiService.login();
        String imgPath = camService.capture();
        String response = imgApiService.upload(imgPath);
        return "Response: " + response;

    }

    @GetMapping("/path")
    public String path() {
        try {
            return new File(RESTController.class.getProtectionDomain().getCodeSource().getLocation()
                    .toURI()).getPath();
        } catch (Exception e) {
            System.out.println(e);
        }
        return "as";
    }
}

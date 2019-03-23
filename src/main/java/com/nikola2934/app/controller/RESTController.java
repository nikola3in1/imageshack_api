package com.nikola2934.app.controller;

import com.nikola2934.app.service.CamService;
import com.nikola2934.app.service.ImageshackAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*This class is purely used for testing purposes*/

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

//    @GetMapping("/cam")
//    public String camTest() {
//        return camService.capture().getPath();
//    }

    @GetMapping("/upload")
    public String upload() {
        imgApiService.login();
        Long startTime = System.currentTimeMillis();
        String response = "";

        for (int i = 0; i < 50; i++) {
            response += imgApiService.upload(camService.capture())+ "\n";
        }

        Long takenTime = System.currentTimeMillis() - startTime;
        response += "\nTime taken: " + takenTime;
        return "\nResponse: " + response;
    }

//    private String uploadPicture(int nr) {
//        String response = "";
//        for (int i = 0; i <= nr; i++) {
//            File image = camService.capture();
//            response += "Image nr. " + i + " : " + imgApiService.upload(image)+" \n";
//        }

//        response += "Time taken: " + takenTime;
//        return "\n"+response;
//    }

}

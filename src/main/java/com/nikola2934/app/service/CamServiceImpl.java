package com.nikola2934.app.service;

import com.nikola2934.app.service.camera.Cam;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CamServiceImpl implements CamService {

    private AtomicInteger counter = new AtomicInteger(0);

    @Override
    public String capture() {
        File image = null;
        String imgPath = "error";
        try {
            Cam cam = new Cam("JPG", 640, 480);
            image = cam.getImage();
            imgPath = cam.getImagePath();
        } catch (Exception e) {
            System.out.println(e);
        }
        return imgPath;
    }
}

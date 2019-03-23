package com.nikola2934.app.service;

import com.nikola2934.app.model.Image;
import com.nikola2934.app.service.camera.Cam;
import org.springframework.stereotype.Service;

@Service
public class CamServiceImpl implements CamService {

    @Override
    public Image capture() {
        Image image = null;
        try {
            Cam cam = new Cam("JPG", 640, 480);
            image = cam.getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }
}

package com.nikola2934.app.service;

import com.nikola2934.app.model.Image;

public interface ImageshackAPIService {
    String login();
    String upload(Image image);
    String getAuthToken();
}

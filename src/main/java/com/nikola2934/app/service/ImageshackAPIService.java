package com.nikola2934.app.service;

import java.util.Map;

public interface ImageshackAPIService {
    String login();
    String upload(String imgPath);
    String getAuthToken();
}

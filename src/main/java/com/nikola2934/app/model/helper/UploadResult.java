package com.nikola2934.app.model.helper;

import java.util.Arrays;

public class UploadResult {
    String passed = "";

    Error error;

    UploadResult(){}

    public String getPassed() {
        return passed;
    }

    public void setPassed(String passed) {
        this.passed = passed;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }


    //    private Images[] images;
//
//    public Images[] getImages() {
//        return images;
//    }
//
//    public void setImages(Images[] images) {
//        this.images = images;
//    }
//
//    @Override
//    public String toString() {
//        return "UploadResult{" +
//                "images=" + Arrays.toString(images) +
//                '}';
//    }


    @Override
    public String toString() {
        return "UploadResult{" +
                "passed='" + passed + '\'' +
                '}';
    }
}

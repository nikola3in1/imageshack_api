package com.nikola2934.app.model;

import com.nikola2934.app.model.helper.MyError;
import com.nikola2934.app.model.helper.UploadResult;

//Response model class
public class Upload {
    String success = "";
    MyError error;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public MyError getError() {
        return error;
    }

    public void setError(MyError error) {
        this.error = error;
    }

    //    private UploadResult result;
//
//    public UploadResult getResult() {
//        return result;
//    }
//
//    public void setResult(UploadResult result) {
//        this.result = result;
//    }
//
//    @Override
//    public String toString() {
//        return "Upload{" +
//                "result=" + result +
//                '}';
//    }
}

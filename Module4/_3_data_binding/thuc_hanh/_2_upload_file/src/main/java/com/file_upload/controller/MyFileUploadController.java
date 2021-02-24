package com.file_upload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;

@Controller
public class MyFileUploadController {

    public void initBinder(WebDataBinder dataBinder){
        Object target = dataBinder.getTarget();
        if(target == null){
            return;
        }
    }
}

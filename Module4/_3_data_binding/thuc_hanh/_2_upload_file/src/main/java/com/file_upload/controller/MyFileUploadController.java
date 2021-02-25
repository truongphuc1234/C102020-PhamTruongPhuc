package com.file_upload.controller;

import com.file_upload.form.MyUploadForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MyFileUploadController {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        Object target = dataBinder.getTarget();
        if(target == null){
            return;
        }
        System.out.println("Target = "+target);
        if(target.getClass() == MyUploadForm.class){
            dataBinder.registerCustomEditor(byte[].class,new ByteArrayMultipartFileEditor());
        }
    }

    @RequestMapping(value = "/uploadOneFile", method = RequestMethod.GET)
    public String uploadOneFileHandler(Model model){
        MyUploadForm myUploadForm = new MyUploadForm();
        model.addAttribute("myUploadForm", myUploadForm);
        return "uploadOneFile";
    }

    @RequestMapping(value = "/uploadMultiFile", method = RequestMethod.GET)
    public String uploadMultiFileHandler(Model model){
        MyUploadForm myUploadForm = new MyUploadForm();
        model.addAttribute("myUploadForm", myUploadForm);
        return "uploadMultiFile";
    }

    @RequestMapping(value = "/uploadOneFile", method = RequestMethod.POST)
    public String uploadOneFileHandlerPOST(HttpServletRequest request, Model model, @ModelAttribute("myUploadForm") MyUploadForm myUploadForm){
        return this.doUpload(request,model,myUploadForm);
    }

    @RequestMapping(value = "/uploadMultiFile", method = RequestMethod.POST)
    public String uploadMultiFileHandlerPOST(HttpServletRequest request, Model model, @ModelAttribute("myUploadForm") MyUploadForm myUploadForm){
        return this.doUpload(request, model, myUploadForm);
    }

    private String doUpload(HttpServletRequest request, Model model, MyUploadForm myUploadForm) {
        String description = myUploadForm.getDescription();
        System.out.println("Description: "+ description);

        String uploadRootPath = request.getServletContext().getRealPath("upload");
        System.out.println("uploadRootPath: "+ uploadRootPath);

        File uploadRootDir = new File(uploadRootPath);
        if(!uploadRootDir.exists()){
            uploadRootDir.mkdir();
        }

        CommonsMultipartFile[] fileDatas = myUploadForm.getFileData();
        Map<File,String> uploadedFiles = new HashMap<>();

        for(CommonsMultipartFile fileData: fileDatas){
            String name = fileData.getOriginalFilename();
            System.out.println("Client File Name = "+name);
            if(name != null && name.length() >0){
                try {
                    File serverFile = new File(uploadRootDir.getAbsolutePath()+ File.separator + name);
                    BufferedOutputStream stream = new BufferedOutputStream((new FileOutputStream(serverFile)));
                    stream.write(fileData.getBytes());
                    stream.close();
                    uploadedFiles.put(serverFile,name);
                    System.out.println("Write file: "+ serverFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        model.addAttribute("description", description);
        model.addAttribute("uploadFiles", uploadedFiles);
        return "uploadResult";
    }


}

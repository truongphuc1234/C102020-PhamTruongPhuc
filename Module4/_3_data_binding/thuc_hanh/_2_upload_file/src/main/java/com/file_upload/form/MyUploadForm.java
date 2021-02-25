package com.file_upload.form;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class MyUploadForm {
    private String description;
    private CommonsMultipartFile[] fileData;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CommonsMultipartFile[] getFileData() {
        return fileData;
    }

    public void setFileData(CommonsMultipartFile[] fileData) {
        this.fileData = fileData;
    }
}

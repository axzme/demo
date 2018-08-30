package com.springboot.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface FileUploadService {
    public String fileUpload(MultipartFile file, HttpServletRequest request);
}

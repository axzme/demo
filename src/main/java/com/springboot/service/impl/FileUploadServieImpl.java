package com.springboot.service.impl;
import com.springboot.service.FileUploadService;
import com.springboot.util.BaseResultBean;
import enumBean.CodeEnum;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.*;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

@Service
public class FileUploadServieImpl implements FileUploadService {
    @Override
    public String fileUpload(MultipartFile file, HttpServletRequest request) {
        String originalFilename = file.getOriginalFilename();
        String fileName = new Date().getTime()+originalFilename.substring(originalFilename.lastIndexOf(".",originalFilename.length())) ;
        File filePath = new File("E:/images/");
        try {
            byte[] fileBytes = file.getBytes();
            return uploadFile(fileBytes, filePath, fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return BaseResultBean.baseResultBean.fail(CodeEnum.FAIL.getCode(), "fail");
        }
    }

    /*获取多个文件*/
    private void getMultiFile(HttpServletRequest request){
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        if (commonsMultipartResolver.isMultipart(request)){
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()){
                MultipartFile file1 = multiRequest.getFile(iter.next());
                file1.getOriginalFilename();
            }
        }
    }

    private String uploadFile(byte[] fileBytes, File filePath, String fileName) {
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        try {
            FileOutputStream fos = new FileOutputStream(filePath+"/" + fileName);
            fos.write(fileBytes);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return BaseResultBean.baseResultBean.fail(CodeEnum.FAIL.getCode(), "fail");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return BaseResultBean.baseResultBean.suc(CodeEnum.OK.getCode());
    }
}

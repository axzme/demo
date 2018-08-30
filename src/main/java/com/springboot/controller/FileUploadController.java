package com.springboot.controller;

import com.springboot.service.FileUploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("springboot/file")
@Api(value = "file上传")
public class FileUploadController {

   @Autowired
   FileUploadService fileService ;

    @RequestMapping(value = "upload",method = RequestMethod.POST)
    @ApiOperation("/upload")
    public String fileUpload(@Param(value = "file") MultipartFile file, HttpServletRequest request){
      return fileService.fileUpload(file,request);

    }
}

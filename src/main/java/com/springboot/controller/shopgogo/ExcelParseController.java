package com.springboot.controller.shopgogo;
import com.springboot.service.impl.ShopgogoCategoryServiceImpl;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "excel-parse")
public class ExcelParseController {
    @Autowired
    ShopgogoCategoryServiceImpl shopgogoCategoryServiceImpl;

    @RequestMapping(value = "upload-category",method = RequestMethod.POST)
    public void excelParseCategory(MultipartFile file, HttpServletRequest request) {
        shopgogoCategoryServiceImpl.parseExcelCategory(file);
    }

    @RequestMapping(value = "upload-property",method = RequestMethod.POST)
    public void excelParseProperty(MultipartFile file, HttpServletRequest request) {
        shopgogoCategoryServiceImpl.parseExcelProperty(file);
    }

    //TODO category与property关联
    /*@RequestMapping(value = "upload-category_property",method = RequestMethod.POST)
    public void excelParseCategoryProperty(MultipartFile file, HttpServletRequest request) {
        shopgogoCategoryServiceImpl.parseExcelCategoryProperty(file);
    }*/
}

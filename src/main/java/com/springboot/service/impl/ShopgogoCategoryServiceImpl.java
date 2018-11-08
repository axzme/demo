package com.springboot.service.impl;

import com.springboot.enumbean.ActiveStatusEnum;
import com.springboot.mapper.shopgogo.ShopgogoCategoryMapper;
import com.springboot.mapper.shopgogo.ShopgogoCategoryToPropertyMapper;
import com.springboot.mapper.shopgogo.ShopgogoGoodsPropertyMapper;
import com.springboot.mapper.shopgogo.ShopgogoPropertyValueMapper;
import com.springboot.model.shopgogo.ShopgogoCategory;
import com.springboot.model.shopgogo.ShopgogoCategoryToProperty;
import com.springboot.model.shopgogo.ShopgogoGoodsProperty;
import com.springboot.model.shopgogo.ShopgogoPropertyValue;
import com.springboot.service.ShopgogoCategoryService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

@Service
public class ShopgogoCategoryServiceImpl implements ShopgogoCategoryService{
    @Autowired
    ShopgogoCategoryMapper shopgogoCategoryMapper;

    @Autowired
    ShopgogoGoodsPropertyMapper shopgogoGoodsPropertyMapper;

    @Autowired
    ShopgogoPropertyValueMapper shopgogoPropertyValueMapper;

    @Autowired
    ShopgogoCategoryToPropertyMapper shopgogoCategoryToPropertyMapper;

    @Transactional
    public void parseExcelCategory(MultipartFile file){
        Workbook workbook = null;
        try {
            InputStream is = file.getInputStream();
            workbook = new XSSFWorkbook(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (workbook != null){
            Sheet sheet = workbook.getSheetAt(0);
            int firstRowNum = sheet.getFirstRowNum();
            int lastRowNum = sheet.getLastRowNum();
            ShopgogoCategory level1Category = new ShopgogoCategory();
            ShopgogoCategory level2Category = new ShopgogoCategory();
            int level1Sequence = 1;
            int level2Sequence = 1;
            int level3Sequence = 1;
            String level1Code = "";
            String level2Code = "";
            for (int i =7;i<lastRowNum;i++){
                Row row = sheet.getRow(i);
                short firstCellNum = row.getFirstCellNum();
                short lastCellNum = row.getLastCellNum();
                for (int j=firstCellNum;j<3;j++){
                    Cell cell = row.getCell(j);
                    String name = cell.getStringCellValue();
                    if (j == 0 && name != null  && name != ""){
                        level1Category =  insertCategory(name,null,(byte)(j+1),level1Sequence,null);
                        level1Code = level1Category.getCode();
                        level1Sequence++;
                    }else if (j == 1 && name != null  && name != ""){
                        level2Category = insertCategory(name,level1Category.getId(),(byte)(j+1),level2Sequence,level1Code);
                        level2Code = level2Category.getCode();
                        level2Sequence++;
                    }else if (j == 2 && name != null && name != ""){
                        insertCategory(name,level2Category.getId(),(byte)(j+1),level3Sequence,level2Code);
                        level3Sequence++;
                    }
                }
            }
        }
    }
    
    private ShopgogoCategory insertCategory(String name,Integer parentId,Byte level,int levelSequence,String code){
        ShopgogoCategory shopgogoCategory = new ShopgogoCategory();
        shopgogoCategory.setName(name);
        shopgogoCategory.setCounts(0);
        shopgogoCategory.setCreateBy(6l);
        shopgogoCategory.setStatus(ActiveStatusEnum.ACTIVE.getIndex());
        shopgogoCategory.setUpdateBy(6l);
        shopgogoCategory.setUpdateDatetime(new Date());
        shopgogoCategory.setCreateDatetime(new Date());
        shopgogoCategory.setLevel(level);
        shopgogoCategory.setParentId(parentId);
        shopgogoCategory.setSequence(levelSequence);

        shopgogoCategoryMapper.insert(shopgogoCategory);
        if (shopgogoCategory.getParentId()==null){
            shopgogoCategory.setCode(String.format("%0"+3+"d",shopgogoCategory.getId()));
        }else {
            shopgogoCategory.setCode(code+""+String.format("%0"+3+"d",shopgogoCategory.getId()));
        }
        shopgogoCategoryMapper.updateByPrimaryKeySelective(shopgogoCategory);
        return shopgogoCategory;
    }

    @Transactional
    public void parseExcelProperty(MultipartFile file) {
        Workbook workbook = null;
        try{
            InputStream is = file.getInputStream();
            workbook = new XSSFWorkbook(is);
        }catch (IOException e){
            e.printStackTrace();
        }
        if (workbook != null){
            int sheets = workbook.getNumberOfSheets();
            for (int sheetIndex=1;sheetIndex<sheets-1;sheetIndex++){
                Sheet sheetAt = workbook.getSheetAt(sheetIndex);
                String sheetName = sheetAt.getSheetName();
                ShopgogoGoodsProperty shopgogoGoodsProperty = insertShopgogoGoodsProperty(sheetName);
                int firstRowNum = sheetAt.getFirstRowNum();
                int lastRowNum = sheetAt.getLastRowNum();
                for (int i=firstRowNum;i<=lastRowNum;i++){
                    Row row = sheetAt.getRow(i);
                    short firstCellNum = row.getFirstCellNum();
                    short lastCellNum = row.getLastCellNum();
                    for (int j=firstCellNum;j<lastCellNum;j++){
                        ShopgogoPropertyValue shopgogoPropertyValue = new ShopgogoPropertyValue();
                        Cell cell = row.getCell(j);
                        switch (cell.getCellType()){
                            case Cell.CELL_TYPE_NUMERIC:
                                if (Double.valueOf(cell.getNumericCellValue()) != null){
                                    shopgogoPropertyValue.setValue(cell.getNumericCellValue()+"");
                                    shopgogoPropertyValue.setPropertyId(shopgogoGoodsProperty.getId());
                                    shopgogoPropertyValueMapper.insert(shopgogoPropertyValue);
                                }
                                break;
                            case Cell.CELL_TYPE_STRING:
                                if (cell.getStringCellValue() != null){
                                    shopgogoPropertyValue.setValue(cell.getStringCellValue());
                                    shopgogoPropertyValue.setPropertyId(shopgogoGoodsProperty.getId());
                                    shopgogoPropertyValueMapper.insert(shopgogoPropertyValue);
                                }
                                break;
                        }
                    }
                }
            }
        }
    }
    
    private ShopgogoGoodsProperty insertShopgogoGoodsProperty(String sheetName){
        ShopgogoGoodsProperty shopgogoGoodsProperty = new ShopgogoGoodsProperty();
        shopgogoGoodsProperty.setCreateBy(6);
        shopgogoGoodsProperty.setCreateDatetime(new Date());
        shopgogoGoodsProperty.setName(sheetName);
        shopgogoGoodsProperty.setStatus(ActiveStatusEnum.ACTIVE.getIndex());
        shopgogoGoodsProperty.setUpdateBy(6);
        shopgogoGoodsProperty.setUpdateDatetime(new Date());
        shopgogoGoodsPropertyMapper.insert(shopgogoGoodsProperty);
        return shopgogoGoodsProperty;
    }

    @Transactional
    public void parseExcelCategoryProperty(MultipartFile file) {
        Workbook workbook = null;
        try{
            InputStream is = file.getInputStream();
            workbook = new XSSFWorkbook(is);
        }catch (IOException e){
            e.printStackTrace();
        }
        if (workbook != null){
            Sheet sheetAt = workbook.getSheetAt(0);
            int firstRowNum = sheetAt.getFirstRowNum();
            int lastRowNum = sheetAt.getLastRowNum();
            for (int i = 7;i <= lastRowNum;i++){
                Row row = sheetAt.getRow(i);
                short firstCellNum = row.getFirstCellNum();
                short lastCellNum = row.getLastCellNum();
                ShopgogoCategory shopgogoCategory = new ShopgogoCategory();
                for (int j = 1;j < 4;j++){
                    Cell cell = row.getCell(j);
                    String name = cell.getStringCellValue();
                    if (j == 1 ){
                        if (row.getCell(j + 1).getStringCellValue() !=null ){
                            name = row.getCell(j + 1).getStringCellValue();
                        }
                        shopgogoCategory.setName(name);
                        shopgogoCategory = shopgogoCategoryMapper.selectOne(shopgogoCategory);

                    }else if (j == 3){
                        if (name != null && name != "" && name != "x"){
                            String[] split = name.split(",");
                            for (String temp:split) {
                                ShopgogoGoodsProperty shopgogoGoodsProperty = selectCategoryProperty(temp);
                                insertCategoryToProperty(shopgogoCategory.getId(),shopgogoGoodsProperty.getId());
                            }
                        }
                    }
                }
            }
        }
    }

    private ShopgogoGoodsProperty selectCategoryProperty(String temp) {
        ShopgogoGoodsProperty shopgogoGoodsProperty = new ShopgogoGoodsProperty();
        shopgogoGoodsProperty.setName(temp);
        shopgogoGoodsProperty = shopgogoGoodsPropertyMapper.selectOne(shopgogoGoodsProperty);
        return shopgogoGoodsProperty;
    }

    private void insertCategoryToProperty(Integer categoryId,Integer propertyId) {
        ShopgogoCategoryToProperty shopgogoCategoryToProperty = new ShopgogoCategoryToProperty();
        shopgogoCategoryToProperty.setCategoryId(categoryId);
        shopgogoCategoryToProperty.setPropertyId(propertyId);
        shopgogoCategoryToPropertyMapper.insert(shopgogoCategoryToProperty);
    }
}

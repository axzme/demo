package com.springboot.util;


public class BaseResultBean {
   public static BaseResultBean baseResultBean = new BaseResultBean();
    public String fail(int code,String msg){
        return "Status Code: "+code+" msg: "+msg;
    }
    public String suc(int code){
        return "Status Code: "+code;
    }
}

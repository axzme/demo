package com.springboot.enumbean;

public enum  MailEnum {
    FROM("axz2222@163.com");
    private String values;
    MailEnum(String values){
        this.values = values;
    }

    public void setValues(String values) {
        this.values = values;
    }
}

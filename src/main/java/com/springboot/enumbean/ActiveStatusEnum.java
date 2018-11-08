package com.springboot.enumbean;

public enum ActiveStatusEnum {
     ACTIVE((byte)1),
    INACTIVE((byte)2);
     private Byte index;
     ActiveStatusEnum(Byte index){
         this.index = index;
     }

    public Byte getIndex() {
        return index;
    }

    public void setIndex(Byte index) {
        this.index = index;
    }
}

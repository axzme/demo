package enumBean;

public enum  CodeEnum {
    OK("OK",200),
    FAIL("fail",503);
    private  String name;
    private  int code;
    private CodeEnum(String name,int code){
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}


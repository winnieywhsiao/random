package com.example.random;

public class Resau {
    private Resau[] records;
    private String id;
    private re_fields fields;
    private String createTime;

    public Resau(String id, re_fields fields1, String createTime) {
        this.id = id;
        this.fields = fields1;
        this.createTime = createTime;
    }

    public Resau[] getarr2(){
        return records;
    }

    public String getId(int i) {
        return records[i].id;
    }

    public String getfieldsPassword(int i){
        return records[i].fields.getPassword();
    }

    public String getfieldsEmail(int i) {
        return records[i].fields.getEmail();
    }

    public String getfieldsName(int i) {
        return records[i].fields.getName();
    }

    public boolean getfieldsCheck(int i) {
        return records[i].fields.getCheck();
    }

    public re_fields getFields() {
        return fields;
    }

    public String getCreateTime() {
        return createTime;
    }
}

package com.example.todolistroomdatabase.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// Tạo các đối tượng có trong database
@Entity(tableName = "Word")
public class WordEntity {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "en")
    private String en;

    @ColumnInfo(name = "vn")
    private String vn;

    @ColumnInfo(name = "isMemorized",typeAffinity = ColumnInfo.INTEGER)
    private Integer isMemorized;

    public WordEntity(String en, String vn, Integer isMemorized) {
        this.en = en;
        this.vn = vn;
        this.isMemorized = isMemorized;
    }

    public WordEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getVn() {
        return vn;
    }

    public void setVn(String vn) {
        this.vn = vn;
    }

    public Integer getIsMemorized() {
        return isMemorized;
    }

    public void setIsMemorized(Integer isMemorized) {
        this.isMemorized = isMemorized;
    }
}

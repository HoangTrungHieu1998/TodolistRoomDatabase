package com.example.todolistroomdatabase.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {WordEntity.class},version = 1)
public abstract class DatabaseWord extends RoomDatabase {

    public abstract WordDao getWordDao();
    private static DatabaseWord databaseWord = null;

    public static DatabaseWord getInstance(Context context){

        // Nếu database không có dữ liệu thì tạo mới
        if (databaseWord == null){
            databaseWord = Room.databaseBuilder(context,DatabaseWord.class,"Databaseword.sql").build();
        }
        return databaseWord;
    }
}

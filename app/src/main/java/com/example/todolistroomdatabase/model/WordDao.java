package com.example.todolistroomdatabase.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Maybe;

@Dao
public interface WordDao {

    // Lấy tất cả dữ liệu trong database
    @Query("SELECT * FROM Word")
    Maybe<List<WordEntity>> getWord();


    @Insert(onConflict = OnConflictStrategy.IGNORE) // Tránh insert cùng lúc
    Maybe<Long> insertWord(WordEntity wordEntity);

    @Update
    Maybe<Integer> updateWord(WordEntity wordEntity);

    @Delete
    Maybe<Void> deleteWord(WordEntity wordEntity);
}

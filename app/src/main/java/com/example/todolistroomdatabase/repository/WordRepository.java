package com.example.todolistroomdatabase.repository;

import android.content.Context;

import com.example.todolistroomdatabase.model.DatabaseWord;
import com.example.todolistroomdatabase.model.WordDao;
import com.example.todolistroomdatabase.model.WordEntity;

import java.util.List;

import io.reactivex.Maybe;

// Tạo phương thức liên kết giữa ViewModel và Model
public class WordRepository {

    private  static WordDao wordDao = null;
    private static WordRepository wordRepository = null;

    private WordRepository(Context context){
        wordDao = DatabaseWord.getInstance(context).getWordDao();
    }

    public static WordRepository getInstance(Context context){

        // Nếu repository chưa dc tạo thì tạo mới
        if(wordRepository == null){
            wordRepository = new WordRepository(context);
        }
        return wordRepository;
    }

    // Phương thức liên kết giữa interface WordDao và WordRepository
    public Maybe<List<WordEntity>> getWords(){
        return wordDao.getWord();
    }
    // Insert
    public Maybe<Long> insertWords(WordEntity wordEntity){
        return wordDao.insertWord(wordEntity);
    }

    //Update
    public Maybe<Integer> updateWords(WordEntity wordEntity){
        return wordDao.updateWord(wordEntity);
    }

    public Maybe<Void> deleteWords(WordEntity wordEntity){
        return wordDao.deleteWord(wordEntity);
    }
}

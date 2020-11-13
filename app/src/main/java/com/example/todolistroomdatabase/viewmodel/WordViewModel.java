package com.example.todolistroomdatabase.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.todolistroomdatabase.model.WordEntity;
import com.example.todolistroomdatabase.repository.WordRepository;

import java.util.List;

import io.reactivex.MaybeObserver;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class WordViewModel extends AndroidViewModel {
    private MutableLiveData<List<WordEntity>> mListWords;
    private MutableLiveData<Long> mInsertSuccess;
    private MutableLiveData<Integer> mUpdateSuccess;
    private MutableLiveData<Void> mDeleteSuccess;
    private WordRepository mWordRepository = null;

    public WordViewModel(@NonNull Application application) {
        super(application);
        mListWords = new MutableLiveData<>();
        mInsertSuccess = new MutableLiveData<>();
        mUpdateSuccess = new MutableLiveData<>();
        mDeleteSuccess = new MutableLiveData<>();
        mWordRepository = WordRepository.getInstance(application.getBaseContext());
    }


    // Tạo observable thông qua interface cho Activity
    public void callWords() {
        mWordRepository.getWords()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MaybeObserver<List<WordEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<WordEntity> wordEntities) {
                        // Gắn dữ liệu từ database cho livedata
                        mListWords.setValue(wordEntities);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    // Tạo dữ liệu lưu trữ cho Activity
    public LiveData<List<WordEntity>> getWords() {
        return mListWords;
    }

    public void InsertWord(WordEntity wordEntity) {
        mWordRepository.insertWords(wordEntity)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MaybeObserver<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Long aLong) {
                        mInsertSuccess.setValue(aLong);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public LiveData<Long> getInsertSuccess() {
        return mInsertSuccess;
    }

    public void UpdateWord(WordEntity wordEntity) {
        mWordRepository.updateWords(wordEntity)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MaybeObserver<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Integer integer) {
                        mUpdateSuccess.setValue(integer);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public LiveData<Integer> getUpdateSuccess() {
        return mUpdateSuccess;
    }

    public void DeleteWord(WordEntity wordEntity) {
        mWordRepository.deleteWords(wordEntity)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MaybeObserver<Void>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Void aVoid) {
                        mDeleteSuccess.setValue(aVoid);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public LiveData<Void> getDeleteSuccess() {
        return mDeleteSuccess;
    }
}

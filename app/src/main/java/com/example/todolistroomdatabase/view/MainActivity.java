package com.example.todolistroomdatabase.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.todolistroomdatabase.R;
import com.example.todolistroomdatabase.model.WordEntity;
import com.example.todolistroomdatabase.viewmodel.WordViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    WordViewModel mWordViewModel;
    List<WordEntity> mList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWordViewModel = new WordViewModel(getApplication());



        // Lấy dữ liệu từ View Model để render UI
        mWordViewModel.getWords().observe(this, new Observer<List<WordEntity>>() {
            @Override
            public void onChanged(List<WordEntity> wordEntities) {
                WordEntity wordEntity = wordEntities.get(1);
                Log.d("BBB",wordEntity.getId()+"");
                wordEntity.setIsMemorized(1);
                mWordViewModel.UpdateWord(wordEntity);
            }
        });

        mWordViewModel.callWords();



//        mWordViewModel.getInsertSuccess().observe(this, new Observer<Long>() {
//            @Override
//            public void onChanged(Long aLong) {
//                Toast.makeText(MainActivity.this, aLong + "", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        mWordViewModel.InsertWord(new WordEntity("One","Một",0));

        mWordViewModel.getUpdateSuccess().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                Toast.makeText(MainActivity.this, integer + "", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
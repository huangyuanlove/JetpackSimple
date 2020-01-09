package com.huangyuanlove.androidjetpack.architecture.roomword;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.List;


public class WordRepository {

    private WordDAO wordDAO;
    private LiveData<List<Word>> allWords;


   public WordRepository(Application application){
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        wordDAO = db.wordDAO();
        allWords = wordDAO.getAlphabetizedWords();
    }


    public LiveData<List<Word>> getAllWords() {
        Log.e("huangyuan","WordRepository#getAllWords");
        return allWords;
    }

   public void insert(final Word word){
        WordRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                Log.e("huangyuan","WordRepository#insert");
                wordDAO.insert(word);
            }
        });
    }

}

package com.huangyuanlove.androidjetpack.architecture.roomword;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * Description:
 * Author: huangyuan
 * Create on: 2020-01-08
 * Email: huangyuan@chunyu.me
 */
public class WordRepository {

    private WordDAO wordDAO;
    private LiveData<List<Word>> allWords;


   public WordRepository(Application application){
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        wordDAO = db.wordDAO();
        allWords = wordDAO.getAlphabetizedWords();
    }


    public LiveData<List<Word>> getAllWords() {
        return allWords;
    }

   public void insert(final Word word){
        WordRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                wordDAO.insert(word);
            }
        });
    }

}

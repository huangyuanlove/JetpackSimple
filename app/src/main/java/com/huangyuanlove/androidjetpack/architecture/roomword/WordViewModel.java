package com.huangyuanlove.androidjetpack.architecture.roomword;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * Description:
 * Author: huangyuan
 * Create on: 2020-01-08
 * Email: huangyuan@chunyu.me
 */

public class WordViewModel extends AndroidViewModel {

    private WordRepository wordRepository;
    private LiveData<List<Word>> allWords;


    public WordViewModel(@NonNull Application application) {
        super(application);

        wordRepository = new WordRepository(application);
        allWords = wordRepository.getAllWords();

    }

    public LiveData<List<Word>> getAllWords() {
        return allWords;
    }


    public void insert(Word word) {
        wordRepository.insert(word);
    }
}

package com.huangyuanlove.androidjetpack.architecture.roomword;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;


public class WordViewModel extends AndroidViewModel {

    private WordRepository wordRepository;
    private LiveData<List<Word>> allWords;


    public WordViewModel(@NonNull Application application) {
        super(application);

        wordRepository = new WordRepository(application);
        allWords = wordRepository.getAllWords();

    }

    public LiveData<List<Word>> getAllWords() {
        Log.e("huangyuan","WordViewModel#getAllWords");
        return allWords;
    }


    public void insert(Word word) {
        Log.e("huangyuan","WordViewModel#insert");
        wordRepository.insert(word);
    }
}

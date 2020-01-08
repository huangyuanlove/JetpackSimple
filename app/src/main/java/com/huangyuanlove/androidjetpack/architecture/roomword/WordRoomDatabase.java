package com.huangyuanlove.androidjetpack.architecture.roomword;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description:
 * Author: huangyuan
 * Create on: 2020-01-08
 * Email: huangyuan@chunyu.me
 */

@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class WordRoomDatabase extends RoomDatabase {

    public abstract WordDAO wordDAO();

    private static volatile WordRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREAD = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREAD);
    private static RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            databaseWriteExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    WordDAO dao = INSTANCE.wordDAO();
                    dao.deleteAll();

                    Word word = new Word("Hello");
                    dao.insert(word);
                    word = new Word("World");
                    dao.insert(word);
                }
            });

        }
    };

    static WordRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WordRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), WordRoomDatabase.class, "word_room.db")
                            .addCallback(roomDatabaseCallback)
                            .build();

                }
            }
        }


        return INSTANCE;


    }


}

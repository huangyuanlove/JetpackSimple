package com.huangyuanlove.androidjetpack.architecture.room;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

@Database(entities = {User.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();
    private static AppDatabase db;

    public static Migration MIGRATION_1_2 = new Migration(1,2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("alter table user add column sex text");

        }
    };

    public static AppDatabase get(final Context context) {
        if (db == null) {
            db = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "paging.db")
                    .addCallback(new RoomDatabase.Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase database) {
                            super.onCreate(database);
                            Log.i("AppDatabase", "【onCreate】");
                            new Thread(
                                    new Runnable() {
                                        @Override
                                        public void run() {
                                            List<User> users = new ArrayList<>();
                                            for (int i = 0; i < 50; i++) {

                                                User user = new User();
                                                user.id = System.currentTimeMillis();
                                                user.age = i ;
                                                user.name = "item"+i;
                                                Address address = new Address("city"+ i,"postCode" +i);
                                                user.address = address;

                                                users.add(user);
                                                get(context).userDao().insertUser(user);
                                            }
                                        }
                                    }
                            ).start();



                        }
                    })
                    .build();
        }
        return db;
    }

}

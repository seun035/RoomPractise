package com.oluwaseun.liadi.cantactroompractise.dagger;

import android.content.Context;

import androidx.room.Room;

import com.oluwaseun.liadi.cantactroompractise.database.AppDatabase;

import dagger.Module;
import dagger.Provides;

@Module
public class AppDatabaseModule {

    private Context context;

    public AppDatabaseModule(Context context) {
        this.context = context;
    }

    @Provides
    public AppDatabase provideAppDatabaseModule() {
        return Room.databaseBuilder(context,
                AppDatabase.class, "contact.db").allowMainThreadQueries().build();
    }
}

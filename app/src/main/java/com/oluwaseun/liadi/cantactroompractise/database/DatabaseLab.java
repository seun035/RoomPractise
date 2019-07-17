package com.oluwaseun.liadi.cantactroompractise.database;

import android.content.Context;

import androidx.room.Room;

public class DatabaseLab {
    private static DatabaseLab sDatabaseLab;
    private Context mContext;
    private AppDatabase db;

    public static DatabaseLab get(Context context)
    {
        if (sDatabaseLab == null){
            sDatabaseLab = new DatabaseLab(context);
        }
        return sDatabaseLab;
    }

    private DatabaseLab(Context context) {
        mContext = context;
        db = Room.databaseBuilder(mContext,
                AppDatabase.class, "contact.db").allowMainThreadQueries().build();
    }

    public AppDatabase getRoomInstance() {
        return db;
    }
}

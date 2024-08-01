package com.aarav.contactmanagerapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Contact.class}, version = 1)
public abstract class ContactDatabase extends RoomDatabase {

    public abstract ContactDAO getContactDAO();

    //Singleton pattern

    private static ContactDatabase dbInstance;

    public static synchronized ContactDatabase getDbInstance(Context context){
        if(dbInstance == null){
            dbInstance = Room.databaseBuilder(context.getApplicationContext(), ContactDatabase.class, "contacts_db").fallbackToDestructiveMigration().build();
        }

        return  dbInstance;
    }
}

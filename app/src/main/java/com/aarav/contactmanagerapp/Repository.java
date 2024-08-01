package com.aarav.contactmanagerapp;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Repository {

    ExecutorService executor;
    Handler handler;

    private final ContactDAO contactDAO;

    public Repository(Application application) {
        ContactDatabase contactDatabase = ContactDatabase.getDbInstance(application);
        this.contactDAO = contactDatabase.getContactDAO();


        executor = Executors.newSingleThreadExecutor();
        handler = new Handler(Looper.getMainLooper());
    }

    public void addContact(Contact contact){

        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactDAO.insert(contact);
            }
        });
    }

    public void deleteContact(Contact contact){

        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactDAO.delete(contact);
            }
        });
    }

    public LiveData<List<Contact>> getAllContacts(){
        return contactDAO.getAllContacts();
    }
}

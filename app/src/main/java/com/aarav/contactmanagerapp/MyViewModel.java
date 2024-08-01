package com.aarav.contactmanagerapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MyViewModel extends AndroidViewModel {
    private Repository myRepository;

    public LiveData<List<Contact>> allContacts;

    public MyViewModel(@NonNull Application application) {
        super(application);
        this.myRepository = new Repository(application);
    }

    public LiveData<List<Contact>> getAllContacts(){
        allContacts = myRepository.getAllContacts();
        return allContacts;
    }

    public void addNewContact(Contact contact){
        myRepository.addContact(contact);
    }


    public void deleteContact(Contact contact){
        myRepository.deleteContact(contact);
    }


}

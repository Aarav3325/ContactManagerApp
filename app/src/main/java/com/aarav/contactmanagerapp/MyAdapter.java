package com.aarav.contactmanagerapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.aarav.contactmanagerapp.databinding.ContactListItemBinding;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ContactViewHolder> {

    private ArrayList<Contact> contacts;

    public MyAdapter(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ContactListItemBinding contactListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.contact_list_item, parent, false);

        return new ContactViewHolder(contactListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact currentContact = contacts.get(position);

        holder.contactListItemBinding.setContact(currentContact);
    }

    @Override
    public int getItemCount() {
        if(contacts != null){
            return contacts.size();
        }
        else {
            return 0;
        }
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;

        notifyDataSetChanged();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {

        private ContactListItemBinding contactListItemBinding;

        public ContactViewHolder(ContactListItemBinding contactListItemBinding) {
            super(contactListItemBinding.getRoot());
            this.contactListItemBinding = contactListItemBinding;
        }
    }
}

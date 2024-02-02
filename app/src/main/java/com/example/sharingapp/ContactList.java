package com.example.sharingapp;

import android.content.Context;

import java.util.ArrayList;

public class ContactList {

    private ArrayList<Contact> contacts;
    private String FILENAME;

    private static ArrayList<Contact> _contacts = new ArrayList<>();

    public ContactList() {
    }

    public ContactList(ArrayList<Contact> contacts, String FILENAME) {
        this.contacts = contacts;
        this.FILENAME = FILENAME;
    }

    public ArrayList<Contact> getContacts() {
        return contacts == null ? new ArrayList<>() : contacts;
    }

    public void setContacts(ArrayList<Contact> contact_list) {
        this.contacts = contact_list;
    }

    public String getFILENAME() {
        return FILENAME;
    }

    public void setFILENAME(String FILENAME) {
        this.FILENAME = FILENAME;
    }

    public ArrayList<String> getAllUsernames() {
        ArrayList<String> usernames = new ArrayList<>();
        for (int i = 0; i < this.contacts.size(); i++) {
            Contact contact = this.contacts.get(i);
            usernames.add(contact.getUsername());
        }

        return usernames;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void deleteContact(Contact contact) {
        contacts.remove(contact);
    }

    public Contact getContact(int index) {
        return this.contacts.get(index);
    }

    public int getSize() {
        return this.contacts.size();
    }

    public int getIndex(Contact contact) {
        return this.contacts.indexOf(contact);
    }

    public boolean hasContact(Contact contact) {
        return this.contacts.contains(contact);
    }

    public Contact getContactByUsername(String username) {
        for (int i = 0; i < this.contacts.size(); i++) {
            Contact contact = this.contacts.get(i);
            if (contact.getUsername().equals(username)) {
                return contact;
            }
        }

        return null;
    }

    public void loadContacts(Context context) {
        if (context != null) {
            contacts = new ArrayList<>();
            contacts.addAll(_contacts);
        }
    }

    public void saveContacts(Context context) {
        _contacts.clear();
        _contacts.addAll(contacts);
    }

    public boolean isUsernameAvailable(String username) {
        for (int i = 0; i < this.contacts.size(); i++) {
            Contact contact = this.contacts.get(i);
            if (contact.getUsername().equals(username)) {
                return false;
            }
        }

        return true;
    }


}

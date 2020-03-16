package com.company;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> contactList = new ArrayList<Contact>();

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.contactList = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact) {
        if(findContact(contact.getName()) >= 0){
            System.out.println("Contact is already on file");
            return false;
        }

        contactList.add(contact);
        return true;
    }

    private int findContact(Contact contact) {
        return this.contactList.indexOf(contact);
    }

    private int findContact(String contactName){
        for(int i=0; i < this.contactList.size(); i++) {
            Contact contact = this.contactList.get(i);
            if(contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int position = findContact(oldContact);
        if(position < 0) {
            System.out.println(oldContact.getName() + " was not found");
            return false;
        } else if(findContact(newContact.getName()) != -1) {
            System.out.println("Contact with name " + newContact.getName() + " already exists. Update was not successful.");
            return false;
        }
        this.contactList.set(position, newContact);
        System.out.println(oldContact.getName() + ", was replaced by " + newContact.getName());
        return true;
    }

    public boolean removeContact(Contact contact) {
        int position = findContact(contact);
        if(position < 0) {
            System.out.println(contact.getName() + " was not found");
            return false;
        }
        this.contactList.remove(position);
        System.out.println(contact.getName() + " was deleted");
        return true;
    }

    private int findItem(String searchItem){
        return contactList.indexOf(searchItem);
    }

    public boolean onFile(String searchItem) {
        int position = findItem(searchItem);
        if(position >= 0 ) {
            return true;
        }
        return false;
    }

    public Contact queryContact(String name) {
        int position = findContact(name);
        if(position >= 0) {
            return this.contactList.get(position);
        }

        return null;
    }

    public void printContactList() {
        if(contactList.size() > 0) {
            System.out.println("Contact List:");
            for (int i = 0; i < this.contactList.size(); i++) {
                System.out.println((i+1) + ". " +
                        this.contactList.get(i).getName() + " --> " +
                        this.contactList.get(i).getPhoneNumber());
            }
        } else {
            System.out.println("No contacts yet in your list");
        }
    }
}

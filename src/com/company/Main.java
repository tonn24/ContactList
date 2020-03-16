package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner s = new Scanner(System.in);
    private static MobilePhone mobilePhone= new MobilePhone("58093220");

    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        int choice = 0;
        printInstructions();
        while(!quit){
            System.out.println("Enter your choice: ");
            choice = s.nextInt();
            s.nextLine();
            switch(choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    mobilePhone.printContactList();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    quit = true;
                    break;

            }
        }

    }

    public static void printInstructions() {
        System.out.println("\nPress");
        System.out.println("\t 0 - To print choice options");
        System.out.println("\t 1 - To print list of contacts");
        System.out.println("\t 2 - To add new contact");
        System.out.println("\t 3 - To update existing contact");
        System.out.println("\t 4 - To remove contact");
        System.out.println("\t 5 - To search for an item to the list");
        System.out.println("\t 6 - To quit the application");
    }

    private static void startPhone() {
        System.out.println("Starting phone ...");
    }

    public static void addContact() {
        System.out.println("Please enter the contact name: ");
        String name = s.nextLine();
        System.out.println("Enter phone number: ");
        String phoneNumber = s.nextLine();
        Contact newContact = Contact.createContact(name, phoneNumber);
        if(mobilePhone.addNewContact(newContact)) {
            System.out.println("New contact added: " + name + ", phone = "+ phoneNumber);
        } else {
            System.out.println("Cannot add, " + name + " already on file");
        }
    }

    public static void updateContact() {
        System.out.println("Enter existing contact name: ");
        String name = s.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }

        System.out.println("Enter new contact name: ");
        String newName = s.nextLine();
        System.out.println("Enter new phone number: ");
        String newPhoneNumber = s.nextLine();
        Contact newContact = Contact.createContact(newName, newPhoneNumber);
        if(mobilePhone.updateContact(existingContactRecord, newContact)) {
            System.out.println("Successfully updated record");
        } else {
            System.out.println("Error updating record");
        }
    }

    public static void removeContact() {
        System.out.println("Enter contact name you want to remove");
        String name = s.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }
        if(mobilePhone.removeContact(existingContactRecord)) {
            System.out.println("Successfully deleted");
        } else {
            System.out.println("Error removing contact");
        }
    }

    public static void queryContact() {
        System.out.println("Enter contact name you want to find");
        String name = s.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }
        System.out.println(existingContactRecord.getName() + "'s phone number is " + existingContactRecord.getPhoneNumber());
    }

}

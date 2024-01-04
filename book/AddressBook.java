package book;

import book.Contact;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {
    private final Map<String, Contact> addressBook = new HashMap<>();
    final Scanner scanner = new Scanner(System.in);

    public void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();

        Contact contact = new Contact(name, phone);
        addressBook.put(name, contact);

        System.out.println("Contact added successfully!");
    }

    public void findContactByName() {
        System.out.print("Enter name to find: ");
        String name = scanner.nextLine();

        Contact contact = addressBook.get(name);
        if (contact != null) {
            System.out.println("Phone number for " + name + ": " + contact.getPhone());
        } else {
            System.out.println("Contact not found.");
        }
    }

    public void displayContacts() {
        System.out.println("Address Book");
        System.out.printf("%-15s %-15s\n", "Contact Name", "Phone number");
        System.out.println("-----------------------------");

        for (Map.Entry<String, Contact> entry : addressBook.entrySet()) {
            Contact contact = entry.getValue();
            System.out.printf("%-15s %-15s\n", contact.getName(), contact.getPhone());
        }
        System.out.println();
    }

    public void closeScanner() {
        scanner.close();
    }
}

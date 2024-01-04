package book;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {
    private final Map<String, Contact> addressBook = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);

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

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        int choice;

        do {
            System.out.println("Address Book Menu:");
            System.out.println("1. Add new contact");
            System.out.println("2. Find a contact by name");
            System.out.println("3. Display contacts");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = addressBook.scanner.nextInt();
            addressBook.scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addressBook.addContact();
                    break;
                case 2:
                    addressBook.findContactByName();
                    break;
                case 3:
                    addressBook.displayContacts();
                    break;
                case 4:
                    System.out.println("Exiting the Address Book. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 4);

        addressBook.closeScanner();
    }
}

package book;

public class Main {
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

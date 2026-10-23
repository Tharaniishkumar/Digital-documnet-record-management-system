import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DocumentManager manager = new DocumentManager();

        while (true) {
            System.out.println("\n===== DDRMS MENU =====");
            System.out.println("1. Add Document");
            System.out.println("2. View Documents");
            System.out.println("3. Search Document");
            System.out.println("4. Delete Document");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            // FIX: prevent crash if wrong input
            if (!sc.hasNextInt()) {
                System.out.println("Please enter numbers only!");
                sc.next(); // clear invalid input
                continue;
            }

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // clear buffer

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    System.out.print("Enter Date: ");
                    String date = sc.nextLine();

                    manager.addDocument(new Document(id, title, author, date));
                    break;

                case 2:
                    manager.viewDocuments();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    manager.searchDocument(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    manager.deleteDocument(sc.nextInt());
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
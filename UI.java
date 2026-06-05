
import database.LibraryDatabase;
import entity.User;
import facade.LibraryFacade;
import java.util.Scanner;

public class UI {
    public static void start() {
        LibraryFacade facade = new LibraryFacade(LibraryDatabase.getInstance());
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        System.out.println("Library Management System 1.0");

        while(running){
            System.out.println("Pick User Authority [ 1: Member, 2: Librarian, 0: Quit ]\n");
            int auth = sc.nextInt();
            if(auth == 0){
                running = false; 
                break;
            }
            else if(auth == 1){
                System.out.println("Pick what to manage [ 1: Book, 2: User, 3: Transaction, 0: Back ]\n");
                int cmd = sc.nextInt();

            } else {
                System.out.println("Enter First Name\n");
                String firstName = sc.nextLine();
                System.out.println("Enter Last Name\n");
                String lastName = sc.nextLine();
                User member = new User(firstName, lastName);
                while(true){
                    System.out.println("Pick what do you want to do [ 1: Borrow Book, 2: Return Book, 3: Reserve Book,  ]\n");
                }

            }
        }
    }
}

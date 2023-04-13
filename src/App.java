import java.util.Scanner;


public class App {
    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int userChoice;
        while (true) {
            
            printMenu();

            // Get the user choice
            System.out.print("OPTION >>> ");
            userChoice = keyboard.nextInt();
            System.out.println("\n");

            // User Choice Switch
            switch (userChoice) {
                case 1:
                System.out.println("[1]. Apply for the programming domain."); // register a participants
                break;
                case 2:
                System.out.println("[2]. Apply for the database domain."); // register a participants
                break;
                case 3:
                System.out.println("[3]. Apply for the network domain."); // register a participants
                break;
                case 0:
                    System.out.println("\n\n** Good Bye!!!\n\n");
                    return;
                default:
                    System.out.println("** Invalid Option. Please try again.");
                    break;
            }

            // System.out.print("\nEnter to Continue ...");
            // keyboard.nextLine();
            // System.out.print("\033[H\033[2J");
            // System.out.flush();

        }
    }

    private static void printMenu() {
        System.out.println("--------------------Welcome press to number for making a choice--------------------");
        System.out.println("[1]. Apply for the programming domain."); // register a participants
        System.out.println("[2]. Apply for the database domain."); // register a participants
        System.out.println("[3]. Apply for the network domain."); // register a participants
        System.out.println("[0]. Exit");
    }
}

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
                    System.out.println("[1]. Apply for the contest."); // register a participants
                    break;
                case 2:
                    System.out.println("[2]. Show all applicants.");
                    break;
                case 3:
                    System.out.println("[3]. Show applicant by specific domain.");
                    break;
                case 4:
                    System.out.println("[4]. View complete information of the laureate of laureates.");
                    break;
                case 5:
                    System.out.println("[5]. Show information of 5 first winners.");
                    break;
                case 6:
                    System.out.println("[6]. Remove the last 4 applicants according there  average.");
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
        System.out.println("[1]. Apply for the contest."); // register a participants
        System.out.println("[2]. Show all applicants.");
        System.out.println("[3]. Show applicant by specific domain.");
        System.out.println("[4]. View complete information of the laureate of laureates.");
        System.out.println("[5]. Show information of 5 first winners.");
        System.out.println("[6]. Remove the last 4 applicants according there  average.");
        System.out.println("[0]. Exit");
    }
}

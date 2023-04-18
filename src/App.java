import java.util.Scanner;

public class App {
    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        ProgrammingApplicants applicant = new ProgrammingApplicants();
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

                case 3:
                    System.out.println("[3]. Apply for the network domain."); // register a participants
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
                case 7:
                    System.out.println("[7]. Show applicant by specific domain.");
                    printMenu2();
                    int userChoice2 = keyboard.nextInt();
                    while (true) {
                        switch (userChoice2) {
                            case 1:
                                System.out.println("[1]. Show all applicant for the programming domain."); // register a

                                applicant.lister();
                                try {
                                    applicant.showAll();
                                } catch (Exception e) {
                                    System.out.println("Database Empty you need to register an Applicant!");
                                    // TODO: handle exception
                                }                                                                    // participants

                                break;
                            case 2:
                                System.out.println("[2]. Show all applicant for the database domain."); // register a
                                                                                                        // participants
                                break;
                            case 3:
                                System.out.println("[3]. Show all applicant for the network domain."); // register a
                                                                                                       // participants
                                break;
                            case 0:
                                System.out.println("\n\n** Previous.\n\n");
                                return;
                            default:
                                System.out.println("** Invalid Option. Please try again.");
                                break;
                        }

                    }
                    
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

    private static void printMenu2() {
        System.out.println("--------------------Welcome press to number for making a choice--------------------");
        System.out.println("[1]. Show all applicant for the programming domain."); // register a participants
        System.out.println("[2]. Show all applicant for the database domain."); // register a participants
        System.out.println("[3]. Show all applicant for the network domain."); // register a participants

    }

    private static void printMenu() {
        System.out.println("--------------------Welcome press to number for making a choice--------------------");
        System.out.println("[1]. Apply for the programming domain."); // register a participants
        System.out.println("[2]. Apply for the database domain."); // register a participants
        System.out.println("[3]. Apply for the network domain."); // register a participants
        System.out.println("[4].  View complete information of the laureate of laureates."); // show the laureate
        System.out.println("[5]. Show information of 5 first winners."); // 5 first best applicants
        System.out.println("[6]. Remove the last 4 applicants according there  average."); // four last applicants
        System.out.println("[7]. Show applicant by specific domain."); // show by specific domain
        System.out.println("[0]. Exit");
    }
}

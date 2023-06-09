<<<<<<< HEAD
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
=======
import java.util.ArrayList;
import java.util.Collections;
import java.lang.reflect.Constructor;

import services.Console;
import services.Repository;
import attendees.ProgramingAttendee;
import attendees.DBAttendee;
import attendees.NetworkAttendee;

public class App {
    public static void main(String[] args) throws Exception {
        String[] options = {
                "Enregistrer un candidat dans son fichier respectif.",
                "Afficher tous les candidats du concours sur les 3 domaines.",
                "Afficher la liste des candidatssuivant un domaine saisi par l'utilisateur.",
                "Afficher les informations complètes sur le lauréat des lauréats (plus grande moyenne obtenue parmi les candidats) du concours.",
                "Afficher les informations sur les 5 premierslauréats du concours",
                "Supprimer les 4 derniers candidats du concours en termes de leur moyenne obtenu",
                "Quitter"
        };

        int choice = 0;

        do {
            choice = Console.getChoice(options, null);

            switch (choice) {
                case 1:
                    saveCandidate();
                    break;
                case 2:
                    showCandidate("all");
                    break;
                case 3:
                    showCandidateByDomain();
                    break;
                case 4:
                    showBestofBest();
                    break;
                case 5:
                    showFiveBestCandidate();
                    break;
                case 6:
                    deleteFourLastCandidates();
                    break;
                case 7:
                    Console.print("Au revoir");
                    choice = 0;
                    break;
            }
            Console.pause();
            Console.clear();
        } while (choice != 0);

    }

    public static Class<?> getDomainClass(int domainInt) {
        switch (domainInt) {
            case 1:
                return ProgramingAttendee.class;
            case 2:
                return DBAttendee.class;
            case 3:
                return NetworkAttendee.class;
        }
        return null;
    }

    public static ArrayList<Object> getCandidates(String scope) throws Exception {
        ArrayList<Object> candidates = new ArrayList<Object>();

        if (scope.equalsIgnoreCase("all") || scope.equalsIgnoreCase("programing")) {
            candidates.addAll(ProgramingAttendee.fetchAll());
        }

        if (scope.equalsIgnoreCase("all") || scope.equalsIgnoreCase("db")) {
            candidates.addAll(DBAttendee.fetchAll());
        }

        if (scope.equalsIgnoreCase("all") || scope.equalsIgnoreCase("network")) {
            candidates.addAll(NetworkAttendee.fetchAll());
        }

        return candidates;
    }

    public static void saveCandidate() throws Exception {

        String name = "";
        String sex = "";

        String[] domainOptions = {
                "Programmation",
                "Base de données",
                "Réseau"
        };

        String[] sexOptions = {
                "Masculin",
                "Féminin",
        };

        name = Console.getString("Nom: ");

        int sexInt = Console.getChoice(sexOptions, "Sexe:");
        switch (sexInt) {
            case 1:
                sex = "Masculin";
                break;
            case 2:
                sex = "Féminin";
                break;
            default:
                break;
        }

        int domainInt = Console.getChoice(domainOptions, "Domaine:");

        double mark = Console.getDouble("Note " + domainOptions[domainInt - 1] + ": ");

        Class<?> cls = getDomainClass(domainInt);
        Constructor<?> constructor = cls.getConstructor(String.class, String.class, double.class);
        Object instance = constructor.newInstance(name, sex, mark);

        int nbQ = cls.getField("NB_QUESTIONS").getInt(instance);
        for (int i = 1; i <= nbQ; i++) {
            double coef = cls.getField("Q" + i + "_TOTAL_MARK").getDouble(instance);

            do {
                mark = Console.getDouble("Note Question " + i + ": ");
                if (mark > coef || mark < 0) {
                    Console.print("Note non valide, Réessayer !!!");
                }
            } while (mark > coef || mark < 0);

            cls.getMethod("setQuetionMark", int.class, double.class).invoke(instance, i, mark);
        }

        instance.getClass().getMethod("save").invoke(instance);

        Console.print("Candidat enregistré avec succès.");
    }

    private static void showCandidate(String scope) throws Exception {
        ArrayList<Object> candidates = getCandidates(scope);
        Console.printHeader("LISTE DES CANDIDATS");
        for (Object candidate : candidates) {
            Console.print("**** CANDIDAT " + (candidates.indexOf(candidate) + 1));
            Console.print(candidate.toString());
            Console.endl();
        }
    }

    private static void showCandidateByDomain() throws Exception {
        String[] domainOptions = {
                "Programmation",
                "Base de données",
                "Réseau"
        };

        int domainInt = Console.getChoice(domainOptions, "Domaine:");
        switch (domainInt) {
            case 1:
                showCandidate("programing");
                break;
            case 2:
                showCandidate("db");
                break;
            case 3:
                showCandidate("network");
                break;
        }
    }

    private static void showBestofBest() throws Exception {
        ArrayList<Object> candidates = getCandidates("all");

        Object bestCandidate = null;
        double bestMark = 0;

        for (Object candidate : candidates) {
            double mark = (double) candidate.getClass().getMethod("getAverage").invoke(candidate);
            if (mark > bestMark) {
                bestMark = mark;
                bestCandidate = candidate;
            }
        }

        Console.printHeader("LAUREAT DES LAUREATS");
        Console.print(bestCandidate.toString());
        Console.endl();
    }

    public static void showFiveBestCandidate() throws Exception {
        ArrayList<Object> candidates = getCandidates("all");

        Collections.sort(candidates, (a, b) -> {
            try {
                return Double.compare((double) b.getClass().getMethod("getAverage").invoke(b),
                        (double) a.getClass().getMethod("getAverage").invoke(a));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        int i = 0;
        while (i < 5 && i < candidates.size()) {
            Object candidate = candidates.get(i);
            Console.print("**** CANDIDAT " + (i + 1));
            Console.print(candidate.toString());
            Console.endl();
            i++;
        }
    }

    public static void deleteFourLastCandidates() throws Exception {
        ArrayList<Object> candidates = getCandidates("all");

        Collections.sort(candidates, (a, b) -> {
            try {
                return Double.compare((double) b.getClass().getMethod("getAverage").invoke(b),
                        (double) a.getClass().getMethod("getAverage").invoke(a));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        int i = 0;
        while (i < 4 && i < candidates.size()) {
            Object candidate = candidates.get(i);
            candidates.remove(candidate);
            i++;
        }
        Repository.refresh(candidates);

        Console.print("Suppression effectuée avec succès.");
>>>>>>> refs/remotes/origin/main
    }
}

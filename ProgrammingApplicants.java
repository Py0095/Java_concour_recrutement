import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

// import Utils.UniqueIDTest;

// import Utils.UniqueIDTest;

public class ProgrammingApplicants implements ConcourOperation<Applicant> {

    // Create all instance that i'll need.
    File file = new File("Database/ProgrammingApplicants.txt");
    FileWriter fileWriter = null;
    Applicant applicant = new Applicant(null, null, null, null);
    Scanner keyboard = new Scanner(System.in);
    Random r = new Random();
    // create the where i'm gonna to register all applicants
    static HashMap<String, Applicant> programmingArray = new HashMap<>();

    // method to register applicants
    @Override
    public Void registerApplicant() {
        // register applicant
        System.out.println("-----------Applicant infos-----------\n");
        System.out.println("Please Enter your name.\n[>..");
        applicant.setName(keyboard.nextLine());
        System.out.println(keyboard.nextLine());//debug
        System.out.println("Please Enter your sexe.\n[>..");

        String sexe = keyboard.nextLine();
        if (!sexe.toLowerCase().equals("masculin") && !sexe.toLowerCase().equals("feminin")){
            while(!sexe.toLowerCase().equals("masculin") && !sexe.toLowerCase().equals("feminin")){
                System.out.println("Invalid Sexe!!! Please enter a valid sexe.");
                sexe = keyboard.nextLine();
            }
        }
        applicant.setSexe(sexe);
        System.out.println(keyboard.nextLine());//debug
        String code = "H005" + r.nextInt(1000);
        applicant.setCode(code);
        applicant.setMoyApplicant(RegisterNote());

        try {
            fileWriter = new FileWriter(file, true);
            fileWriter.write(applicant.formatRegister());
            fileWriter.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        throw new UnsupportedOperationException("Unimplemented method 'registerApplicant'");
    }

    public int noteQuestion(int note, int coefficient) {
        if (note < 0 || note > coefficient) {
            while (note < 0 || note > 200) {
                System.out.println("Invalid note!!!");
                note = keyboard.nextInt();
            }
        }
            return note;
    }

    // this is a method to register all applicant note
    public double RegisterNote() {
        System.out.println("Put the note of the first question: ");
        int note1 = keyboard.nextInt();
        noteQuestion(note1,200);
        

        System.out.println("Put the note of the second question: ");
        int note2 = keyboard.nextInt();
        noteQuestion(note1,150);
      

        System.out.println("Put the note of the third question: ");
        int note3 = keyboard.nextInt();
        noteQuestion(note1,150);
        
        double moy = (note1 + note2 + note3) / 3;
        return moy;
    }

    // method to show all aplicant
    @Override
    public HashMap<String, Applicant> showAll() {
        String applicantTable[] = null;
        Scanner c2 = null;
        try {
            c2 = new Scanner(file);
            // parcourrir le fichier
            while (c2.hasNextLine()) {
                applicantTable = c2.nextLine().split("!");
                Applicant applicant = new Applicant(null, null, null, null);
                applicant.setCode(applicantTable[0]);
                applicant.setName(applicantTable[1]);
                applicant.setSexe(applicantTable[2]);
                applicant.setMoyApplicant(Double.parseDouble(applicantTable[3]));
                programmingArray.putIfAbsent(applicantTable[0], applicant);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        c2.close();
        return programmingArray;
    }

    public void lister() {
        for (Applicant vt : showAll().values()) {
            System.out.println(vt.toString2());
            System.out.println("---------------------------------------------");
        }
    }

    @Override
    public HashMap viewTheBest() {
        double max = 0;
        for (Applicant e : showAll().values()) {
            System.out.println(e);
            if (e.getMoyApplicant() > max) {
                
            }

        }

        // String applicantTable[] = null;

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'viewTheBest'");
    }

    @Override
    public HashMap showFiveFirst() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showFiveFirst'");
    }

    @Override
    public void removeTheLastForth(String code) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeTheLastForth'");
    }

    @Override
    public void searchApplicant(String code) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchApplicant'");
    }

    @Override
    public HashMap<String, Applicant> showByDomain() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showByDomain'");
    }

    //
    public static void main(String[] args) throws Exception {
        try (Scanner keyboard2 = new Scanner(System.in)) {
            int userChoice;

            while (true) {

                printMenu();

                // Get the user choice
                System.out.print("OPTION >>> ");
                userChoice = keyboard2.nextInt();
                System.out.println("\n");
                ProgrammingApplicants applicant = new ProgrammingApplicants();

                // User Choice Switch
                switch (userChoice) {
                    case 1:
                        System.out.println("[1]. Apply for the contest."); // register a participants

                        applicant.registerApplicant();
                        break;
                    case 2:
                        System.out.println("[2]. Show all applicants.\n");
                        applicant.lister();
                        try {
                            applicant.showAll();
                        } catch (Exception e) {
                            System.out.println("Database Empty you need to register an Applicant!");
                            // TODO: handle exception
                        }
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
    }

    private static void printMenu() {
        System.out.println("--------------------Welcome press to number for making a choice--------------------");
        System.out.println("[1]. Apply for the contest."); // register a participants
        // System.out.println("[2]. Show all applicants.");
        // System.out.println("[3]. Show applicant by specific domain.");
        // System.out.println("[4]. View complete information of the laureate of
        // laureates.");
        // System.out.println("[5]. Show information of 5 first winners.");
        // System.out.println("[6]. Remove the last 4 applicants according there
        // average.");
        System.out.println("[0]. Exit");
    }
}

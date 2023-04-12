import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

// import Utils.UniqueIDTest;

// import Utils.UniqueIDTest;

public class ProgrammingApplicants implements ConcourOperation<Applicant> {

    // create the where i'm gonna to register all applicants
    File file = new File("ProgrammingApplicants.txt");
    FileWriter fileWriter = null;
    Applicant applicant = new Applicant(null, null, null);
    Scanner keyboard = new Scanner(System.in);
    Random r = new Random();
    static HashMap<String, Applicant> programmingArray = new HashMap<>();

    @Override
    public Void registerApplicant() {
        // register applicant
        System.out.println("-----------Applicant ifos-----------\n");
        System.out.println("Please Enter your name");
        applicant.setName(keyboard.nextLine());
        System.out.println("Please Enter your sexe");
        applicant.setName(keyboard.nextLine());
        String code = "H005" + r.nextInt();
        applicant.setCode(code);

        try {
            fileWriter = new FileWriter(file, true);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        throw new UnsupportedOperationException("Unimplemented method 'registerApplicant'");
    }




    @Override
    public HashMap<String,Applicant> showAll() {
        

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showAll'");
    }

    @Override
    public HashMap showByDomain() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showByDomain'");
    }

    @Override
    public HashMap viewTheBest() {
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

}

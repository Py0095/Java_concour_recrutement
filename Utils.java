import java.util.UUID;

public class Utils {

    public static void ClearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static UUID UniqueIDTest(String[] args) {
        UUID uniqueKey = UUID.randomUUID();
        // System.out.println(uniqueKey);
        return uniqueKey;
    }


   

}

import java.util.HashMap;

public interface ConcourOperation<T> {

    Void registerApplicant();

    HashMap<String, T> showAll();

    HashMap<String, T> showByDomain();

    HashMap<String, T> viewTheBest();

    HashMap<String, T> showFiveFirst();

    void removeTheLastForth(String code);

    void searchApplicant(String code);
}

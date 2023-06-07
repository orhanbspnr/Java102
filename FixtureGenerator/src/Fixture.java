import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.TreeSet;

public class Fixture {
    LinkedHashSet<String> home = new LinkedHashSet<>();
    LinkedHashSet<String> away = new LinkedHashSet<>();
    Random random = new Random();

    public void fixtures(TreeSet<String> matches){
        for (int i = 0; i < matches.size(); i++) {
            home.add((String) matches.toArray()[i]);
        }

        for (int i = 0; i < (matches.size()/2); i++) {
            int rand1 = random.nextInt(0, home.size());
            away.add((String) home.toArray()[rand1]);
            home.remove((String) home.toArray()[rand1]);

        }

        away.add(null);

        for (int i = 0; i < home.size(); i++) {
            if (away.toArray()[i] != null) {
                System.out.println(home.toArray()[i] + " vs " + away.toArray()[i]);
            }
            else {
                System.out.println(home.toArray()[i] + " vs " + "BAY");
            }
        }
    }
}


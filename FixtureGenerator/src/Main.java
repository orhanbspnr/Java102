import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("----- Teams -----");
        TreeSet<String> teams = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        teams.add("Galatasaray");
        teams.add("Bursaspor");
        teams.add("Fenerbahçe");
        teams.add("Beşiktaş");
        teams.add("Başakşehir");
        teams.add("Trabzonspor");

        for (String print: teams) {
            System.out.println(print);
        }
        System.out.println("----- Fixtures -----");
        Fixture fixture = new Fixture();
        fixture.fixtures(teams);

    }
}
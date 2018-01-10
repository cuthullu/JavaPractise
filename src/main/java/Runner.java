import java.util.Arrays;
import java.util.HashSet;

public class Runner {

    public static void main(String[] args) {
        String missing = findMissing("the quick brown fox  over the lazy dog");
        System.out.println(missing);

    }

    static String alphalbet = "abcdefghijklmnoppqrstuvwxyz";

    public static String findMissing(String input) {
        HashSet<String> found = new HashSet<String>();
        HashSet<String> missing = new HashSet<String>();

        String[] letters = input.split("");
        found.addAll(Arrays.asList(letters));


        for(String l: alphalbet.split("")) {
            if(!found.contains(l)) {
                missing.add(l);
            }
        }

        return String.join("",missing);
    }
}

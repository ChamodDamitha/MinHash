/**
 * Created by chamod on 8/7/17.
 */
public class Main {
    public static void main(String[] args) {
        MinHash<String> stringMinHash = new MinHash<String>(4);

        String[] firstSet = {"a", "b", "c", "d"};
        String[] secondSet = {"a", "a", "a", "a"};

        for (int i = 0; i < 4; i++) {
            stringMinHash.addProperty(firstSet[i], secondSet[i]);
        }

        System.out.println("similarity : " + stringMinHash.getSimilarity());
    }
}

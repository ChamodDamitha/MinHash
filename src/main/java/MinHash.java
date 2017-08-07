/**
 * Created by chamod on 8/6/17.
 */
public class MinHash<E> {
    private int a;
    private int b;

    private int noOfHashFunctions;
    private int[] firstMinHashValues;
    private int[] secondMinHashValues;

    public MinHash(int noOfHashFunctions) {
        this.noOfHashFunctions = noOfHashFunctions;
        firstMinHashValues = new int[noOfHashFunctions];
        secondMinHashValues = new int[noOfHashFunctions];

//      set max int value in the hash value set
        for (int i = 0; i < noOfHashFunctions; i++) {
            firstMinHashValues[i] = Integer.MAX_VALUE;
            secondMinHashValues[i] = Integer.MAX_VALUE;
        }

//      calculate a and b values
        a = 23;
        b = 7;
    }

    public boolean addProperty(E firstSet, E secondSet) {
        int[] firstHashValues = getHashValues(firstSet);
        int[] secondHashValues = getHashValues(secondSet);

        int tempFirstMinHash;
        int tempFirstHash;
        int tempSecondMinHash;
        int tempSecondHash;

        for (int i = 0; i < noOfHashFunctions; i++) {
            tempFirstMinHash = firstMinHashValues[i];
            tempFirstHash = firstHashValues[i];
            tempSecondMinHash = secondMinHashValues[i];
            tempSecondHash = secondHashValues[i];

            if (tempFirstHash < tempFirstMinHash) {
                firstMinHashValues[i] = tempFirstHash;
            }
            if (tempSecondHash < tempSecondMinHash) {
                secondMinHashValues[i] = tempSecondHash;
            }
        }
        return true;
    }

    private int[] getHashValues(E item) {

    }

    public double getSimilarity() {
        int noOfSimilarities = 0;
        for (int i = 0; i < noOfHashFunctions; i++) {
            if (firstMinHashValues[i] == secondMinHashValues[i]) {
                noOfSimilarities++;
            }
        }
        return (double)noOfSimilarities / noOfHashFunctions;
    }
}

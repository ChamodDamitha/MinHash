import java.util.Random;

/**
 * Created by chamod on 8/6/17.
 */
public class MinHash<E> {
    private int noOfHashFunctions;
    private int noOfSimilarities;

    private int[] firstMinHashValues;
    private int[] secondMinHashValues;

    public MinHash(int noOfHashFunctions) {
        this.noOfSimilarities = 0;
        this.noOfHashFunctions = noOfHashFunctions;
        firstMinHashValues = new int[noOfHashFunctions];
        secondMinHashValues = new int[noOfHashFunctions];

//      set max int value in the hash value set
        for (int i = 0; i < noOfHashFunctions; i++) {
            firstMinHashValues[i] = Integer.MAX_VALUE;
            secondMinHashValues[i] = Integer.MAX_VALUE;
        }
    }

    public boolean addProperty(E firstSet, E secondSet) {
        int[][] hashValues = getHashValues(firstSet, secondSet, noOfHashFunctions);
        int[] firstHashValues = hashValues[0];
        int[] secondHashValues = hashValues[1];

        int tempFirstMinHash;
        int tempFirstHash;
        int tempSecondMinHash;
        int tempSecondHash;

        noOfSimilarities = 0;

        for (int i = 0; i < noOfHashFunctions; i++) {
            tempFirstMinHash = firstMinHashValues[i];
            tempFirstHash = firstHashValues[i];
            tempSecondMinHash = secondMinHashValues[i];
            tempSecondHash = secondHashValues[i];

//          Update the minimum hash values
            if (tempFirstHash < tempFirstMinHash) {
                firstMinHashValues[i] = tempFirstHash;
            }
            if (tempSecondHash < tempSecondMinHash) {
                secondMinHashValues[i] = tempSecondHash;
            }
//          Check for similar hash values
            if (firstMinHashValues[i] == secondMinHashValues[i]) {
                noOfSimilarities++;
            }
        }
        return true;
    }

    public double getSimilarity() {
        return (double) noOfSimilarities / noOfHashFunctions;
    }


    public int[][] getHashValues(E item1, E item2, int count) {
        int[] firstHashCodes = new int[count];
        int[] secondHashCodes = new int[count];
        int machineWordSize = Integer.SIZE;
        int hashCodeSize = machineWordSize / 2;
        int hashCodeSizeDiff = machineWordSize - hashCodeSize;
        int hstart1 = item1.hashCode();
        int hstart2 = item2.hashCode();
        int tempRandomInt;
//        int bmax = 1 << hashCodeSizeDiff;
        Random rnd = new Random();

        for (int i = 0; i < count; i++) {
            tempRandomInt = rnd.nextInt();
            firstHashCodes[i] = ((hstart1 * (i * 2 + 1)) + tempRandomInt) >> hashCodeSizeDiff;
            secondHashCodes[i] = ((hstart2 * (i * 2 + 1)) + tempRandomInt) >> hashCodeSizeDiff;
        }
        return new int[][]{firstHashCodes, secondHashCodes};
    }
}

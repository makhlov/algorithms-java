import java.util.Arrays;

/**
 * <h1>DeleteDuplicates</h1>
 * The DeleteDuplicates class contains method implementations
 * for delete duplicates from set
 *
 * @author Makhlov Egor
 * @version 1.0
 * @since 2020-11-25
 */
public class DeleteDuplicates {
    private DeleteDuplicates() {
    }

    /**
     * The method is used to remove duplicates from a set.
     * A concrete implementation is available since Java 8
     *
     * @param inputArray array with duplicate elements
     * @return array without duplicate elements
     */
    public static int[] deleteFromArrayUsingStream(int[] inputArray) {
        return Arrays.stream(inputArray).distinct().toArray();
    }
}
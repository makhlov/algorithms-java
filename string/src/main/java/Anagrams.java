import java.util.Arrays;

/**
 * <h1>Anagrams</h1>
 * Anagrams class contains various implementations
 * of methods for checking whether a string is an anagram
 *
 * @author Makhlov Egor
 * @version 1.0
 * @since 2020-12-04
 */
public final class Anagrams {

    private Anagrams() {

    }

    /**
     * The method used to check if one string is an anagram to another
     *
     * @param firstInputStr  first string
     * @param secondInputStr second string
     * @return Return {@code true} if input string is anagrams, else return {@code false}
     */
    public static boolean isAnagramsSort(String firstInputStr, String secondInputStr) {
        firstInputStr = stringPreparation(firstInputStr);
        secondInputStr = stringPreparation(secondInputStr);

        if (firstInputStr.length() != secondInputStr.length()) {
            return false;
        }

        char[] charArr1 = firstInputStr.toCharArray();
        char[] charArr2 = secondInputStr.toCharArray();
        Arrays.sort(charArr1);
        Arrays.sort(charArr2);
        return Arrays.equals(charArr1, charArr2);
    }

    /**
     * The method used to check if one string is an anagram to another
     *
     * @param firstInputStr  first string
     * @param secondInputStr second string
     * @return Return {@code true} if input string is anagrams, else return {@code false}
     */
    public static boolean isAnagramsCountingCharLoop(String firstInputStr, String secondInputStr) {
        firstInputStr = stringPreparation(firstInputStr);
        secondInputStr = stringPreparation(secondInputStr);

        if (firstInputStr.length() != secondInputStr.length()) {
            return false;
        }

        int sum = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < firstInputStr.length(); i++) {
                if (firstInputStr.charAt(i) == ch) {
                    sum++;
                }
                if (secondInputStr.charAt(i) == ch) {
                    sum--;
                }
            }
            if (sum != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * The method used to check if one string is an anagram to another
     *
     * @param firstInputStr  first string
     * @param secondInputStr second string
     * @return Return {@code true} if input string is anagrams, else return {@code false}
     */
    public static boolean isAnagramCounting(String firstInputStr, String secondInputStr) {
        firstInputStr = stringPreparation(firstInputStr);
        secondInputStr = stringPreparation(secondInputStr);

        if (firstInputStr.length() != secondInputStr.length()) {
            return false;
        }

        int charRange = 256;

        int[] count = new int[charRange];
        for (int i = 0; i < firstInputStr.length(); i++) {
            count[firstInputStr.charAt(i)]++;
            count[secondInputStr.charAt(i)]--;
        }

        for (int i = 0; i < charRange; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * The method is used to remove excess spaces from a string and convert it to lowercase
     *
     * @param inputStr Some string to check for palindrome
     * @return Return {@code true} if input string is palindrome, else return {@code false}
     */
    private static String stringPreparation(String inputStr) {
        return inputStr.replaceAll("\\s+", "").toLowerCase();
    }
}

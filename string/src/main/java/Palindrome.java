/**
 * <h1>Palindrome</h1>
 * The Palindrome class contains various implementations
 * of methods for checking a string against a palindrome
 *
 * @author Makhlov Egor
 * @version 1.0
 * @since 2020-11-20
 */
public final class Palindrome {

    private Palindrome() {
    }

    /**
     * The method is used to check a number for a palindrome
     *
     * @param num Some integer value to check for palindrome
     * @return Return {@code true} if input string is palindrome, else return {@code false}
     */
    public static boolean isPalindromeNumber(int num) {
        int original = num;
        int sum = 0;

        while (num > 0) {
            sum = (sum * 10) + num % 10;
            num = num / 10;
        }
        return original == sum;
    }

    /**
     * The method is used to check a string for a palindrome
     *
     * @param inputStr Some string to check for palindrome
     * @return Return {@code true} if input string is palindrome, else return {@code false}
     */
    public static boolean isPalindromeUsingStringBuilder(String inputStr) {
        if (inputStr == null || inputStr.isEmpty()) {
            return false;
        }

        inputStr = stringPreparation(inputStr);

        StringBuilder sB = new StringBuilder(inputStr);
        return inputStr.equals(sB.reverse().toString());
    }

    /**
     * The method is used to check a string for a palindrome
     *
     * @param inputStr Some string to check for palindrome
     * @return Return {@code true} if input string is palindrome, else return {@code false}
     */
    public static boolean isPalindromeNativeFor(String inputStr) {
        if (inputStr == null || inputStr.length() <= 1) {
            return false;
        }

        inputStr = stringPreparation(inputStr);

        for (int i = 0, j = inputStr.length() - 1; i < j; i++, --j) {
            if (inputStr.charAt(i) != inputStr.charAt(j)) return false;
        }
        return true;
    }

    /**
     * The method is used to check a string for a palindrome
     *
     * @param inputStr Some string to check for palindrome
     * @return Return {@code true} if input string is palindrome, else return {@code false}
     */
    public static boolean isPalindromeNativeWhile(String inputStr) {
        if (inputStr == null || inputStr.length() <= 1) {
            return false;
        }

        inputStr = stringPreparation(inputStr);

        int i = 0, j = inputStr.length() - 1;
        while (i < j) {
            if (inputStr.charAt(i) != inputStr.charAt(j)) {
                return false;
            }
            i++;
            --j;
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
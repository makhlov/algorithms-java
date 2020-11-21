import java.util.StringTokenizer;

/**
 * <h1>WordCount</h1>
 * The WordCount class contains method implementations
 * for words counting in input string
 *
 * @author Makhlov Egor
 * @version 1.0
 * @since 2020-11-21
 */
public final class WordCount {

    private WordCount() {
    }

    /**
     * The method is used to count words in the input string
     *
     * @param inputStr Some string in which you want to count the number of words
     * @return The number of words in string
     */
    public static int getWordCountSplitInArray(String inputStr) {
        if (inputStr == null || inputStr.isEmpty()) {
            return 0;
        }

        return inputStr.trim().split("\\s+").length;
    }

    /**
     * The method is used to count words in the input string
     *
     * @param inputStr Some string in which you want to count the number of words
     * @return The number of words in string
     */
    public static int getWordCountViaStringTokenizer(String inputStr) {
        if (inputStr == null || inputStr.isEmpty()) {
            return 0;
        }

        StringTokenizer strTokenizer = new StringTokenizer(inputStr);
        return strTokenizer.countTokens();
    }

    /**
     * The method is used to count words in the input string
     *
     * @param inputStr Some string in which you want to count the number of words
     * @return The number of words in string
     */
    public static int getWordNativeWithoutSpecialSymbol(String inputStr) {
        if (inputStr == null || inputStr.isEmpty()) {
            return 0;
        }

        int wordCount = 0;
        boolean isWord = false;
        int endOfString = inputStr.length() - 1;
        char[] characters = inputStr.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            if (Character.isLetter(characters[i]) && i != endOfString) {
                isWord = true;
            } else if (!Character.isLetter(characters[i]) && isWord) {
                wordCount++;
                isWord = false;
            } else if (Character.isLetter(characters[i]) && i == endOfString) {
                wordCount++;
            }
        }
        return wordCount;
    }

    /**
     * The method is used to count words in the input string
     *
     * @param inputStr Some string in which you want to count the number of words
     * @return The number of words in string
     */
    public static int getWordNativeWithSpecialSymbol(String inputStr) {
        if (inputStr == null || inputStr.isEmpty()) {
            return 0;
        }

        int wordCount = 0;
        boolean isWord = false;
        int endOfString = inputStr.length() - 1;
        char[] characters = inputStr.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            if (!Character.isWhitespace(characters[i]) && i != endOfString) {
                isWord = true;
            } else if (Character.isWhitespace(characters[i]) && isWord) {
                wordCount++;
                isWord = false;
            } else if (!Character.isWhitespace(characters[i]) && i == endOfString) {
                wordCount++;
            }
        }
        return wordCount;
    }
}
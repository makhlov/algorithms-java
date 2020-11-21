import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class WordCountTest {

    private final String input;
    private final int expected;

    public WordCountTest(String input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: wordCount-func's")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"aaaaa", 1},
                {"asdasd as da sd", 4},
                {"   asd asd     ad ", 3},
                {"    a     s  d asdas  aas ddad   sad", 7},
                {null, 0},
                {"", 0}
        });
    }

    @Test
    public void getWordCountSplitInArray() {
        assertThat(WordCount.getWordCountSplitInArray(input), is(equalTo(expected)));
    }

    @Test
    public void getWordCountViaStringTokenizer() {
        assertThat(WordCount.getWordCountViaStringTokenizer(input), is(equalTo(expected)));
    }

    @Test
    public void getWordNativeWithoutSpecialSymbol() {
        assertThat(WordCount.getWordNativeWithoutSpecialSymbol(input), is(equalTo(expected)));
    }

    @Test
    public void getWordNativeWithSpecialSymbol() {
        assertThat(WordCount.getWordNativeWithSpecialSymbol(input), is(equalTo(expected)));
    }
}
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class AnagramsTest {

    private final String inputFirst;
    private final String inputSecond;
    private final boolean expected;

    public AnagramsTest(String inputFirst, String inputSecond, boolean expected) {
        this.inputFirst = inputFirst;
        this.inputSecond = inputSecond;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: anagrams-func's")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"anagram", "margana", true},
                {"anaGram", "maRgana", true},
                {"an a   gra m", "mar g ana", true},
                {"anagram  m", "marg  anaa", false},
                {"anag ramm", "marga   naa", false}
        });
    }

    @Test
    public void isAnagramsSort() {
        assertThat(Anagrams.isAnagramsSort(inputFirst, inputSecond), is(equalTo(expected)));
    }

    @Test
    public void isAnagramsCountingCharLoop() {
        assertThat(Anagrams.isAnagramsCountingCharLoop(inputFirst, inputSecond), is(equalTo(expected)));
    }

    @Test
    public void isAnagramCounting() {
        assertThat(Anagrams.isAnagramCounting(inputFirst, inputSecond), is(equalTo(expected)));
    }
}
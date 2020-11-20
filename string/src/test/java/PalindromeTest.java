import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class PalindromeTest {

    private final String input;
    private final boolean expected;

    public PalindromeTest(String input, boolean expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: palindrom-func's({0})={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"   a aa a", true},
                {" aa ba a", true},
                {" @!a  a aa!@", true},
                {"  a b  bc", false},
                {"", false},
                {null, false}
        });
    }

    @Test
    public void isPalindromeNumber() {
        /*
         * The function is somewhat out of place (int as input), and I cannot apply the same parameters to it for testing.
         * Later, when I learn how to create multiple sets, I'll fix that.
         */
        assertThat(Palindrome.isPalindromeNumber(111), is(equalTo(true)));
        assertThat(Palindrome.isPalindromeNumber(112), is(equalTo(false)));
    }

    @Test
    public void isPalindromeUsingStringBuilder() {
        assertThat(Palindrome.isPalindromeUsingStringBuilder(input), is(equalTo(expected)));
    }

    @Test
    public void isPalindromeNativeFor() {
        assertThat(Palindrome.isPalindromeNativeFor(input), is(equalTo(expected)));
    }

    @Test
    public void isPalindromeNativeWhile() {
        assertThat(Palindrome.isPalindromeNativeWhile(input), is(equalTo(expected)));
    }
}
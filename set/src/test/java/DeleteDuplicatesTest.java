import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class DeleteDuplicatesTest {

    private final int[] input;
    private final int[] expected;

    public DeleteDuplicatesTest(int[] input, int[] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: delete-dup-func's")
    public static Collection<Object[]> data() {
        return Arrays.asList(new int[][][]{
                {{1, 2, 2, 3}, {1, 2, 3}},
                {{1, 2, 3, 2, 1}, {1, 2, 3}},
                {{5, 5, 5, 5}, {5}},
                {{4, 1, 5, 4}, {4, 1, 5}}
        });
    }

    @Test
    public void deleteFromArrayUsingStream() {
        assertThat(DeleteDuplicates.deleteDuplicatesFromArrayUsingStream(input), is(equalTo(expected)));
    }
}
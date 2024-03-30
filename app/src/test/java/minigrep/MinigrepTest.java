package minigrep;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class MinigrepTest {
    @Test
    public void caseSensitive() {
        String query = "duct";
        String contents = """
                Rust:
                safe, fast, productive.
                Pick three.
                Duct tape.
                """;
        String[] expected = { "safe, fast, productive." };

        var results = Minigrep.search(query, contents);
        assertArrayEquals(expected, results);
    }

    @Test
    public void caseInsensitive() {
        String query = "rUsT";
        String contents = """
                Rust:
                safe, fast, productive.
                Pick three.
                Trust me.
                """;
        String[] expected = { "Rust:", "Trust me." };

        var results = Minigrep.searchCaseInsensitive(query, contents);
        assertArrayEquals(expected, results);
    }

}

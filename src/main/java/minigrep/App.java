package minigrep;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        Config config = null;
        try {
            config = Config.parse(args);
        } catch (java.lang.ArrayIndexOutOfBoundsException ex) {
            var err = String.format("Problem parsing arguments: %s", ex.getMessage());
            System.err.println(err);
            System.exit(1);
        }

        try {
            Minigrep.run(config);
        } catch (IOException ex) {
            var err = String.format("Application error: %s", ex.getMessage());
            System.err.println(err);
            System.exit(1);
        }
    }
}

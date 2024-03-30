package minigrep;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Minigrep {
    public static void run(Config config) throws IOException {
        String contents = Files.readString(Paths.get(config.file_path));
        if (config.ignore_case) {
            for (String line : searchCaseInsensitive(config.query, contents)) {
                System.out.println(line);
            }
        } else {
            for (String line : search(config.query, contents)) {
                System.out.println(line);
            }
        }
    }

    public static String[] search(String query, String contents) {
        ArrayList<String> results = new ArrayList<>();
        for (String line : contents.split("\\n")) {
            if (line.contains(query)) {
                results.add(line);
            }
        }
        return results.toArray(new String[0]);
    }

    public static String[] searchCaseInsensitive(String query, String contents) {
        ArrayList<String> results = new ArrayList<>();

        var lowerCaseQuery = query.toLowerCase();

        for (String line : contents.split("\\n")) {
            if (line.toLowerCase().contains(lowerCaseQuery)) {
                results.add(line);
            }
        }
        return results.toArray(new String[0]);
    }
}
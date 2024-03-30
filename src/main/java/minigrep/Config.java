package minigrep;

public class Config {
    public String query;
    public String file_path;
    public boolean ignore_case;

    public static Config parse(String[] args) throws ArrayIndexOutOfBoundsException {
        var query = args[0];
        var file_path = args[1];

        String value = System.getenv("IGNORE_CASE");
        boolean ignore_case = value != null;

        return new Config(query, file_path, ignore_case);
    }

    private Config(String query, String file_path, boolean ignore_case) {
        this.query = query;
        this.file_path = file_path;
        this.ignore_case = ignore_case;
    }
}

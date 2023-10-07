package FileManager;

import java.util.HashMap;
import java.util.List;

public class File {
    HashMap<String, Object> file;
    String name;
    String type;
    static List<String> allowedTypes = List.of(new String[]{"bin", "txt"});

    public File(String name, String type) throws IllegalArgumentException {
        if (allowedTypes.contains(type)) {
            file = new HashMap<>();
            file.put(name, null);
            this.name = name;
            this.type = type;
        } else {
            throw new IllegalArgumentException("The file type must be 'bin' or 'txt'.");
        }
    }
}

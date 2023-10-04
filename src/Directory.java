import java.util.ArrayList;
import java.util.HashMap;

public class Directory {
    HashMap<String, ArrayList<Object>> dir;
    String name;

    public Directory(String name) {
        this.name = name;
        dir = new HashMap<>();
        dir.put(name, new ArrayList<>());
    }

    public int newDirectory(String name) {
        for (Object element : dir.get(this.name)) {
            if (element instanceof Directory && ((Directory) element).name.equals(name))
                return -1;
        }

        dir.get(this.name).add(new Directory(name));
        return 0;
    }

    public void removeElement(String name) {

    }
}

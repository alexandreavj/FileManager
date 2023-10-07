package FileManager;

import java.util.ArrayList;
import java.util.HashMap;

public class Directory {
    HashMap<String, ArrayList<Object>> dir;
    String name;

    public Directory() {
        this("name");
    }

    public Directory(String name) {
        this.name = name;
        dir = new HashMap<>();
        dir.put(name, new ArrayList<>());
    }

    public void openDirectory() {
        if (!dir.get(name).isEmpty()) {
            System.out.printf("[] %s\n", name);
            for (Object element : dir.get(name)) {
                if (element instanceof Directory) {
                    System.out.printf("--> [] %s\n", ((Directory) element).name);
                } else if (element instanceof File) {
                    System.out.printf("--> # %s (%s file)\n", ((File) element).name, ((File) element).type);
                }
            }
        } else {
            System.out.printf("[] %s\n", name);
            System.out.println("This folder is empty.");
        }
    }

    public Directory newDirectory(String name) {
        for (Object element : dir.get(this.name)) {
            if (element instanceof Directory && ((Directory) element).name.equals(name))
                return null;
        }

        Directory newDir = new Directory(name);
        dir.get(this.name).add(newDir);
        return newDir;
    }

    public File newFile(String name, String type) {
        if (File.allowedTypes.contains(type)) {
            File newFile = new File(name, type);
            dir.get(this.name).add(newFile);
            return newFile;
        } else {
            return null;
        }
    }

    public int removeElement(String name, String type) {
        boolean isFound = false;
        for (Object element : dir.get(this.name)) {
            if ((element instanceof Directory && ((Directory) element).name.equals(name)) || (element instanceof File && ((File) element).name.equals(name))) {
                isFound = true;
                break;
            }
        }

        if (isFound) {

        } else {
            return -1;
        }
    }
}

package FileManager;

public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        File newFile = root.newFile("test", "txt");
        Directory docs = root.newDirectory("docs");
        root.openDirectory();
        docs.openDirectory();
    }
}
import java.io.File;
import java.io.IOException;
public class FileHandler {
    public FileHandler(String path) throws IOException {
        File f = new File(path);
        if (!f.exists()) throw new IOException("File missing: " + path);
    }
    public static void main(String[] args) {
        try {
            new FileHandler("no_such_file.txt");
        } catch (IOException e) {
            System.out.println("Constructor error: " + e.getMessage());
        }
    }
}

import java.io.Serializable;

class BackupData implements Serializable {
    String data = "Backup content";
}

public class Main13 {
    public static void main(String[] args) {
        BackupData b = new BackupData();
        System.out.println("Serializable object created");
    }
}

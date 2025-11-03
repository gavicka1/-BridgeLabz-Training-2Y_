interface Exporter {
    void exportToCSV();
    void exportToPDF();
    default void exportToJSON() { System.out.println("Exported to JSON"); }
}

class Report implements Exporter {
    public void exportToCSV() { System.out.println("Exported to CSV"); }
    public void exportToPDF() { System.out.println("Exported to PDF"); }
}

public class Main11 {
    public static void main(String[] args) {
        Report r = new Report();
        r.exportToCSV();
        r.exportToJSON();
    }
}

import java.util.*;
import java.util.stream.Collectors;

class Invoice {
    String transactionId;
    Invoice(String id) { transactionId = id; }
}

public class Main6 {
    public static void main(String[] args) {
        List<String> ids = Arrays.asList("TXN101", "TXN102", "TXN103");
        List<Invoice> invoices = ids.stream().map(Invoice::new).collect(Collectors.toList());
        invoices.forEach(i -> System.out.println(i.transactionId));
    }
}

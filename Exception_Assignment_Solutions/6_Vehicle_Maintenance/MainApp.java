import veh.MaintenanceTracker;
import veh.ServiceOverdueException;
import veh.InvalidMileageException;
import java.time.LocalDate;
public class MainApp {
    public static void main(String[] args) {
        MaintenanceTracker m = new MaintenanceTracker();
        try {
            m.checkMaintenance(LocalDate.now().minusDays(5), 12000);
        } catch (InvalidMileageException e) {
            System.out.println("Mileage error: " + e.getMessage());
        } catch (ServiceOverdueException e) {
            System.out.println("Service alert: " + e.getMessage());
        }
    }
}

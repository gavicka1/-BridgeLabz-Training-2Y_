package veh;
import java.time.LocalDate;
public class MaintenanceTracker {
    public void checkMaintenance(LocalDate serviceDate, int mileage) throws ServiceOverdueException, InvalidMileageException {
        if (mileage < 0) throw new InvalidMileageException("Invalid mileage: " + mileage);
        if (serviceDate.isBefore(LocalDate.now())) throw new ServiceOverdueException("Service overdue since: " + serviceDate);
        System.out.println("Vehicle is OK. Next service: " + serviceDate);
    }
}

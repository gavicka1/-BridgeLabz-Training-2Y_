import java.util.ArrayList;
import java.util.List;

abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    public Patient(String patientId,String name,int age){setPatientId(patientId);setName(name);setAge(age);}
    public String getPatientId(){return patientId;}
    public void setPatientId(String id){if(id==null||id.isEmpty()) throw new IllegalArgumentException(); this.patientId=id;}
    public String getName(){return name;}
    public void setName(String n){if(n==null||n.isEmpty()) throw new IllegalArgumentException(); this.name=n;}
    public int getAge(){return age;}
    public void setAge(int a){if(a<0) throw new IllegalArgumentException(); this.age=a;}
    public abstract double calculateBill();
    public String getPatientDetails(){return "ID:"+getPatientId()+" Name:"+getName()+" Age:"+getAge();}
}

interface MedicalRecord{
    void addRecord(String record);
    String viewRecords();
}

class InPatient extends Patient implements MedicalRecord{
    private int days;
    private double dailyRate;
    private StringBuilder records=new StringBuilder();
    public InPatient(String id,String name,int age,int days,double dailyRate){super(id,name,age);this.days=days;this.dailyRate=dailyRate;}
    public double calculateBill(){return days*dailyRate+2000;}
    public void addRecord(String record){records.append(record).append(";");}
    public String viewRecords(){return records.toString();}
}

class OutPatient extends Patient implements MedicalRecord{
    private double consultationFee;
    private StringBuilder records=new StringBuilder();
    public OutPatient(String id,String name,int age,double fee){super(id,name,age);this.consultationFee=fee;}
    public double calculateBill(){return consultationFee;}
    public void addRecord(String record){records.append(record).append(";");}
    public String viewRecords(){return records.toString();}
}

public class HospitalManagement{
    public static void main(String[] args){
        List<Patient> patients=new ArrayList<>();
        InPatient ip=new InPatient("P001","Nita",40,5,3000);
        OutPatient op=new OutPatient("P002","Sam",28,500);
        ip.addRecord("Surgery done");
        op.addRecord("Checkup normal");
        patients.add(ip); patients.add(op);
        for(Patient p:patients){
            System.out.println(p.getPatientDetails()+" Bill:"+p.calculateBill());
            MedicalRecord mr=(MedicalRecord)p;
            System.out.println("Records: "+mr.viewRecords());
        }
    }
}

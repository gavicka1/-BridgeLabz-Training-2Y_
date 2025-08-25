import java.util.Scanner;

public class ques3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Physics, Chemistry, Maths marks: ");
        double phy = sc.nextDouble(), chem = sc.nextDouble(), math = sc.nextDouble();

        double per = (phy + chem + math) / 3;
        String grade, remarks;

        if (per >= 80) { grade = "A"; remarks = "Level 4, above standards"; }
        else if (per >= 70) { grade = "B"; remarks = "Level 3, at standards"; }
        else if (per >= 60) { grade = "C"; remarks = "Level 2, approaching standards"; }
        else if (per >= 50) { grade = "D"; remarks = "Level 1, well below standards"; }
        else if (per >= 40) { grade = "E"; remarks = "Level 1, too below standards"; }
        else { grade = "R"; remarks = "Remedial standards"; }

        System.out.println("Percentage: " + per + "%");
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remarks);
    }
}
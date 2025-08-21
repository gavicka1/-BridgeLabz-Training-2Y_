import java.util.Scanner;

public class ques9 {
    public static void main(String[] args) {
        double fee, discountPercent;
        Scanner input = new Scanner(System.in);
        fee = input.nextDouble();
        discountPercent = input.nextDouble();
        double discount = (fee * discountPercent) / 100;
        double finalFee = fee - discount;
        System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + finalFee);
    }
}

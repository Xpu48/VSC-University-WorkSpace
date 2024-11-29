package Lab1Ex;
import java.util.Scanner;

public class Lab1Ex3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give a number with decimals: ");
        double n = scanner.nextDouble();

        int wholepart = (int)n;
        double decipart = n - wholepart;

        System.out.println("Whole Number is: "+ wholepart);
        System.out.printf("Decimal is: %.3f%n", decipart);

        scanner.close();
    }
}

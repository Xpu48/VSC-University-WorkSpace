package Lab1Ex;
import java.util.Scanner;

public class Lab1Ex2 {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give a first number: ");
        double fn = scanner.nextDouble();
        
        System.out.println("Give a Second number: ");
        double sn = scanner.nextDouble();

        double sum = fn + sn;
        double difference = fn - sn;
        double product = fn * sn;
        double quotient = fn / sn;

        System.out.println("sum = " + sum);
        System.out.println("difference = " + difference);
        System.out.println("product = " + product);
        System.out.println("quotient = " + quotient);

        scanner.close();
    }
}

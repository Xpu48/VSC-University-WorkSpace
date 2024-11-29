package Lab1Ex;
import java.util.Scanner;

public class Lab1Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give me a time in seconds: ");
        double timesecs = scanner.nextDouble();

        int hours = (int) timesecs / 3600;
        int mins = (int) (timesecs % 3600) / 60;
        int secs = (int) timesecs % 60;
        int milisecs = (int) Math.round((timesecs - Math.floor(timesecs)) * 1000);
        
        System.out.printf("%02d:%02d:%02d:%03d%n", hours,mins,secs,milisecs);
        scanner.close();

        }
}

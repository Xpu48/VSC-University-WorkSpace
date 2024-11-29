package Lab1Ex;
import java.util.Scanner;

public class Lab1Ex1 {
    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);
        String Again;

        do{
            System.out.println("Enter a number: ");
            float radius = scanner.nextInt();
            Circle(radius);

            System.out.println("Do you want to enter another? (yes/no)");
            Again = scanner.next().toLowerCase();
        } 
        
        while(Again.equals("yes"));
        scanner.close();
    }

    public static void Circle(float radius){
        var area = 3.14 * radius * radius;
        System.out.println("The area is "+ area);
        var circumference  =  2* 3.14 * radius;
        System.out.println("The circumference is "+  circumference);
    }
}

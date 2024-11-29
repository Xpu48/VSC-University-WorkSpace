package Lab5Ex;
import java.util.Scanner;

public class Lab5Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[8];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 8; i++){
            while (true){
                System.out.println("Enter a number(" + (i + 1) + ") ");
                String input = scanner.nextLine();
                
                try{
                    int number = Integer.parseInt(input);
                    numbers[i] = number;
                    if (number > max){
                        max = number;
                    }
                    break;
                }
                catch (NumberFormatException e){
                    System.out.println("Invalid input. Please enter a number.");
                }
            }
        }

        System.out.println("The maximum number is: " + max);
        scanner.close();
    } 
}

package Lab5Ex;
import java.util.Scanner;

public class Lab5Ex2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("Enter something: ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")){
                break;
            }
            
            try{
                Integer.parseInt(input);
                System.out.println("It's an Integer");
            }
            catch (NumberFormatException e){
                try{
                    Double.parseDouble(input);
                    System.out.println("It's a Double");
                }
                catch (NumberFormatException e1){
                    System.out.println("It's a String");
                }
            }
    }
    scanner.close();
}


}


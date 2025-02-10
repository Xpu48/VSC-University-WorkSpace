package May;

import java.util.Scanner;

public class Wk3_TutorialEx5 {

    public static void main(String[] args) {
        System.out.println("Welcome to May's Calculator!");
        Scanner user_input = new Scanner(System.in);

        
        boolean valid = false;
        double num1 = 0;
        double num2 = 0;
        while (valid == false){
            try {
                System.out.println("Enter first number:");
                num1 = user_input.nextDouble();
                System.out.println("Enter second number:");
                num2 = user_input.nextDouble();
                valid = true;
            }
            catch (Exception e){
                System.out.println("Invalid input, please enter a numeric value");
                user_input.next();
                break;
            }
        }

        boolean valid2 = false;
        while (valid2 == false){
            try{
                System.out.println("Enter your choice of operator (+ , - , / , *):");
                String operator = user_input.next();

                switch (operator){
                    case "+":
                        System.out.println(num1+" + "+num2+" = "+(num1+num2));
                        break;
                    case "-":
                        System.out.println(num1+" - "+num2+" = "+(num1-num2));
                        break;
                    case "/":
                        System.out.println(num1+" / "+num2+" = "+(num1/num2));
                        break;
                    case "*":
                        System.out.println(num1+" x "+num2+" = "+(num1*num2));
                        break;
                    default:
                        System.out.println("Unknown or invalid operator.");
                }
                valid2 = true;
            }
            catch (Exception e){
                System.out.println("Invalid input, please enter a numeric value");
                user_input.next();
                break;
            }
        }
    }
}

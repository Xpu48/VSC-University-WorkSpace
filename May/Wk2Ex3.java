package May;
import java.util.Scanner;
public class Wk2Ex3 {

    public static void main(String[] args) {
        int password =486251;



        boolean login = true;
        int count = 4;
        int user_password = 0;
        while (login) {
            if (count>0){
                System.out.println("Enter your password:");
                Scanner user_input = new Scanner(System.in);
                user_password = user_input.nextInt();
            }

            if (count==0){
                System.out.println("No more attempts left!");
                login = false;
            }
            else if(password!= user_password){
                count--;
                System.out.println("Password is incorrect, "+(count)+ " attempts left!");
            }
            else {
                System.out.println("password is correcto, login is succesful");
                login=false;
            }
        }

    }
}
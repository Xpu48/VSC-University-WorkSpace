package Lab5Ex;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Laba5Ex4{
    private static List<String> records = new ArrayList<>();

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
    
    while (true) {
        System.out.println("a - Add a record");
        System.out.println("r - Remove a record");
        System.out.println("l - List all records");
        System.out.println("q - Quit");
        System.out.println("Enter a command (a,r,l,q): ");
        String command = scanner.nextLine();

        if (command.equals("a")){
            addRecord(scanner);
        } else if (command.equals("r")){
            removeRecord(scanner);
        } else if (command.equals("l")){
            listRecords();
        } else if (command.equals("q")){
            System.out.println("Quitting...");
            break;
        }
        else{
            System.out.println("Invalid command");
        }
    }
    scanner.close();
}

    private static void addRecord(Scanner scanner){
        System.out.println("Adding a record...");
        System.out.println("Enter a FirstName, LastName, Age: ");
        String record = scanner.nextLine();
        records.add(record);
        System.out.println("Record added");
    }

    private static void removeRecord(Scanner scanner){
        System.out.println("Removing a record...");
        System.out.println("Enter a record ID number to remove: ");
        int ID = Integer.parseInt(scanner.nextLine());
        if (ID >= 0 && ID < records.size()){
            records.remove(ID);
            System.out.println("Record removed");
        } else {
            System.out.println("Invalid record ID");
        }
    }

    private static void listRecords(){
        System.out.println("Listing all records...");
        if (records.isEmpty()){
            System.out.println("No records");
            return;
        }
        else {
            for (int i = 0; i < records.size(); i++){
                System.out.println(i + ": " + records.get(i));
            }
        }
    }
}

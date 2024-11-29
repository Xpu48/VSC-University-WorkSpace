package Lab2Ex;

public class Lab2Ex2 {
    String[] weekday = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    int [] number = {1,2,3,4,5,6,7};

    public void printWeekdays() {
        for (String day : weekday) {
            switch(day) {
                case "Monday":
                    System.out.println(number[0]);
                    System.out.println("Today is Monday");
                    break;
            }
        }
    }
    
    public void convertDayToString(int dayNumber){
        switch (dayNumber) {
            case 1:
                System.out.println("Day number 1 is Monday");
                break;
            case 2:
                System.out.println("Day number 2 is Tuesday");
                break;
            case 3:
                System.out.println("Day number 3 is Wednesday");
                break;
            case 4:
                System.out.println("Day number 4 is Thursday");
                break;
            case 5:
                System.out.println("Day number 5 is Friday");
                break;
            case 6:
                System.out.println("Day number 6 is Saturday");
                break;
            case 7:
                System.out.println("Day number 7 is Sunday");
                break;
        }
    }

    public static void main(String[] args) {
        Lab2Ex2 lab = new Lab2Ex2();
        lab.convertDayToString(5);
    }
}

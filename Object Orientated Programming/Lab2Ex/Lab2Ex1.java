package Lab2Ex;

public class Lab2Ex1 {
    public static void main(String[] args) {
        double[] weight = {0.15, 0.15, 0.30, 0.40};
        int [] score = {63,67,56,71};

        double total = 0;

        for (int i = 0; i < weight.length; i++) {
            total += weight[i] * score[i];
        }

        if (total >= 70 && total <= 100) {
            System.out.println("First Class");
        }
        if (total >= 60 && total < 70) {
            System.out.println("Second Class");
        }
        if (total >= 50 && total < 60) {
            System.out.println("Third Class");
        }
        if (total >= 40 && total < 50) {
            System.out.println("Pass");
        }

        System.out.printf("Final Mark: %.2f%n", total);
    }
}

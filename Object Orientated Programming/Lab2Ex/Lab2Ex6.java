package Lab2Ex;

public class Lab2Ex6 {
    public static void main(String[] args) {
        int limit = 500000; 
        double pi = Math.PI;
        double bestApproximation = 0;
        int bestA = 0;
        int bestB = 1;
        double smallestDifference = Double.MAX_VALUE;

        // Checks through all possibilities of a/b to find the best approximation of pi
        for (int b = 1; b < limit; b++) {
            int a = (int) Math.round(pi * b);
            double approximation = (double) a / b;
            double difference = Math.abs(pi - approximation);
            if (difference < smallestDifference) {
                smallestDifference = difference;
                bestApproximation = approximation;
                bestA = a;
                bestB = b;
            }
        }

        // Calculate the number of decimal places the approximation is accurate to
        int decimalPlaces = 0;
        double tempPi = pi;
        double tempApprox = bestApproximation;
        while (Math.abs(tempPi - tempApprox) < 1) {
            tempPi *= 10;
            tempApprox *= 10;
            decimalPlaces++;
        }

        System.out.println("Best approximation of pi: " + bestA + "/" + bestB + " = " + bestApproximation);
        System.out.println("Number of decimal places accurate to: " + decimalPlaces);
    }
}
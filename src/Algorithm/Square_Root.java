package Algorithm;

import java.util.Scanner;

public class Square_Root {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number");
        double num = scan.nextDouble();
        double low = 2;
        double high = num;
        double mid;
        do {
            mid = (low + high) / 2;
            mid = (double) Math.round(mid * 10000) / 10000;

            double diff = mid * mid - num;
            diff = diff < 0 ? -diff : diff;

            if(diff < 0.01)
                break;
            else if (mid * mid > num)
                high = mid;
            else
                low = mid;
        }while (high > low);

        System.out.println(mid);

    }

}

package activities;

import java.util.Arrays;

public class Activity2 {
    public static void main(String[] args) {
        int[] ArrofNum ={10, 77, 10, 54, -11, 10};
        System.out.println("Arrays numbers" + Arrays.toString(ArrofNum));
        int requiredno = 10;
        int total = 30;
        System.out.println("Result:" + result(ArrofNum, requiredno, total));
    }

    public static boolean result(int[] numbers, int requiredno, int total) {
        int temp = 0;
        for (int number : numbers) {
            if (number == requiredno) {
                temp = temp + requiredno;
            }

            if (temp > total) {
                break;
            }
        }
        return temp == total;
    }
}

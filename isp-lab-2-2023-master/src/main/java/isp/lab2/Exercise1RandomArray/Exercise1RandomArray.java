package isp.lab2.Exercise1RandomArray;

import java.util.Random;

public class Exercise1RandomArray {

    public static int[] getArrayOfRandomNumbers(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = new Random().nextInt(91) + 10;
            System.out.println(array[i]);
        }
        //TODO: implement the logic to fill the array with random numbers
        return array;
    }

    public static int[] findMinAndMax(int[] array) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }

            if (array[i] > max) {
                max = array[i];
            }
        }

        int[] x = new int[2];
        x[0] = min;
        x[1] = max;
        return x;
    }

    public static void print() {
        System.out.println("TEST");
    }

    public static void main(String[] args) {

        Random random = new Random();
        //genereaza numar random intre 10 si 100
        int size = random.nextInt(91) + 10;
        int[] a = getArrayOfRandomNumbers(size);
        int[] mm = findMinAndMax(a);
        System.out.println("Min is:" + mm[0] + " Max is:" + mm[1]);
    }
}

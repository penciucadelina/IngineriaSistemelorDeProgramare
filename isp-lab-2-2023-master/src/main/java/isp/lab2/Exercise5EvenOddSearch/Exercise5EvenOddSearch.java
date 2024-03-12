package isp.lab2.Exercise5EvenOddSearch;

        //cel mai mare nr par si pozitia si cel mai mic nr impar si pozitia
public class Exercise5EvenOddSearch {

    public static int[] findEvenOdd(String input) {
        String[] numbersString = input.split(",");
        int[] numbers = new int[numbersString.length];

        // Convertim string la integer
        for (int i = 0; i < numbersString.length; i++) {
            numbers[i] = Integer.parseInt(numbersString[i].trim());
        }

        int largestEven = Integer.MIN_VALUE;
        int smallestOdd = Integer.MAX_VALUE;
        int largestEvenPosition = -1;
        int smallestOddPosition = -1;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0 && numbers[i] > largestEven) {
                largestEven = numbers[i];
                largestEvenPosition = i;
            } else if (numbers[i] % 2 != 0 && numbers[i] < smallestOdd) {
                smallestOdd = numbers[i];
                smallestOddPosition = i;
            }
        }

        if (largestEven == Integer.MIN_VALUE) {
            largestEvenPosition = -1;
        }
        if (smallestOdd == Integer.MAX_VALUE) {
            smallestOddPosition = -1;
        }

        return new int[]{largestEven, largestEvenPosition, smallestOdd, smallestOddPosition};
    }



    public static void main(String[] args) {
        String input = "1,2,3,4,5,6,7,8,9,10";
        int[] result = findEvenOdd(input);
        for (int i : result) {
            System.out.println(i);
        }
    }
}

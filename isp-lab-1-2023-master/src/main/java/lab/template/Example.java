package lab.template;


import java.util.Scanner;
import java.util.logging.Logger;

/**
 * @author mihai.hulea
 */
public class Example {

    public static Logger LOG = Logger.getLogger(Example.class.getName());

    /**
     * Add x and y.
     *
     * @param x
     * @param y
     * @return result of the sum.
     */
    public static int add(int x, int y) {
        return x + y;
    }

    public static int substract(int x, int y) {
        return x - y;
    }

    public static int multiply(int x, int y) {
        return x * y;
    }

    public static void main(String[] args) {
        System.out.println("penciuc.adelina@gmail.com");
        System.out.println(new Scanner(System.in).nextLine().trim().toLowerCase().hashCode());
        System.out.println("It works!");
        LOG.info("It works!");
        System.out.println("Number of arguments received: " + args.length + " ");
        for (String arg : args)
            System.out.println("Argument: " + arg);
        System.out.printf("Result of sub %d from %d is: %d\n\n", 10, 23, Example.multiply(10, 23));
    }
}

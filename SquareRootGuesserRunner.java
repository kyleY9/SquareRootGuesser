import java.util.Scanner;

public class SquareRootGuesserRunner {
    public static void main(String[] args) {
        // scanner object
        Scanner scan = new Scanner(System.in);

        System.out.print("Input the number that you want to find the root of: ");
        double rootNum = scan.nextDouble();
        System.out.print("Input the root you want to impose on your number: ");
        int typeOfRoot = scan.nextInt();
        System.out.print("Input how close you want the estimate to be: ");
        double tolerance = scan.nextDouble();

        // SquareRootGuesser object instantiation
        SquareRootGuesser obj = new SquareRootGuesser(rootNum, typeOfRoot, tolerance);
    
        obj.rootBetween();
        obj.guessingTheRoot();
    }
}
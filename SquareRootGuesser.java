public class SquareRootGuesser {
    // instance variables
    private int numGuesses;
    private int typeOfRoot;
    private double rootNum;
    private double lowerBound;
    private double upperBound;
    private double tolerance;

    public SquareRootGuesser(double rootNum, int typeOfRoot, double tolerance) {
        this.rootNum = rootNum;
        this.typeOfRoot = typeOfRoot;
        this.tolerance = tolerance;
        numGuesses = 1;
    }

    // public methods
    public void rootBetween() {
        for (int i = 0; (Math.pow(i, typeOfRoot) >= rootNum) || (Math.pow(i + 1, typeOfRoot) <= rootNum); i++) {
            if (Math.pow(i, typeOfRoot) == rootNum) {
                System.out.println(i + " is the result of root(" + typeOfRoot + ") on " + rootNum + ".");
                System.exit(0);
            }
            lowerBound = i + 1;
            upperBound = i + 2;
        }
        System.out.println("Root(" + typeOfRoot + ") of " + rootNum + " is between " + lowerBound + " and " + upperBound + ".");
    }

    public void guessingTheRoot() {
        double test;
        double guess = 0;
        // if guess is too big, reset upper number to current avg; if too small, reset lower number to current avg
        test = Math.pow(average(lowerBound, upperBound), typeOfRoot);
        while (Math.abs(test - rootNum) > tolerance) {
            if (test > rootNum) {
                upperBound = average(lowerBound, upperBound);
            } else if (test < rootNum) {
                lowerBound = average(lowerBound, upperBound);
            }
            test = Math.pow(average(lowerBound, upperBound), typeOfRoot);
            guess = average(lowerBound, upperBound);
            numGuesses++;
        }
        System.out.println("Root(" + typeOfRoot + ") of " + rootNum + " is approximately " + guess + ".");
        System.out.println("I got it in " + numGuesses + " tries!");
    }

    // private helper methods
    private static double average(double d1, double d2) {
        return (d1 + d2)/2;
    }
}
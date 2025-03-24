import java.util.Scanner;
import java.util.StringTokenizer;

public class PolynomialEvaluator {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter your polynomial in the form of f(x)=3x^3 -5x^2 +1x^4 +9x^6 +3.1x^1 +2");

        StringTokenizer st = new StringTokenizer(keyboard.nextLine().replace("f(x)=", ""));
        System.out.println("Enter the value of x");
        double x = keyboard.nextDouble();

        double result = 0;

        while (st.hasMoreTokens()) {
            String currentTerm = st.nextToken();
            int exponent = 0;
            double coefficient = 1;

            if (currentTerm.contains("x")) {
                if (currentTerm.replaceAll("/+|-", "").indexOf("x") != 0) {
                    coefficient = Double.parseDouble(currentTerm.substring(0, currentTerm.indexOf('x')));
                }
                if (currentTerm.contains("^")) {
                    exponent = Integer.parseInt(currentTerm.substring(currentTerm.indexOf('^') + 1));
                } else {
                    exponent = 1;
                }

            } else {
                coefficient = Double.parseDouble(currentTerm);

            }
            result += coefficient * Math.pow(x, exponent);

        }
        System.out.println("f" + "(" + x + ")" + " = " + result);
        keyboard.close();
    }
}

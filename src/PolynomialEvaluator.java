import java.util.Scanner;
import java.util.StringTokenizer;

public class PolynomialEvaluator {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter your polynomial in the form of f(x)=3x^3 -5x^2 +1x^4 +9x^6 +3.1x^1 +2");
        String polynomial = keyboard.nextLine();

        StringTokenizer st = new StringTokenizer(polynomial, " ");
        System.out.println("Enter the value of x");
        double x = keyboard.nextDouble();

        double result = 0;

        while (st.hasMoreTokens()) {
            String currentTerm = st.nextToken();
            int exponent = 0;
            double coefficient = 1;

            int xIndex = currentTerm.indexOf('x');
            int exponentIndex = currentTerm.indexOf('^');

            if (xIndex >= 0) {
                if (xIndex == 0) {
                    coefficient = 1;
                } else {
                    coefficient = Double.parseDouble(currentTerm.substring(0, xIndex));
                }
                if (exponentIndex >= 0) {
                    exponent = Integer.parseInt(currentTerm.substring(exponentIndex + 1));
                } else {
                    exponent = 1;

                }

            } else {
                coefficient = Double.parseDouble(currentTerm);
                exponent = 0;

            }
            result += coefficient * Math.pow(x, exponent);

        }
        System.out.println("f" +"(" + x + ")" + " = " + result);
        keyboard.close();
    }
}

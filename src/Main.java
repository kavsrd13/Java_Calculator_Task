import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner scanner = new Scanner(System.in);

        // Read in the expression from the user
        System.out.print("Enter an expression: ");
        String expression = scanner.nextLine();

        // Used regex to parse the values and operator from the expression
        Pattern pattern = Pattern.compile("^(\\d+)([+-/*])(\\d+)([+-/*])(\\d+)$");
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()) {
            int value1 = Integer.parseInt(matcher.group(1));
            char operator1 = matcher.group(2).charAt(0);
            int value2 = Integer.parseInt(matcher.group(3));
            char operator2 = matcher.group(4).charAt(0);
            int value3 = Integer.parseInt(matcher.group(5));

            double intermediateResult;
            switch (operator1) {
                case '+':
                    intermediateResult = value1 + value2;
                    break;
                case '-':
                    intermediateResult = value1 - value2;
                    break;
                case '*':
                    intermediateResult = value1 * value2;
                    break;
                case '/':
                    intermediateResult = value1 / value2;
                    break;
                default:
                    System.out.println("Invalid operator");
                    return;
            }
            double result;
            switch (operator2) {
                case '+':
                    result = intermediateResult + value3;
                    break;
                case '-':
                    result = intermediateResult - value3;
                    break;
                case '*':
                    result = intermediateResult * value3;
                    break;
                case '/':
                    result = intermediateResult / value3;
                    break;
                default:
                    System.out.println("Invalid operator");
                    return;
            }
            System.out.println(expression + " = " + result); // Print the result
        } else {
            System.out.println("Invalid expression");
        }
    }
}
import java.util.Scanner;

public class Main {
    static Calculator calc = new Calculator();
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a command ('add', 'subtract', 'multiply', 'divide', 'bin', or 'fib') followed by one or two numbers:");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the program.");
                break;
            }

            String[] tokens = input.split(" ");
            if (tokens.length < 1 || tokens.length > 3) {
                System.out.println("Invalid input. Please follow the format: command [number1] [number2]");
                continue;
            }

            String command = tokens[0];
            int num1 = 0;
            int num2 = 0;

            if (tokens.length >= 2) {
                try {
                    num1 = Integer.parseInt(tokens[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format. Please enter valid numbers.");
                    continue;
                }
            }

            if (tokens.length == 3) {
                try {
                    num2 = Integer.parseInt(tokens[2]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format. Please enter valid numbers.");
                    continue;
                }
            }


            if (command.equals("binary")) {
                System.out.println(binary(num1));
            } else {
                int result = calculate(command, num1, num2);
                System.out.println("Result: " + result);
            }

        }

        scanner.close();
    }

    public static int calculate(String command, int num1, int num2) {
        switch (command.toLowerCase()) {
            case "add":
                return calc.add(num1, num2);
            case "subtract":
                return calc.subtract(num1, num2);
            case "multiply":
                return calc.multiply(num1, num2);
            case "divide":
                if (num2 == 0) {
                    System.out.println("Division by zero is not allowed.");
                    return 0;
                }
                return calc.multiply(num1, num2);
            case "fib":
                return calc.fibonacciNumberFinder(num1);
            default:
                System.out.println("Unknown command. Please enter 'add', 'subtract', 'multiply', or 'divide'.");
                return 0;
        }
    }

    public static String binary(int num) {
        return calc.intToBinaryNumber(num);
    }
}

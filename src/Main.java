import java.io.IOException;
import java.util.Objects;

public class Main {
    public static boolean debug=false; // Debug Mode

    public static void main(String[] args) throws IOException, InterruptedException {
        if (args.length < 3) {
            clear_terminal();
            System.out.println("Usage: java Main <operation>(add, subtract, multiply, divide) <num1> <num2>");
            System.out.println();
            return;
        }

        String operation = args[0];
        int num1 = Integer.parseInt(args[1]);
        int num2 = Integer.parseInt(args[2]);

        switch (operation) {
            case "add" -> {
                int sum = add(num1, num2);
                clear_terminal();
                System.out.println(sum);
                System.out.println();
            }
            case "subtract" -> {
                int sum = subtract(num1, num2);
                clear_terminal();
                System.out.println(sum);
                System.out.println();
            }
            case "multiply" -> {
                int sum = multiply(num1, num2);
                clear_terminal();
                System.out.println(sum);
                System.out.println();
            }
            case "divide" -> {
                if (num2 == 0) {
                    clear_terminal();
                    System.out.println("Division by zero is not a thing, so don't do it!");
                    System.out.println();
                } else {
                    double sum = divide(num1, num2);
                    clear_terminal();
                    System.out.println(sum);
                    System.out.println();
                }
            }
            case "help" -> {
                clear_terminal();
                System.out.println("Usage: java Main <operation>(add, subtract, multiply, divide) <num1> <num2>");
            }
            default -> {
                System.out.println("Unknown operation: " + operation);
                System.out.println("Valid operations are: add, subtract, multiply, divide");
            }
        }
    }

    public static void clear_terminal() throws IOException, InterruptedException {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                debug_print("Windows terminal detected");
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                debug_print("Unix terminal detected");
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
            debug_print("Terminal detected, should be cleared");
        } catch (InterruptedException | IOException e) {
            debug_print("Terminal detection failed");
        } catch (Exception e) {
            debug_print("Terminal detected, error: " + e.getMessage());
        }
    }

    public static void debug_print(String str) {
        if (debug) {
            System.out.println(str);
        }
    }

    public static int add(int a, int b) {
        return a + b;
    }
    public static int subtract(int a, int b) {
        return a - b;
    }
    public static int multiply(int a, int b) {
        return a * b;
    }
    public static double divide(int a, int b) {
        return (double) a / b;
    }
}
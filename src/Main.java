//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java Main <operation>(add, subtract, multiply, divide) <num1> <num2>");
            return;
        }

        String operation = args[0];
        int num1 = Integer.parseInt(args[1]);
        int num2 = Integer.parseInt(args[2]);

        switch (operation) {
            case "add" -> {
                int sum = add(num1, num2);
                System.out.println(sum);
            }
            case "subtract" -> {
                int sum = subtract(num1, num2);
                System.out.println(sum);
            }
            case "multiply" -> {
                int sum = multiply(num1, num2);
                System.out.println(sum);
            }
            case "divide" -> {
                if (num2 == 0) {
                    System.out.println("Division by zero is not a thing, so don't do it!");
                } else {
                    int sum = divide(num1, num2);
                    System.out.println(sum);
                }
            }
            default -> {
                System.out.println("Unknown operation: " + operation);
                System.out.println("Valid operations are: add, subtract, multiply, divide");
            }
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
    public static int divide(int a, int b) {
        return a / b;
    }
}
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Swing {
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

    public static void main(String[] args) {
        JTextField number1 = new JTextField(3);
        JTextField operator = new JTextField(1);
        JTextField number2 = new JTextField(3);
        JLabel solution = new JLabel(" ");
        JButton solve = new JButton("Solve");

        JPanel inputs = new JPanel();

        inputs.add(number1);
        inputs.add(operator);
        inputs.add(number2);

        JPanel panel = new JPanel();
        solve.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String operation = operator.getText();
                if (operation.length() > 1) {
                    operation = operation.substring(0, 1);
                }

                String num1 = number1.getText();
                String num2 = number2.getText();


                if (num1.isEmpty() || num2.isEmpty() || operator.getText().isEmpty()) {
                    solution.setText("Please enter numbers and operator!");
                    return; // stop processing
                }

                if (!num1.matches("\\d+") || !num2.matches("\\d+")) {
                    solution.setText("Enter valid numbers!");
                    return;
                }


                int n1 = Integer.parseInt(num1);
                int n2 = Integer.parseInt(num2);

                switch (operation) {
                    case "+" -> {
                        int sum = add(n1, n2);
                        solution.setText(String.valueOf(sum));
                        System.out.println(sum);
                        System.out.println();
                    }
                    case "-" -> {
                        int sum = subtract(n1, n2);
                        solution.setText(String.valueOf(sum));
                        System.out.println(sum);
                        System.out.println();
                    }
                    case "*" -> {
                        int sum = multiply(n1, n2);
                        solution.setText(String.valueOf(sum));
                        System.out.println(sum);
                        System.out.println();
                    }
                    case "/" -> {
                        if (n2 == 0) {
                            System.out.println("Division by zero is not a thing, so don't do it!");
                            System.out.println();
                            solution.setText("You cant divide by zero!");
                        } else {
                            double sum = divide(n1, n2);
                            solution.setText(String.valueOf(sum));
                            System.out.println(sum);
                            System.out.println();
                        }
                    }
                }
            }
        });

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        solution.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        solve.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        panel.add(solution);
        panel.add(solve);
        solve.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        solution.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        JFrame frame = new JFrame("Calculator");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(inputs);
        frame.add(panel);
        frame.add(Box.createVerticalStrut(300));
        frame.pack();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

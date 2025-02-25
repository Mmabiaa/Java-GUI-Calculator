import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowsCalculator extends JFrame implements ActionListener {
    private JTextField display;
    private String operator;
    private double firstOperand;

    public WindowsCalculator() {
        // Set up the frame
        setTitle("Calculator");
        setSize(300, 400);
        setResizable(false); // Make size fixed
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create display field
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24)); // Enhance font
        display.setHorizontalAlignment(JTextField.RIGHT); // Align right
        add(display, BorderLayout.NORTH);

        // Create buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5)); // Add spacing between buttons

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(this);
            button.setFont(new Font("Arial", Font.BOLD, 18)); // Enhance font
            buttonPanel.add(button);
        }

        // Add additional buttons for MC, MR, MS, M+
        JPanel memoryPanel = new JPanel();
        memoryPanel.setLayout(new FlowLayout());
        JButton mcButton = new JButton("MC");
        JButton mrButton = new JButton("MR");
        JButton msButton = new JButton("MS");
        JButton mPlusButton = new JButton("M+");
        mcButton.addActionListener(this);
        mrButton.addActionListener(this);
        msButton.addActionListener(this);
        mPlusButton.addActionListener(this);
        memoryPanel.add(mcButton);
        memoryPanel.add(mrButton);
        memoryPanel.add(msButton);
        memoryPanel.add(mPlusButton);

        add(buttonPanel, BorderLayout.CENTER);
        add(memoryPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
            display.setText(display.getText() + command);
        } else if (command.equals("C")) {
            display.setText("");
            operator = "";
            firstOperand = 0;
        } else if (command.equals("=")) {
            double secondOperand = Double.parseDouble(display.getText());
            switch (operator) {
                case "+":
                    display.setText(String.valueOf(firstOperand + secondOperand));
                    break;
                case "-":
                    display.setText(String.valueOf(firstOperand - secondOperand));
                    break;
                case "*":
                    display.setText(String.valueOf(firstOperand * secondOperand));
                    break;
                case "/":
                    display.setText(String.valueOf(firstOperand / secondOperand));
                    break;
            }
            operator = "";
        } else if (command.equals("MC") || command.equals("MR") || command.equals("MS") || command.equals("M+")) {
            // Implement memory operations here
            System.out.println("Memory operation: " + command);
        } else {
            if (!operator.isEmpty()) return; // Prevent multiple operators
            firstOperand = Double.parseDouble(display.getText());
            operator = command;
            display.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WindowsCalculator calculator = new WindowsCalculator();
            calculator.setVisible(true);
        });
    }
}

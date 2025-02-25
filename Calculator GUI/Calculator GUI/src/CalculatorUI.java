import javax.swing.*;
import java.awt.*;

public class CalculatorUI extends JFrame {
    private JTextField display;
    private CalculatorLogic calculatorLogic;

    public CalculatorUI() {
        calculatorLogic = new CalculatorLogic();
        createUI();
    }

    private void createUI() {
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
            button.addActionListener(e -> calculatorLogic.handleButtonPress(text, display));
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
        mcButton.addActionListener(e -> calculatorLogic.handleMemoryOperation("MC", display));
        mrButton.addActionListener(e -> calculatorLogic.handleMemoryOperation("MR", display));
        msButton.addActionListener(e -> calculatorLogic.handleMemoryOperation("MS", display));
        mPlusButton.addActionListener(e -> calculatorLogic.handleMemoryOperation("M+", display));
        memoryPanel.add(mcButton);
        memoryPanel.add(mrButton);
        memoryPanel.add(msButton);
        memoryPanel.add(mPlusButton);

        add(buttonPanel, BorderLayout.CENTER);
        add(memoryPanel, BorderLayout.SOUTH);
    }

    public void setVisible(boolean visible) {
        super.setVisible(visible);
    }
}

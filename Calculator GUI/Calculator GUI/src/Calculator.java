import javax.swing.SwingUtilities;

public class Calculator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorUI calculatorUI = new CalculatorUI();
            calculatorUI.setVisible(true);
        });
    }
}

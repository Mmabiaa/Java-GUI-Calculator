public class CalculatorLogic {
    private String operator;
    private double firstOperand;
    private MemoryManager memoryManager;

    public CalculatorLogic() {
        memoryManager = new MemoryManager();
    }

    public void handleButtonPress(String text, JTextField display) {
        if (text.charAt(0) >= '0' && text.charAt(0) <= '9') {
            display.setText(display.getText() + text);
        } else if (text.equals("C")) {
            display.setText("");
            operator = "";
            firstOperand = 0;
        } else if (text.equals("=")) {
            double secondOperand = Double.parseDouble(display.getText());
            double result = performCalculation(firstOperand, secondOperand, operator);
            display.setText(String.valueOf(result));
            operator = "";
        } else {
            if (!operator.isEmpty()) return; // Prevent multiple operators
            firstOperand = Double.parseDouble(display.getText());
            operator = text;
            display.setText("");
        }
    }

    private double performCalculation(double firstOperand, double secondOperand, String operator) {
        switch (operator) {
            case "+":
                return firstOperand + secondOperand;
            case "-":
                return firstOperand - secondOperand;
            case "*":
                return firstOperand * secondOperand;
            case "/":
                return firstOperand / secondOperand;
            default:
                return 0;
        }
    }

    public void handleMemoryOperation(String operation, JTextField display) {
        memoryManager.handleMemoryOperation(operation, display);
    }
}

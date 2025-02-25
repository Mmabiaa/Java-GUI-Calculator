public class MemoryManager {
    private double memoryValue;

    public void handleMemoryOperation(String operation, JTextField display) {
        switch (operation) {
            case "MC":
                memoryValue = 0;
                break;
            case "MR":
                display.setText(String.valueOf(memoryValue));
                break;
            case "MS":
                memoryValue = Double.parseDouble(display.getText());
                break;
            case "M+":
                memoryValue += Double.parseDouble(display.getText());
                break;
        }
    }
}

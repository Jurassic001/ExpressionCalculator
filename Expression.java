import java.util.ArrayList;


public class Expression {
    private String expression;
    private ArrayList<Double> operands = new ArrayList<Double>();
    private ArrayList<Character> operations = new ArrayList<Character>();
    double digit;

    public Expression(String e) {
        expression = e;
    }


    public double findAnswer() {
        for (int i = 0; i < expression.length(); i++) {
            if (Character.isDigit(expression.charAt(i))) { // digit found
                digit = 0;
                int digitLength = 1;
                while (i < expression.length() - 1 && Character.isDigit(expression.charAt(i + 1))) {
                    digitLength++;
                    i++;
                }
                for (int j = 0; j < digitLength; j++) {
                    digit += (expression.charAt(i - (digitLength - j) + 1) - 48) * Math.pow(10, digitLength - j - 1);
                }
                operands.add(digit);
            }
            else { // operation found
                if (operations.isEmpty() || getPriority(expression.charAt(i)) > getPriority(operations.get(operations.size() - 1))) {
                    operations.add(expression.charAt(i));
                }
                else { // perform operation
                    while (!operations.isEmpty() && getPriority(expression.charAt(i)) <= getPriority(operations.get(operations.size() - 1))) {
                        // pop the top two variables
                        double firstInStack = operands.get(operands.size() - 1);
                        operands.remove(operands.size() - 1);
                        double secondInStack = operands.get(operands.size() - 1);
                        operands.remove(operands.size() - 1);
                        switch (operations.get(operations.size() - 1)) { // add operation result
                            case '^':
                                operands.add(Math.pow(secondInStack, firstInStack));
                                break;
                            case '*':
                                operands.add(secondInStack * firstInStack);
                                break;
                            case '/':
                                operands.add(secondInStack / firstInStack);
                                break;
                            case '+':
                                operands.add(secondInStack + firstInStack);
                                break;
                            case '-':
                                operands.add(secondInStack - firstInStack);
                                break;
                        }
                        operations.remove(operations.size() - 1); // remove used operation
                    }
                    operations.add(expression.charAt(i)); // add compared operation
                }
            }
        }
        // printStacks();
        // run through the rest of the operations
        for (int i = operations.size() - 1; i >= 0; i--) {
            // pop the top two variables
            double firstInStack = operands.get(operands.size() - 1);
            operands.remove(operands.size() - 1);
            double secondInStack = operands.get(operands.size() - 1);
            operands.remove(operands.size() - 1);

            switch (operations.get(operations.size() - 1)) {
                case '^':
                    operands.add(Math.pow(secondInStack, firstInStack));
                    break;
                case '*':
                    operands.add(secondInStack * firstInStack);
                    break;
                case '/':
                    operands.add(secondInStack / firstInStack);
                    break;
                case '+':
                    operands.add(secondInStack + firstInStack);
                    break;
                case '-':
                    operands.add(secondInStack - firstInStack);
                    break;
            }
            operations.remove(operations.size() - 1);
        }
        return operands.get(0);
    }


    public int getPriority(char c) {
        switch (c) {
            case '+':
            case '-':
                return 0;
            case '*':
            case '/':
                return 1;
            case '^':
                return 2;
        }
        return -1;
    }


    public void printStacks() {
        System.out.println("\nStacks: ");
        for (double i : operands) {
            System.out.println(i);
        }
        for (char i : operations) {
            System.out.println(i);
        }
    }
}

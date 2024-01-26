java.import.ArrayList;

public class Expression {
    private String expression;

    public Expression(String e) {
        expression = e;
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

    public double findAnswer() {
        ArrayList<Integer> operands = new ArrayList<Integer>();
        ArrayList<Character> operants = new ArrayList<Character>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i).isDigit()) operands.add((int)(expression.charAt(i)));
            else operants.add((int)(expression.charAt(i)));
        }
        return -1;
    }
}

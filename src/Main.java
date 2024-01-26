import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        Expression e = new Expression(s.nextLine());

        double answer = e.findAnswer();

        System.out.println(answer);
    }
}

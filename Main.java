import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Expression e = new Expression(s.nextLine());

        double answer = e.findAnswer();

        System.out.println("answer: " + answer);
    }
}

/*
test equations:

5+5-5
=5

4/2*3^2
=18

2^3/2^3
=1

1+3*4/3-2^3/2
=1

1+1+1+1+1+1+2^3
=14

1-1+1-1+3/3*3
=3

3*4^2+5
=53

23+2
=25
 */

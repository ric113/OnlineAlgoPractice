/**
 * Created by ricky on 2016/9/2.
 */
import java.math.BigInteger;
import java.util.Scanner;

public class main {
    public static void main(String args[])
    {
        Scanner keyboard = new Scanner(System.in);
        BigInteger a , b;
        BigInteger bound = new BigInteger("2147483647");
        BigInteger res = new BigInteger("0");
        String oprt , output ;
        while (keyboard.hasNextBigInteger())
        {
            a = keyboard.nextBigInteger();
            oprt = keyboard.next();
            b = keyboard.nextBigInteger();
            output = a.toString() + " " + oprt + " " + b.toString() + "\n";

            if(oprt.equals("*"))
                res = a.multiply(b);
            else if(oprt.equals("+"))
                res = a.add(b);

            if(a.compareTo(bound) > 0)
                output += "first number too big" + "\n";
            if(b.compareTo(bound) > 0)
                output += "second number too big" + "\n";
            if(res.compareTo(bound) > 0)
                output += "result too big" ;

            System.out.println(output);
            //System.out.println(a);
            //System.out.println(oprt);
            //System.out.println(b);
        }
    }


}

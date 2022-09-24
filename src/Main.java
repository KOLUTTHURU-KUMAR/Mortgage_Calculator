import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        //M = P [ i(1 + i)^n ] / [ (1 + i)^n – 1].
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        System.out.println("Calculator");
        System.out.print("Principal: ");
        Scanner src = new Scanner(System.in);
        int principal = src.nextInt();
        System.out.print("Annual Interest Rate: ");
        float ani = src.nextFloat();
        System.out.print("Period(Years): ");
        int years = src.nextInt();
        float monthlyInterest = ani / PERCENT / MONTHS_IN_YEAR;
        int numberOfPayments = years * MONTHS_IN_YEAR;
        double mortgage = principal * (Math.pow(1 + monthlyInterest,numberOfPayments)*monthlyInterest)
                /(Math.pow(1+monthlyInterest,numberOfPayments) - 1);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}
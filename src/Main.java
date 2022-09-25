import java.text.NumberFormat;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        //M = P [ i(1 + i)^n ] / [ (1 + i)^n – 1].
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        int principal =0;
        float monthlyInterest = 0;
        int numberOfPayments =0;
        Scanner src = new Scanner(System.in);
        System.out.println("Calculator");

        while(true) {
            System.out.print("Principal: ");
            principal = src.nextInt();
            if(principal >=1000 && principal <= 1_000_000)
                break;
            System.out.println("Enter the Principle between 1000 and 1_000_000");
        }
        while (true) {
            System.out.print("Annual Interest Rate: ");
            float ani = src.nextFloat();
            if(ani >=1 && ani <=30)
            {
                 monthlyInterest = ani / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }

        while(true) {
            System.out.print("Period(Years): ");
            int years = src.nextInt();
            if(years >=1 && years <=30) {
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }
        double mortgage = principal * (Math.pow(1 + monthlyInterest,numberOfPayments)*monthlyInterest)
                /(Math.pow(1+monthlyInterest,numberOfPayments) - 1);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}
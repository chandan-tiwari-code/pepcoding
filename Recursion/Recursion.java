package Recursion;

import java.util.Scanner;

public class Recursion {
    public static void main(String[] args) {
        System.out.println("Enter the no: ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
      //  System.out.println("Enter the no: ");
      //  int pow = scanner.nextInt();
      //  printDecrease(input);
      //  printIncrease(input);
      //  printDecreaseIncrease(input);
        printZigZag(input);
      //  System.out.println(factorial(input));
      //  System.out.println(linearPower(pow, input));
        scanner.close();
    }

    private static void printDecrease(int input) {
        System.out.println(input);
        if(input==1){
            return;
        }
        printIncrease(input-1);
    }

    private static void printIncrease(int input) {
        if (input==0) {
            return;
        }
        printIncrease(input-1);
        System.out.println(input);
    }

    private static void printDecreaseIncrease(int input) {
        if(input==0) {
            return;
        }
        System.out.println(input);
        printDecreaseIncrease(input-1);
        System.out.println(input);
    }

    private static int factorial(int input) {
        int fact=0;
        if(input==0) return fact;
        fact = factorial(input-1);
        return fact+input;
    }

    private static int linearPower(int pow, int base) {
        int res=1;
        if (pow==0) {
            return res;
        }
        res = linearPower(pow-1, base);
        return res * base;
    }

    private static void printZigZag(int input) {
        if(input == 0) {
            return ;
        }
        System.out.println("pre " +input);
        printZigZag(input-1);
        System.out.println("in " +input);
        printZigZag(input-1);
        System.out.println("post " +input);
    }

}

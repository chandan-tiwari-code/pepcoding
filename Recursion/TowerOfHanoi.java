package Recursion;

import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the no disk");
        int noOfDisk = scanner.nextInt();
        System.out.println("Enter 1st tower");
        int a= scanner.nextInt();
        System.out.println("Enter 2nd tower");
        int b= scanner.nextInt();
        System.out.println("Enter 3rd tower");
        int c= scanner.nextInt();
        towerOfHanoi(noOfDisk, a, b, c);
        scanner.close();
    }

    private static void towerOfHanoi(int noOfDisk, int a, int b, int c) {
        if(noOfDisk==0) return;
        towerOfHanoi(noOfDisk-1, a, c, b);
        System.out.println(noOfDisk + "- ["+ a  + " -> " + b +"]");
        towerOfHanoi(noOfDisk-1, c, b, a);
    }
}
 
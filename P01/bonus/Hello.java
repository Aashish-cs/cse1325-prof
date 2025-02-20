//import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        java.util.Scanner in = new java.util.Scanner(System.in);
        System.out.print("What is your name? ");
        String name = in.nextLine();
        System.out.println("Hello, " + name + "!");
    }
}   

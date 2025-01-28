package cli;

import eliza.ElizaMain;

import java.util.Scanner;

// This work is in the public domain. No copyright is claimed by the original author or by me.

// Based on ELIZA as described by Joseph Weizenbaum in Communications of the ACM, January 1966.
//
// Ported to a Java Applet by Charles Hayden around 2003, http://chayden.net/Index.shtml
//   "A complete and faithful implementation of the program described by Weizenbaum"
//   "You are welcome to make use of it however you want."
//
// Modifed for the command line (tested on bash) by Professor George F. Rice in 2025.

public class Eliza {

    public static void main(String args[]) {

        // Create the therapist
        ElizaMain eliza;
        if (args.length > 0) eliza = new ElizaMain(args[0]);
        else eliza = new ElizaMain();

        // Enable reading input from the terminal
        Scanner in = new Scanner(System.in);
        String userInput = "";
        
        // Run Eliza
        try {
            while (!eliza.finished()) {

                // Get user's next input
                if(userInput.isEmpty()) {
                    userInput = eliza.welcome;
                } else {
                    System.out.print(">> ");
                    userInput = in.nextLine();
                    if(userInput == null) userInput = eliza.farewell;
                }
                
                // Get response from AI
                String reply = eliza.processInput(userInput);
                System.out.println(reply);
            }
        } catch (Exception e) {
            System.out.println("\n\nEliza had to leave.\nPlease call again soon!\n");
            e.printStackTrace();
        }
    }

}

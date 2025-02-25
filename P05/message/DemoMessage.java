package message;

import account.Account;

import java.util.ArrayList;

public class DemoMessage {
    public static void main(String[] args) {
        Account a1 = new Account("Prof Rice");
        Account a2 = new Account("UTA Student");
        Account a3 = new Account("Excellent Student");

        System.out.println("Here are 3 accounts for the demo.\nThe user name is followed by the account number in parentheses.\n");
        System.out.println("" + a1 + '\n' + a2 + '\n' + a3 + '\n');
        
        ArrayList<Message> messages = new ArrayList<>();
        Message m1 = new Message(a1, null, "Welcome to Abuta! But what's an abuta?");
        Message m2 = new Message(a2, m1, "An abuta is a flowering vine useful as an herbal medicine.");
        Message m3 = new Message(a3, m2, "But it's also used to make curare, a blowgun poison!\nDon't be sharp-tongued on our forums, please - it can be deadly. :)");
        Message m4 = new Message(a3, m1, "Abuta is also a type of seashell-based money exchanged for useful things - like interesting stories and helpful advice!");
        
        System.out.println("This first message starts a new thread:\n===\n\n" + m1 + "\n===");
        System.out.println("This leads to a response, which also draws a response!:\n===\n\n" + m2 + "\n===\n" + m3 + "\n===");
        System.out.println("And the final contributor also replies to the first message:\n===\n\n" + m4);
    }

}

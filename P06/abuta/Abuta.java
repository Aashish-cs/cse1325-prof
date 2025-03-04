package abuta;

import menu.Menu;
import menu.MenuItem;

import account.Account;
import account.AccountStatus;

import message.Message;
import message.DirectMessage;
import message.Post;
import message.Group;

import java.util.List;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Abuta {
    public static void main(String[] args) {
        Abuta abuta = new Abuta();
        abuta.mdi();
    }        

    public Abuta() {
        accounts = new ArrayList<>();
        accounts.add(new Account("Gandalf the Grey"));
        accounts.add(new Account("Frodo Baggins"));
        accounts.add(new Account("Samwise Gamgee"));
        accounts.add(new Account("Galadriel"));
        accounts.add(new Account("Aragon"));
        accounts.add(new Account("Arwen"));
        accounts.add(new Account("Legolas"));
        accounts.add(new Account("Gimli"));
        accounts.add(new Account("Balrog"));
        
        groups = new ArrayList<>();
        groups.add(new Group("Power"));
        groups.add(new Group("Friendship"));
        groups.add(new Group("Tenacity"));
        groups.add(new Group("Good vs. Evil"));
        groups.add(new Group("Redemption"));
        groups.add(new Group("Immortality"));
        
        newAbuta();
        
        menu = new Menu();
        menu.addMenuItem(new MenuItem("Exit\n",          () -> endApp()));
        menu.addMenuItem(new MenuItem("Show Reply",      () -> showReply()));
        menu.addMenuItem(new MenuItem("Show Replied To", () -> showRepliedTo()));
        menu.addMenuItem(new MenuItem("Add Reply\n",     () -> reply()));
        menu.addMenuItem(new MenuItem("New AbUTA",       () -> newAbuta()));
        menu.addMenuItem(new MenuItem("Save",            () -> save()));
        menu.addMenuItem(new MenuItem("Save As",         () -> saveAs()));
        menu.addMenuItem(new MenuItem("Open",            () -> open()));
        
        filename = "untitled.abuta";
    }
    
    // /////////////////////////////////////////////////////////////////////////
    //                          M A I N   M E N U
    /*
    private static String logo = 
        """
          `-.        _.-' 
           ] `,    .'/.' 
            ]`.`. :.-'.-= .-']
             `-.:/o  .'-'] .'  Go
                o]o / ._].'   Mavs!
         abUTA    ]| /o|]`.
         v0.3.0    |'o `.`.'.
                         `--'
        """.replace(']','\\');
    */
    
    private static String logo = 
    ( " `-.        _.-'" + '\n'
    + "  ] `,    .'/.'" + '\n'
    + "   ]`.`. :.-'.-= .-'/" + '\n'
    + "    `-.:/o  .'-'/ .'  Go" + '\n'
    + "       o]o / ._/.'   Mavs!" + '\n'
    + "abUTA    ]| /o|]`." + '\n'
    + "v0.3.0    |'o `.`.'." + '\n'
    + "                `--'").replace(']','\\');
    
//  private static final String logo = " ".repeat(30) + "- = # a b U T A # = -";    
    private static final String title = "\n".repeat(255) + logo + "\n\n";    
    private static final String sep = "\n" + "~".repeat(80) + "\n";
    private boolean running = true;

    // Method mdi() runs the menu system
    public void mdi() {
        while(running) {
            try {
                System.out.println(title + menu 
                                 + ((output  != null && !output.isEmpty()) ? sep + output : "")
                                 + ((message != null) ? sep + message : ""));
                output = "";
                Integer i = Menu.getInt("\nSelection: ");
                if(i != null) menu.run(i);
            } catch (Exception e) {
                output = "\n\nInvalid command\n" + e + "\n\n";
            } 
        }
    }

    // /////////////////////////////////////////////////////////////////////////
    //                          R E S P O N D E R s
    // These methods implement each command offered in the menu
    private void endApp() {
        running = false;
    }
    
    private void showRepliedTo() {
        Message repliedTo = message.getRepliedTo();
        if(repliedTo != null) message = repliedTo;
        else output += "This is the original message, in reply to no one in Middle Earth.";
    }
    private void showReply() {
        int num = message.getNumReplies();
        if(num == 0) output += "This message has no replies.";
        else if (num == 1) message = message.getReply(0);
        else {
            Integer index = Menu.getInt("Which reply (0 to " + (num-1) + ")? ", "x", "-1");
            if(index != null && index >= 0 && index < num)
                message = message.getReply(index);  
        }  
    }

    private void reply() {
        Account to = null;
        Group group = null;
        Integer index = null;
        
        try {
            char type = ' ';
            while(type != 'P' && type != 'D') {
                String s = Menu.getString("(P)ost or (D)irect Message? ", "x", "P").trim().toUpperCase();
                if(s == null || s.isEmpty()) return;
                type = s.charAt(0);
            }
            boolean isPost = (type == 'P');

            index = Menu.selectItemFromList("Author? ", accounts);
            if(index == null) return;
            Account from = accounts.get(index);
        
            if(isPost) {
                index = Menu.selectItemFromList("Group? ", groups);
                if(index == null) return;
                group = groups.get(index);
                System.out.println("Post from " + from + " in group " + group + ":\n");
            } else {
                index = Menu.selectItemFromList("To? ", accounts);
                if(index == null) return;
                to = accounts.get(index);
                System.out.println("Message from " + from + " to " + to + ":\n");
            }

            String body = Menu.getString(null);
            if(body != null && !body.isEmpty()) {
                Message newMessage = null;
                if(isPost) newMessage = new Post(from, group, message, body);
                else newMessage = new DirectMessage(from, to, message, body);
                message = newMessage;
            }
        } catch(Exception e) {
            output += "ERROR in reply:\n" + e;
        }
    }
    
    private void newAbuta() {
        message = new Post(accounts.get(0), groups.get(0), null, 
            "Welcome to Middle Earth! The journey doesn't end here; it is only the beginning!");
    }

    private void save() {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            Message m = message;
            while(m.getRepliedTo() != null) m = m.getRepliedTo();
            m.save(bw);
        } catch(IOException e) {
            output += "Save I/O ERROR:\n" + e + '\n';
            e.printStackTrace();
        } catch(Exception e) {
            output += "ERROR:\n" + e + '\n';
            e.printStackTrace();
        }
    }

    private void saveAs() {
        String s = Menu.getString("Filename to save (" + filename + "): ", "x", filename);
        if(s != null) {
            filename = s;
            save();
        }
    }

    private void open() {
        String s = Menu.getString("Filename to open (" + filename + "): ", "x", filename);
        if(s != null) {
            filename = s;
            try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
                message = new Post(br, null);
            } catch(IOException e) {
                output += "Open I/O ERROR:\n" + e + '\n';
                e.printStackTrace();
            } catch(Exception e) {
                output += "ERROR:\n" + e + '\n';
                e.printStackTrace();
            }
        }
     }

    private String output; // Collects error message and status to print after the next menu
    private Menu menu;
    private String filename;
    
    private Message message;
    private List<Account> accounts;
    private List<Group> groups;
}

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;

import menu.Menu;
import menu.MenuItem;

public class Main {
    public Main() {
        Menu menu = new Menu();
        menu.addMenuItem(new MenuItem("Save", () -> save()));
    }
    private void save() {
        System.out.print("Filename? "); // OPTIONAL
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(in.nextLine()))) {
            var it = vehicles.iterator();
            // OR Iterator<Vehicle> it = ...
            // OR Iterator it = ...
            while(it.hasNext()) it.next().save(bw);
        } catch(IOException e) {
            System.err.println("Error reading file");
        }
    }
    public static void main(String[] args) {
    }
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private Scanner in = new Scanner(System.in);
}

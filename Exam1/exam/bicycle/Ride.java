import java.util.ArrayList;

public class Ride {
    public static void main(String[] args) {
        ArrayList<Double> gearBox = new ArrayList<>();
        gearBox.add(1.5); gearBox.add(3.6); gearBox.add(5.7);
        try {
            Bicycle b = new Bicycle(Type.Cruiser, gearBox);
            System.out.println(b);
            System.out.println("Pedaling at ratio " + b.pedal(1));
        } catch(IllegalArgumentException e) {
            System.err.println(e);
            System.exit(-1);
        }
    }
}

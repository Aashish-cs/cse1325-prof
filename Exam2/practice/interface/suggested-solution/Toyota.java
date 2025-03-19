public class Toyota implements Driveable {
    @Override
    public void drive() {
        System.out.println("Driving my Toyota on down the road!");
    }
    public static void main(String[] args) {
        Toyota toyota = new Toyota();
        toyota.drive();
    }
}

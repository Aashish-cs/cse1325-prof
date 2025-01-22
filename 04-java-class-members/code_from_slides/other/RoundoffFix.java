public class RoundoffFix {
    public static void main(String[] args) {
        double d1 = 0.1;
        double d2 = 0.2;
        double result = d1 + d2;
        double epsilon = 0.000001;
        System.out.println(d1 + " + " + d2 
            + ((Math.abs(result - 0.3) < epsilon) ? " == " : " != ") + "0.3");
        System.out.println("0.1 + 0.2  = " + result);
    }
}

package message;

public class TestGroup {
    public static void main(String[] args) {
        int result = 0;
        int vector = 1;
        String expected = "";
        String actual = "";
        
        // Test constructor and toString
        Group g1 = new Group("Mavs");
        expected = "Mavs";
        actual = g1.toString();
        if(!expected.equals(actual)) {
            System.err.println("\nERROR: Constructor & toString case");
            System.err.println("----Expected: " + expected);
            System.err.println("----Actual:   " + actual);
            result |= vector;
        }
        vector <<= 1;
        
        // Test isActive and default
        if(!g1.isActive()) {
            System.err.println("\nERROR: isActive default case");
            System.err.println("----Expected: true");
            System.err.println("----Actual:   " + g1.isActive());
            result |= vector;
        }
        vector <<= 1;
        
        // Test disable
        g1.disable();
        if(g1.isActive()) {
            System.err.println("\nERROR: disable case");
            System.err.println("----Expected: false");
            System.err.println("----Actual:   " + g1.isActive());
            result |= vector;
        }
        vector <<= 1;
        
        // Test disabled toString case
        expected = "Mavs [inactive]";
        actual = g1.toString();
        if(!expected.equals(actual)) {
            System.err.println("\nERROR: disabled toString case");
            System.err.println("----Expected: " + expected);
            System.err.println("----Actual:   " + actual);
            result |= vector;
        }
        vector <<= 1;
        
        // Test enable
        vector <<= 1;
        g1.enable();
        expected = "Mavs";
        actual = g1.toString();
        if(!g1.isActive() || !expected.equals(actual)) {
            System.err.println("\nERROR: enable case");
            System.err.println("----Expected: true");
            System.err.println("----Actual:   " + g1.isActive());
            System.err.println("----Expected: " + expected);
            System.err.println("----Actual:   " + actual);
            result |= vector;
        }
        
        // Summarize results
        if(result != 0) 
            System.err.println("\nFAIL: Error code " + result);
        System.exit(result);
    }
}

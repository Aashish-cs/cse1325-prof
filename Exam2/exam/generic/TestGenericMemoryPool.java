public class TestGenericMemoryPool {
    public static void main(String[] args) {
        GenericMemoryPool<String> pool = null;;
        try {
            pool = new GenericMemoryPool<>(4);
        } catch(Exception e) {
           System.err.println("ERROR: unable to allocate 4 element pool:\n" + e);
           System.exit(-1);
        }
        
        Integer i1 = null;
        Integer i2 = null;
        Integer i3 = null;
        Integer i4 = null;
        try {
            i1 = pool.allocate(); pool.set(i1, "Forty two");
            i2 = pool.allocate(); pool.set(i2, "Forty three");
            i3 = pool.allocate(); pool.set(i3, "Forty four");
            i4 = pool.allocate(); pool.set(i4, "Forty five");
        } catch(Exception e) {
           System.err.println("ERROR: unable to get 4 elements:\n" + e);
           System.exit(-2);
        }
        
        
        if(!pool.get(i1).equals("Forty two")   ||
           !pool.get(i2).equals("Forty three") ||
           !pool.get(i3).equals("Forty four")  ||
           !pool.get(i4).equals("Forty five")) 
               System.err.println("ERROR: corrupt elements");
       
        try {
            Integer i5 = pool.allocate();
            System.err.println("ERROR: allocated too many elements");
        } catch(IndexOutOfBoundsException e) {
        } // Success!
       
        try {
            pool.free(i3);
        } catch(Exception e) {
            System.err.println("ERROR: unable to free i3:\n" + e);
        } 
       
        try {
            pool.free(i3);
            System.err.println("ERROR: free i3 twice!");
        } catch(Exception e) {
        } // Success!

        try {
            Integer i5 = pool.allocate();
        } catch(IndexOutOfBoundsException e) {
            System.err.println("ERROR: Unable to reuse free element:\n" + e);
        } 
       
    }
}

public class TestMemoryPool {
    public static void main(String[] args) {
        MemoryPool pool = null;;
        try {
            pool = new MemoryPool(4);
        } catch(Exception e) {
           System.err.println("ERROR: unable to allocate 4 element pool:\n" + e);
           System.exit(-1);
        }
        
        Integer i1 = null;
        Integer i2 = null;
        Integer i3 = null;
        Integer i4 = null;
        try {
            i1 = pool.allocate(); pool.set(i1, 42);
            i2 = pool.allocate(); pool.set(i2, 43);
            i3 = pool.allocate(); pool.set(i3, 44);
            i4 = pool.allocate(); pool.set(i4, 45);
        } catch(Exception e) {
           System.err.println("ERROR: unable to get 4 elements:\n" + e);
           System.exit(-2);
        }
        
        
        if(pool.get(i1) != 42 ||
           pool.get(i2) != 43 ||
           pool.get(i3) != 44 ||
           pool.get(i4) != 45) 
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
            System.err.println("ERROR: Unable to reuse freed element:\n" + e);
        } 
       
    }
}

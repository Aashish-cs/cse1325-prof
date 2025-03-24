public class FindPrimesThreaded {
    public static boolean isPrime(int value) {
        if(value < 2) return false;
        for(int i=2; i <= Math.sqrt(value); ++i)
            if(value % i == 0) return false;
        return true;
    }
    private static int first;
    private static int last;
    
    // a. WRITE static method getInt() here to safely provide
    //   ints from first through last to the threads, then -1
    private static synchronized int getInt() {
        if(first <= last) return first++;
        return -1;
    }
    // This will be your thread body - REWRITE to check
    //   ints obtained from your getInt() method above
    private static void search() {
         int value;
         while((value = getInt()) >= 0) {
             if(isPrime(value)) System.out.println(value);
         }
    }
    public static void main(String[] args) throws InterruptedException{
        first = Integer.parseInt(args[0]); // start at first argument
        last  = Integer.parseInt(args[1]); // stop after last argument
        
        // Create 5 threads here each running search()
        Thread[] threads = new Thread[5];
        for(int i=0; i< 5; ++i) {
            threads[i] = new Thread(() -> search()); 
        //  threads[i] = new Thread(this::search); does NOT work! What's "this"?
            threads[i].start();
        }
        // Join the threads before exiting
        for(int i=0; i< 5; ++i) 
            threads[i].join();
    }
}

public class FindPrimes {
    public static boolean isPrime(int value) {
        if(value < 2) return false;
        for(int i=2; i <= Math.sqrt(value); ++i)
            if(value % i == 0) return false;
        return true;
    }
    private static int first;
    private static int last;

    // a. WRITE static method getInt() here to safely provide
    //    ints from first through last to the threads, then -1

    // b. This will be your thread body - REWRITE to check
    //    ints obtained from your getInt() method above
    private static void search() {
        while(first <= last) {
            if(isPrime(first)) System.out.println(first);
            ++first;
        }
    }

    public static void main(String[] args) {
        first = Integer.parseInt(args[0]); // start at first argument
        last  = Integer.parseInt(args[1]); // stop after last argument
        
        // c. Create 5 threads here each running search()
        search();
        //    Join the threads before exiting
    }
}

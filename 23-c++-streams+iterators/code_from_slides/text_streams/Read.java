import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Read {
    public static void main(String[] args) throws IOException { 
        // We would normally use a try-with-resources here.
        // We use "throws IOException" instead to show symmetry with C++.
        BufferedReader br = new BufferedReader(new FileReader((args[0])));
        String s;
        while((s=br.readLine())!=null) System.out.println(s); 
    }
}


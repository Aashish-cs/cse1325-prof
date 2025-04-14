import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Write {
    public static void main(String[] args) throws IOException {
        // We would normally use a try-with-resources here.
        // We use "throws IOException" instead to show symmetry with C++.
        BufferedWriter br = new BufferedWriter(new FileWriter(args[0]));
        br.write("Writing this to " + args[0] + "\n");
        br.close(); // flush buffer (NOT required for try-with-resources)
    }
}


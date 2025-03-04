package account;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Account {
    public Account(String name) {
        if(name.isEmpty()) 
            throw new IllegalArgumentException("Account name cannot be zero-length");
        this.name = name;
        this.id = nextID++;
        this.status = AccountStatus.Normal;
    }
    public Account(BufferedReader br) throws IOException {
        name = br.readLine();
        status = AccountStatus.valueOf(br.readLine());
        id = Integer.parseInt(br.readLine());
        nextID = Integer.parseInt(br.readLine());
    }
    public void save(BufferedWriter bw) throws IOException {
        bw.write(name + '\n');
        bw.write(status.name() + '\n');
        bw.write("" + id + '\n');
        bw.write("" + nextID + '\n');
    }
    public void setStatus(AccountStatus status) {
        this.status = status;
    }
    public boolean isMuted() {
        return status != AccountStatus.Normal;
    }
    public boolean isBlocked() {
        return status == AccountStatus.Blocked;
    }
    @Override
    public String toString() {
        return name + " (" + id + ")"
             + ((status == AccountStatus.Normal) ? "" : " [" + status + "]");
    }
    private String name;
    private AccountStatus status;
    private int id;
    private static int nextID = 1;
}

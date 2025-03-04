package message;

import account.Account;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class DirectMessage extends Message {
    public DirectMessage(Account from, Account to, Message repliedTo, String body) {
        super(from, repliedTo, body);
        this.to = to;
    }
    public DirectMessage(BufferedReader br, Message repliedTo) throws IOException {
        super(br, repliedTo);
        to = new Account(br);
    }
    public void save(BufferedWriter bw) throws IOException {
        super.save(bw);
        to.save(bw);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("To: " + to + '\n');
        sb.append(super.toString());
        return sb.toString();
    }
    private Account to;
}

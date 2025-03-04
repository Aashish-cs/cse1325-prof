package message;

import account.Account;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Post extends Message {
    public Post(Account from, Group group, Message repliedTo, String body) {
        super(from, repliedTo, body);
        this.group = group;
    }
    public Post(BufferedReader br, Message repliedTo) throws IOException {
        super(br, repliedTo);
        group = new Group(br);
    }
    public void save(BufferedWriter bw) throws IOException {
        super.save(bw);
        group.save(bw);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Group: " + group + '\n');
        sb.append(super.toString());
        return sb.toString();
    }
    private Group group;
}

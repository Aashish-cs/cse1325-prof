package message;

import account.Account;

public class Post extends Message {
    public Post(Account from, Group group, Message repliedTo, String body) {
        super(from, repliedTo, body);
        this.group = group;
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

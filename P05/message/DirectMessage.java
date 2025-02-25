package message;

import account.Account;

public class DirectMessage extends Message {
    public DirectMessage(Account from, Account to, Message repliedTo, String body) {
        super(from, repliedTo, body);
        this.to = to;
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

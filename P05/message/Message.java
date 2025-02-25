package message;

import account.Account;
import account.AccountStatus;

import java.util.Date;
import java.util.ArrayList;

public class Message {
    public Message(Account from, Message repliedTo, String body) {
        this.from = from;
        this.date = new Date();
        this.repliedTo = repliedTo;
        if(repliedTo != null) repliedTo.addReply(this);
        this.replies = new ArrayList<>();
        this.body = body;
    }
    public Message getRepliedTo() {
        return repliedTo;
    }
    public int getNumReplies() {
        return replies.size();
    }
    public Message getReply(int index) {
        Message m = null;
        if(index >= 0 && index < replies.size())
            m =replies.get(index);
        return m;
    }
    public String getTitle() {
        return "From " + from; // + " on " + date;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Date: " + date + '\n');
        sb.append("From: " + from + '\n');
        if(repliedTo != null) 
            sb.append("In reply to: " + repliedTo.from + '\n');
        if(!replies.isEmpty()) {
            sb.append("Replies: ");
            String separator = "";
            for(int i=0; i<replies.size(); ++i) {
                sb.append(separator + "[" + i + "] " + replies.get(i).from);
                separator = ", ";
            }
            sb.append('\n');
        }
        sb.append("\n" + body + '\n');
        return sb.toString();
    }
    
    private void addReply(Message message) {
        replies.add(message);
    }
    protected Account from;
    protected Date date;
    protected Message repliedTo;
    protected ArrayList<Message> replies;
    protected String body;
}

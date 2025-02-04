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
    public Message getReply(int index) {
        Message m = null;
        if(index >= 0 && index < replies.size())
            m =replies.get(index);
        return m;
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
            for(Message m : replies) {
                sb.append(separator + m.from);
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
    private Account from;
    private Date date;
    private Message repliedTo;
    private ArrayList<Message> replies;
    private String body;
}

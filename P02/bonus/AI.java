import java.util.Stack;

public class AI {
    public AI(Engine engine) {
        this.engine = engine;
        this.queries = new Stack<>();
    }
    public String query(String query) {
        queries.push(query);
        return "That's a puzzler!";
    }
    public Stack getQueryHistory() {
        return queries;
    }

    private Engine engine;
    private Stack<String> queries;
}

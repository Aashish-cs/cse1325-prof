public class AI {
    public AI(Engine engine) {
        this.engine = engine;
        this.queries = new String[5];
    }
    public String query(String query) {
        for(int i=queries.length-1; i>0; --i)
            queries[i] = queries[i-1];
        queries[0] = query;
        return "That's a puzzler!";
    }
    public String[] getQueryHistory() {
        return queries;
    }

    private Engine engine;
    private String[] queries;
}

abstract class Cutlery {
    protected Pattern pattern;
    public Cutlery(Pattern pattern) {
        this.pattern = pattern;
    }
    abstract void use();
}


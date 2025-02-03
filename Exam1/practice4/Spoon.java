class Spoon extends Cutlery implements Washable {
    private boolean clean;
    public Spoon(Pattern pattern) {
        super(pattern);
        clean = true;
    }
    @Override
    public void use() {
        if(!clean) throw new UnhygienicException(this);
        System.out.println("Stirring with " + toString());
        clean = false;
    }
    @Override
    public void wash() {
        System.out.println("Washing " + toString());
        clean = true;
    }
    @Override
    public String toString() {
        return (clean ? "Clean " : "Dirty ") + pattern + " spoon";
    }
}


public abstract class Color {
    Color(String name) {
        this.name = name;
    }
    protected static double rgbBrightness(double r, double g, double b) {
        return 0.2126*r + 0.7152*g + 0.0722*b;
    }
    public abstract double brightness();
    private String name;
}

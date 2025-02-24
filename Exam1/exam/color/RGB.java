public class RGB extends Color {
    public RGB(String name, double r, double g, double b) {
        super(name);
        this.r = r;
        this.g = g;
        this.b = b;
    }
    @Override
    public double brightness() {
        return super.rgbBrightness(r, g, b);
    }
    private double r;
    private double g;
    private double b;
}

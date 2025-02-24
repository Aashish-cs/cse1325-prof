public class CMY extends Color {
    public CMY(String name, double c, double m, double y) {
        super(name);
        this.c = c;
        this.m = m;
        this.y = y;
    }
    @Override
    public double brightness() {
        return super.rgbBrightness(1-c, 1-m, 1-y);
    }
    private double c;
    private double m;
    private double y;
}

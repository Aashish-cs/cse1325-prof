public class CMYK extends Color {
    public CMYK(String name, double c, double m, double y, double k) {
        super(name);
        this.c = c;
        this.m = m;
        this.y = y;
        this.k = k;
    }
    @Override
    public double brightness() {
        return super.rgbBrightness((1-c)*(1-k), (1-m)*(1-k), (1-y)*(1-k));
    }
    private double c;
    private double m;
    private double y;
    private double k;
}

public class HSV extends Color {
    public HSV(String name, double h, double s, double v) {
        super(name);
        this.h = h;
        this.s = s;
        this.v = v;
    }
    @Override
    public double brightness() {
        return v;
    }
    private double h;
    private double s;
    private double v;
}

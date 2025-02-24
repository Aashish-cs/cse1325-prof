public class HSL extends Color {
    public HSL(String name, double h, double s, double l) {
        super(name);
        this.h = h;
        this.s = s;
        this.l = l;
    }
    @Override
    public double brightness() {
        return l;
    }
    private double h;
    private double s;
    private double l;
}

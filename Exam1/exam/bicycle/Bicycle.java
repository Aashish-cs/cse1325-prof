import java.util.ArrayList;

public class Bicycle {
    public Bicycle(Type type, ArrayList<Double> gearRatio) {
        if(gearRatio == null || gearRatio.isEmpty())
            throw new IllegalArgumentException("Bad gearbox");
        this.gearRatio = gearRatio;
        this.type = type;
    }
    public double pedal(int gear) {
        if(gear<0 || gear >= gearRatio.size()) return -1;
        return gearRatio.get(gear);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("" + type);
        sb.append(" " + gearRatio.size() + "-speed with ratios ");
        String separator = "";
        for(double ratio : gearRatio) {
            sb.append(separator + ratio);
            separator = ", ";
        }
        return sb.toString();
    }
    private ArrayList<Double> gearRatio;
    private Type type;
}

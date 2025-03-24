import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Petrol extends Vehicle {
  private int gallons;
  private double efficiency; // miles per gallons
  public Petrol(Automakers make, String model, int gallons, double efficiency) {
      super(make, model);
      this.gallons = gallons;
      this.efficiency = efficiency;
  }
  public Petrol(BufferedReader br) throws IOException {  
      super(br);
      this.gallons = Integer.parseInt(br.readLine());
      this.efficiency = Double.parseDouble(br.readLine());
  }
  @Override
  public void save(BufferedWriter bw) throws IOException {
      super.save(bw);
      bw.write("" + gallons + "\n");
      bw.write("" + efficiency + "\n");
  }
  @Override
  public int range() {
      return (int) (efficiency * (double) gallons); // miles
  }
}

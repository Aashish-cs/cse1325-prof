import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Electric extends Vehicle {
  private int kWh;
  private double efficiency; // miles per kWh
  public Electric(Automakers make, String model, int kWh, double efficiency) {
      super(make, model);
      this.kWh = kWh;
      this.efficiency = efficiency;
  }
  public Electric(BufferedReader br) throws IOException {  
      super(br);
      this.kWh = Integer.parseInt(br.readLine());
      this.efficiency = Double.parseDouble(br.readLine());
  }
  @Override
  public void save(BufferedWriter bw) throws IOException {
      super.save(bw);
      bw.write("" + kWh + "\n");
      bw.write("" + efficiency + "\n");
  }
  @Override
  public int range() {
      return (int) (efficiency * (double) kWh); // miles
  }
}

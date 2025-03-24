import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.Objects;

public abstract class Vehicle {
  protected String model;
  protected Automakers make;
  public Vehicle(Automakers make, String model) {
      this.make = make;
      this.model = model;
  }
  public Vehicle(BufferedReader br) throws IOException {
      this.make = Automakers.valueOf(br.readLine());
      this.model = br.readLine();
  }
  public void save(BufferedWriter bw) throws IOException {
      bw.write("" + make + "\n");
      bw.write("" + model + "\n");
  }
  @Override
  public boolean equals(Object o) {
      if(o == this) return true;
      if(o == null || o.getClass() == this.getClass()) return false;
      Vehicle v = (Vehicle) o;
      return this.make == v.make
          && this.model == v.model;
  }
  @Override
  public int hashCode() {
      return Objects.hash(make, model);
  }
  public abstract int range();

}

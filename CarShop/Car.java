import java.io.Serializable;

public class Car  implements Serializable {
	private String model;
	private String color;
	private int mileage;
	private String plate;

	public Car(String model, String color, int mileage) {
		this.model = model;
		this.color = color;
		this.mileage = mileage;
		this.plate = "undefined";
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	public String getModel() {
		return model;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getColor() {
		return color;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public int getMileage() {
		return mileage;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	public String getPlate() {
		return plate;
	}
	
	@Override
	public String toString() {
		return "Car Model: " + getModel() + ", Car Color: " + getColor() + ", Car Mileage: "
				+ getMileage() + "miles, Car Plate: " + getPlate();
	}
}

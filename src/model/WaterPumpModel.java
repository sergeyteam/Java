package model;

public class WaterPumpModel {
	
 /* nameOfPump - наименование
 * machineCapacity - производительность, л/мин.	
 * fall - напор максимальный, м	
 * quantityOfClacks - количество клапанов забора воды, шт.	
 * powerLevel - мощность, вт	
 * diameter - диаметр корпуса, мм	
 * typeOfDrawingOfWater - забор воды	
 * mass - масса, кг	
 * inputVoltage - напряжение питания, в	
 * maker - изготовитель
 * price - цена	
 */
	
	private int id;
	private String nameOfPump;
	private int machineCapacity;
	private int fall;
	private int quantityOfClacks;
	private int powerLevel;
	private double diameter;
	private String typeOfDrawingOfWater;
	private double mass;
	private int inputVoltage;
	private String maker;
	private int price;
	private boolean b;
	private String image;
	
	public WaterPumpModel() {}
	
	public WaterPumpModel(int id, String nameOfPump, int machineCapacity, int fall, int quantityOfClacks, int powerLevel, double diameter, String typeOfDrawingOfWater, double mass, int inputVoltage, String maker, int price, boolean b, String image) {
		this.id = id;
		this.nameOfPump = nameOfPump;
		this.machineCapacity = machineCapacity;
		this.fall = fall;
		this.quantityOfClacks = quantityOfClacks;
		this.powerLevel = powerLevel;
		this.diameter = diameter;
		this.typeOfDrawingOfWater = typeOfDrawingOfWater;
		this.mass = mass;
		this.inputVoltage = inputVoltage;
		this.maker = maker;
		this.price = price;
		this.b = b;
		this.image = image;
	}
	
	public WaterPumpModel(String nameOfPump, int machineCapacity, int fall, int quantityOfClacks, int powerLevel, double diameter, String typeOfDrawingOfWater, double mass, int inputVoltage, String maker, int price, boolean b, String image) {
		this.nameOfPump = nameOfPump;
		this.machineCapacity = machineCapacity;
		this.fall = fall;
		this.quantityOfClacks = quantityOfClacks;
		this.powerLevel = powerLevel;
		this.diameter = diameter;
		this.typeOfDrawingOfWater = typeOfDrawingOfWater;
		this.mass = mass;
		this.inputVoltage = inputVoltage;
		this.maker = maker;
		this.price = price;
		this.b = b;
		this.image = image;
	}
	
	public WaterPumpModel(int id, String nameOfPump, int machineCapacity, int fall, int quantityOfClacks, int powerLevel, double diameter, String typeOfDrawingOfWater, double mass, int inputVoltage, String maker, int price, String image) {
		this.id = id;
		this.nameOfPump = nameOfPump;
		this.machineCapacity = machineCapacity;
		this.fall = fall;
		this.quantityOfClacks = quantityOfClacks;
		this.powerLevel = powerLevel;
		this.diameter = diameter;
		this.typeOfDrawingOfWater = typeOfDrawingOfWater;
		this.mass = mass;
		this.inputVoltage = inputVoltage;
		this.maker = maker;
		this.price = price;
		this.image = image;
	}
	
	@Override
	public String toString() {
		return "WaterPumpModel [id = " + id + ", name_of_pump = " + nameOfPump + ", machine_capacity = " + machineCapacity
				+ ", fall = " + fall + ", quantity_of_clacks = " + quantityOfClacks + ", power_level = " + powerLevel
				+ ", diameter = " + diameter + ", type_of_drawing_of_water = " + typeOfDrawingOfWater + ", mass = " + mass
				+ ", input_voltage = " + inputVoltage + ", maker = " + maker + ", price = " + price + ", status = " + b + ", image = " + image + "]";
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (b ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(diameter);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + fall;
		result = prime * result + id;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + inputVoltage;
		result = prime * result + machineCapacity;
		result = prime * result + ((maker == null) ? 0 : maker.hashCode());
		temp = Double.doubleToLongBits(mass);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((nameOfPump == null) ? 0 : nameOfPump.hashCode());
		result = prime * result + powerLevel;
		result = prime * result + price;
		result = prime * result + quantityOfClacks;
		result = prime * result + ((typeOfDrawingOfWater == null) ? 0 : typeOfDrawingOfWater.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WaterPumpModel other = (WaterPumpModel) obj;
		if (b != other.b)
			return false;
		if (Double.doubleToLongBits(diameter) != Double.doubleToLongBits(other.diameter))
			return false;
		if (fall != other.fall)
			return false;
		if (id != other.id)
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (inputVoltage != other.inputVoltage)
			return false;
		if (machineCapacity != other.machineCapacity)
			return false;
		if (maker == null) {
			if (other.maker != null)
				return false;
		} else if (!maker.equals(other.maker))
			return false;
		if (Double.doubleToLongBits(mass) != Double.doubleToLongBits(other.mass))
			return false;
		if (nameOfPump == null) {
			if (other.nameOfPump != null)
				return false;
		} else if (!nameOfPump.equals(other.nameOfPump))
			return false;
		if (powerLevel != other.powerLevel)
			return false;
		if (price != other.price)
			return false;
		if (quantityOfClacks != other.quantityOfClacks)
			return false;
		if (typeOfDrawingOfWater == null) {
			if (other.typeOfDrawingOfWater != null)
				return false;
		} else if (!typeOfDrawingOfWater.equals(other.typeOfDrawingOfWater))
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameOfPump() {
		return nameOfPump;
	}

	public void setNameOfPump(String nameOfPump) {
		this.nameOfPump = nameOfPump;
	}

	public int getMachineCapacity() {
		return machineCapacity;
	}

	public void setMachineCapacity(int machineCapacity) {
		this.machineCapacity = machineCapacity;
	}

	public int getFall() {
		return fall;
	}

	public void setFall(int fall) {
		this.fall = fall;
	}

	public int getQuantityOfClacks() {
		return quantityOfClacks;
	}

	public void setQuantityOfClacks(int quantityOfClacks) {
		this.quantityOfClacks = quantityOfClacks;
	}

	public int getPowerLevel() {
		return powerLevel;
	}

	public void setPowerLevel(int powerLevel) {
		this.powerLevel = powerLevel;
	}

	public double getDiameter() {
		return diameter;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	public String getTypeOfDrawingOfWater() {
		return typeOfDrawingOfWater;
	}

	public void setTypeOfDrawingOfWater(String typeOfDrawingOfWater) {
		this.typeOfDrawingOfWater = typeOfDrawingOfWater;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	public int getInputVoltage() {
		return inputVoltage;
	}

	public void setInputVoltage(int inputVoltage) {
		this.inputVoltage = inputVoltage;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isB() {
		return b;
	}

	public void setB(boolean b) {
		this.b = b;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}

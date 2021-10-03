
public class Display implements observer {
	
	WeatherStation station;
	int LastTemperature;
	String name;
	
	Display(WeatherStation station, String name) {
		this.name = name;
		this.station = station;
		this.station.addObserver(this);
		update();
	}

	@Override
	public void update() {
		LastTemperature = this.station.CurrentTemperature;
		display();
	}
	
	public void display() {
		System.out.println("[" + name + "] The temperature is " + LastTemperature + " degrees Celcius");
	}
	
}

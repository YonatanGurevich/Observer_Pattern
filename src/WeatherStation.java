import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class WeatherStation implements observable {
	
	ArrayList<observer> observers = new ArrayList<observer>();
	int CurrentTemperature;  // The temperature will be updated once at display object initialization,
							 // And every 2 seconds getTemperature method will be invoked and if a new 
							 // temperature will be "detected", all displays will be updated.
	
	WeatherStation() {
	}

	@Override
	public void addObserver(observer o) {
		this.observers.add(o);
	}

	@Override
	public void removeObserver(observer o) {
		this.observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).update();
		}
	}
	
	public void getTemperature(Scanner scanner) {
		int newTemperature = scanner.nextInt();
		if (this.CurrentTemperature == 0) {
			if (newTemperature != this.CurrentTemperature) {
				this.CurrentTemperature = newTemperature;
				this.notifyObservers();
			}
			else {};
		}
		
		else if (newTemperature != this.CurrentTemperature) {
			this.CurrentTemperature = newTemperature;
			this.notifyObservers();
		}
		else {};
	}

}

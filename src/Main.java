import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, InterruptedException {

		File file = new File("Thermometer.txt");
		
		WeatherStation my_station = new WeatherStation();
		Scanner scanner = new Scanner(file);
		my_station.getTemperature(scanner);
		scanner.close();

		Display monitor = new Display(my_station, "Bedroom monitor");
		Display phone = new Display(my_station, "Phone");
		
		while (true) {
			Scanner temp_scanner = new Scanner(file);
			my_station.getTemperature(temp_scanner);
			scanner.close();
			TimeUnit.SECONDS.sleep(2);
		}
	}

}

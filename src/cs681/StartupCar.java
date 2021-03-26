package cs681;
import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class StartupCar
{
	public static void main(String[] args)
	{
		ArrayList<Car> cars = new ArrayList<Car>();
		cars.add(Car.createCar("Mazda", "Miata", 3200, 2015, 200000.00f));
		cars.add(Car.createCar("Jaguar", "F-Type", 120000, 2020, 160000.f));
		cars.add(Car.createCar("Honda", "Element", 1500, 2007, 29995.00f));
		cars.add(Car.createCar("GMC", "Yukon", 25300, 2003, 2200.00f));
		int ranking;

		Collections.sort(cars, (Car c1,  Car c2) -> c2.getYear() - c1.getYear());
		System.out.println("--Year comparison--\n");
		ranking = 1;
		for (Car carByYear: cars) {
			System.out.println("#" + ranking);
			System.out.println(carByYear + "\n");
			ranking++;	
		}

		Collections.sort(cars, (Car c1,  Car c2) -> c1.getMileage() - c2.getMileage());
		System.out.println("--Mileage comparison--\n");
		ranking = 1;
		for (Car carByMileage: cars) {
			System.out.println("#" + ranking);
			System.out.println(carByMileage + "\n");
			ranking++;	
		}

		for (Car carByPareto: cars) {
			carByPareto.setDominationCount(cars);
		}
		Collections.sort(cars, (Car c1,  Car c2) -> c2.getDominationCount() - c1.getDominationCount());
		System.out.println("--Pareto comparison--\n");
		ranking = 1;
		for (Car carByPareto: cars) {
			System.out.println("#" + ranking);
			System.out.println(carByPareto + "\n");
			ranking++;	
		}
	}
}


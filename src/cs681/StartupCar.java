package cs681;
import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.*;
import java.util.List;

public class StartupCar
{
	public static void main(String[] args)
	{
		ArrayList<Car> cars = new ArrayList<Car>();

		cars.add(Car.createCar("Mazda", "Miata", 3200, 2015, 200000));
		cars.add(Car.createCar("Jaguar", "F-Type", 120000, 2020, 160000));
		cars.add(Car.createCar("Honda", "Element", 1500, 2007, 29995));
		cars.add(Car.createCar("GMC", "Yukon", 25300, 2003, 2200));

		// price comparison
		List<Car> carsByPrice =
			cars.stream()
				.sorted( (Car car1, Car car2)->car1.getPrice()-car2.getPrice() )
				.collect( Collectors.toList() );

		System.out.println("\n\n--Price Comparison--\n");
		carsByPrice.forEach( (Car car)->System.out.println(car) );


		// mileage comparison
		List<Car> carsByMileage =
			cars.stream()
				.sorted( (Car car1, Car car2)->car1.getMileage()-car2.getMileage() )
				.collect( Collectors.toList() );

		System.out.println("\n\n--Mileage Comparison--\n");
		carsByMileage.forEach( (Car car)->System.out.println(car) );


		// year comparison
		List<Car> carsByYear =
			cars.stream()
				.sorted( (Car car1, Car car2)->car2.getYear()-car1.getYear() )
				.collect( Collectors.toList() );

		System.out.println("\n\n--Year Comparison--\n");
		carsByYear.forEach( (Car car)->System.out.println(car) );


		// pareto comparison
		for (Car carByPareto: cars) {
			carByPareto.setDominationCount(cars);
		}
		List<Car> carsByPareto =
			cars.stream()
				.sorted( (Car car1, Car car2)->car1.getDominationCount()-car2.getDominationCount() )
				.collect( Collectors.toList() );

		System.out.println("\n\n--Pareto Comparison--\n");
		carsByPareto.forEach( (Car car)->System.out.println(car) );
	}
}


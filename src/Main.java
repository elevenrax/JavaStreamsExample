import Model.Car;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 *  Streams in Java 8
 */
public class Main {

    public static void main(String[] args) {
        // Make some cars
        Car c1 = new Car("Holden", "VE SSV", Car.Cylinder.EIGHT, 50000);
        Car c2 = new Car("Ford", "BA Falcon", Car.Cylinder.SIX, 30000);
        Car c3 = new Car("Mercedes-Benz", "E500", Car.Cylinder.EIGHT, 140000);
        Car c4 = new Car("McLaren", "P1", Car.Cylinder.EIGHT, 667000);
        Car c5 = new Car("BMW", "335i", Car.Cylinder.SIX, 68000);
        Car c6 = new Car("Holden", "Commodore Exec", Car.Cylinder.SIX, 27000);


        // Load up List
        List<Car> carList = new ArrayList<>();
        carList.add(c1);
        carList.add(c2);
        carList.add(c3);
        carList.add(c4);
        carList.add(c5);
        carList.add(c6);


        /*
            Demonstrate Stream Features in Java 8
         */

        // First off, lets fix our cars. We haven't said they are all new.
        carList.forEach(car -> car.setNewCar(true));

        // Make sure the update worked
        System.out.println("Ensure all our cars are marked as new :");
        carList.forEach(car ->
            System.out.printf("%s %s is new: %s\n", car.getMake(), car.getModel(), car.isNewCar())
        );


        // What distinct brands of cars do we sell?
        Set<String> carBrand =
                carList.stream()
                    .map( Car::getMake )
                    .collect( Collectors.toCollection( HashSet::new ) );

        System.out.println("\nDistinct Brands: ");
        System.out.println( carBrand.toString() );


        // A customer is only interested in eight cylinder cars, let's check our stock for them
        List<Car> eightCylinderCars =
                carList.stream()
                .filter(car -> car.getCylinder() == Car.Cylinder.EIGHT)
                .collect(Collectors.toList());

        System.out.println("\n8 Cylinder Cars");
        System.out.println( eightCylinderCars.toString() );


        // All eight cylinder cars, under 60,000, that are new
        List<Car> eightCylUnderSixtyThousandsNew =
                carList.stream()
                        .filter(car ->  car.getCylinder() == Car.Cylinder.EIGHT &&
                                        car.isNewCar() == true &&
                                        car.getPrice() < 60000
                        )
                        .collect(Collectors.toList());

        System.out.println("\n8 Cylinder Cars, Under 60000, that are new");
        System.out.println( eightCylUnderSixtyThousandsNew.toString() );


        // What is the average cost of all the cars we have for sale?
        DecimalFormat df2 = new DecimalFormat("#,###.##");

        double avgCost = carList.stream()
                .mapToInt( Car::getPrice )
                .average().getAsDouble();

        System.out.println("\nAverage price of all cars is: $" + df2.format(avgCost));


        // Let's do the above, but only for Australian Made cars
        double avgAusCarCost = carList.stream()
                .filter(m -> m.getMake().equals("Holden") || m.getMake().equals("Ford"))
                .mapToInt( Car::getPrice )
                .average().getAsDouble();

        System.out.println("\nAverage price of Australian-made cars is: $" + df2.format(avgAusCarCost));

    }
}

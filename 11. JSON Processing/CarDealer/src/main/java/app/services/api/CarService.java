package app.services.api;

import app.dtos.bindings.CarDto;
import app.dtos.views.CarByMakeView;
import app.dtos.views.CarsPartsView;
import app.entities.Car;

import java.util.List;

public interface CarService {
    void save(Car car);

    void saveAll(CarDto[] cars);

    List<CarByMakeView> getCarsByMake(String make);

    List<CarsPartsView> getAllCarsWithTheirParts();
}

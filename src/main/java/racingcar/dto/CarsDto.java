package racingcar.dto;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class CarsDto {
    private final List<String> names;

    public CarsDto(List<String> names) {
        this.names = names;
    }
    
    public Cars toEntity() {
        List<Car> cars = names.stream()
            .map(Car::new)
            .collect(Collectors.toList());
        return new Cars(cars);
    }
}

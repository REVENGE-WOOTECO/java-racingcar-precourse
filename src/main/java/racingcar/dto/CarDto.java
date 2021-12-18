package racingcar.dto;

import racingcar.domain.Car;
import racingcar.domain.Position;

public class CarDto {
    private final String name;
    private final Position position;

    private CarDto(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public static CarDto from(Car car) {
        return new CarDto(car.getName(), car.getPosition());
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}

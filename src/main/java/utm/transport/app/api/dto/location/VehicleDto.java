package utm.transport.app.api.dto.location;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VehicleDto {

    private String nameOfRoute;
    private Long vehicleId;
    private List<String> predictedRoute;
    private double speed;

    private VehicleDto() {}

    public static VehicleDto toDto (String nameOfRoute, Long vehicleId, List<String> predictedRoute, double speed) {
        VehicleDto dto = new VehicleDto();

        dto.setNameOfRoute(nameOfRoute);
        dto.setVehicleId(vehicleId);
        dto.setPredictedRoute(predictedRoute);
        dto.setSpeed(speed);

        return dto;
    }

}

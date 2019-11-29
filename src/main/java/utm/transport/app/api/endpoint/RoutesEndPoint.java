package utm.transport.app.api.endpoint;

import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utm.transport.app.api.dto.location.RoutePathDto;
import utm.transport.app.entity.location.RoutePath;
import utm.transport.app.service.location.VehicleService;

import java.util.Optional;

@RestController
@RequestMapping(value = "/v1/vehicle", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api("Locations information")
public class RoutesEndPoint {

    private VehicleService service;

    public RoutesEndPoint(VehicleService service) {
        this.service = service;
    }

    @GetMapping("/route/path/{id}")
    public ResponseEntity<RoutePathDto> getVehicleInfo (@PathVariable("id") String id) {
        Optional<RoutePath> optionalRoutePath = service.getRoutePath(id);
        RoutePathDto dto = RoutePathDto.fromEntity(optionalRoutePath.get());
        return ResponseEntity.ok(dto);
    }
}

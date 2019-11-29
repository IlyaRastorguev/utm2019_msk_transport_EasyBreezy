package utm.transport.app.service.location;

import utm.transport.app.entity.location.RoutePath;

import java.util.Optional;

public interface VehicleService {
    Optional<RoutePath> getRoutePath(String id);
}

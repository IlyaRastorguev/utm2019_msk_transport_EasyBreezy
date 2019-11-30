package utm.transport.app.service.location;

import utm.transport.app.entity.location.PathStops;
import utm.transport.app.entity.location.RoutePath;

import java.util.List;
import java.util.Optional;

public interface VehicleService {
    Optional<RoutePath> getRoutePath(String id);
    Optional<List<PathStops>> getRoutePathStops(String id);
}

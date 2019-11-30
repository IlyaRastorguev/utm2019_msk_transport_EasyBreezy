package utm.transport.app.api.dto.location;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Coordinates;
import org.locationtech.jts.geom.Geometry;
import org.postgis.ComposedGeom;
import utm.transport.app.entity.location.RoutePath;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class RoutePathDto {

    private String id;
    private String routeId;
    private String geometry;

    public static RoutePathDto fromEntity(RoutePath routePath) {
        RoutePathDto dto = new RoutePathDto();

        dto.setId(routePath.getId());
        dto.setRouteId(routePath.getRoutePath());
        LinkedHashMap<Double, Double> coordinates = new LinkedHashMap<>();
        List<Coordinate> coordinatesList = Arrays.asList(routePath.getGeometry().getCoordinates());
        coordinatesList.forEach((i)->coordinates.put(i.getX(), i.getY()));
        dto.setGeometry(new Gson().toJson(coordinates));

        return dto;
    }
}

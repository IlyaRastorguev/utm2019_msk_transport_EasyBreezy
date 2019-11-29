package utm.transport.app.api.dto.location;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.postgis.Geometry;
import utm.transport.app.entity.location.RoutePath;

@Getter
@Setter
@NoArgsConstructor
public class RoutePathDto {

    private String id;
    private String routeId;
    private Geometry geometry;

    public static RoutePathDto fromEntity(RoutePath routePath) {
        RoutePathDto dto = new RoutePathDto();

        dto.setId(routePath.getId());
        dto.setRouteId(routePath.getRoutePath());
        dto.setGeometry(routePath.getGeometry());

        return dto;
    }
}

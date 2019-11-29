package utm.transport.app.entity.location;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.postgis.Geometry;
import utm.transport.app.core.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "path_stop")
public class PathStops extends BaseEntity {
    @Column(name = "route_path_id")
    private String pathId;
    @Column(name = "stop_id")
    private String stopId;
    @Column(name = "path_geometry")
    private Geometry geometry;
}

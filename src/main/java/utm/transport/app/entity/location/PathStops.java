package utm.transport.app.entity.location;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utm.transport.app.core.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "path_stop")
public class PathStops extends BaseEntity {
}

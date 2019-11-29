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
@Table(name = "route_path")
public class RoutePath extends BaseEntity {
}

package utm.transport.app.repository.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utm.transport.app.entity.location.PathStops;

@Repository
public interface PathStopsRepository extends JpaRepository<PathStops, String> {
}

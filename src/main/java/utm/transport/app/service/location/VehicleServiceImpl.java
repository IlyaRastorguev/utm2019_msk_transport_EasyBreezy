package utm.transport.app.service.location;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import utm.transport.app.cache.CacheManager;
import utm.transport.app.entity.location.PathStops;
import utm.transport.app.entity.location.RoutePath;
import utm.transport.app.exceptions.MessageRecieveException;
import utm.transport.app.listener.MessageListenerModule;
import utm.transport.app.repository.location.PathStopsRepository;
import utm.transport.app.repository.location.RoutePathRepository;
import utm.transport.app.repository.location.RouteRepository;
import utm.transport.app.repository.location.StopsRepository;

import java.util.List;
import java.util.Optional;

public class VehicleServiceImpl implements VehicleService {
    private final PathStopsRepository pathStopsRepository;
    private final RoutePathRepository routePathRepository;
    private final RouteRepository routeRepository;
    private final StopsRepository stopsRepository;
    private static MessageListenerModule messageListenerModule;

    public VehicleServiceImpl (PathStopsRepository pathStopsRepository, RoutePathRepository routePathRepository, RouteRepository routeRepository, StopsRepository stopsRepository) {
        this.pathStopsRepository = pathStopsRepository;
        this.routePathRepository = routePathRepository;
        this.routeRepository = routeRepository;
        this.stopsRepository = stopsRepository;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Optional<RoutePath> getRoutePath(String id) {
        return routePathRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Optional<List<PathStops>> getRoutePathStops(String id) {
        return pathStopsRepository.findAllPathStops(id);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public void getStarted(String uid) throws MessageRecieveException {
        if (messageListenerModule == null)
            messageListenerModule = MessageListenerModule.init();

        messageListenerModule.receiveMessages(uid);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public void abort(String uid) {
        messageListenerModule.abort(uid);
        messageListenerModule = null;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public String get(String uid) {
        return CacheManager.get(uid);
    }
}

package utm.transport.app.config.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import utm.transport.app.service.location.VehicleService;
import utm.transport.app.service.location.VehicleServiceImpl;


@Configuration
public class ServiceConfig
{

    public ServiceConfig()
    {
    }

    @Bean
    public VehicleService vehicleService()
    {
        return new VehicleServiceImpl();
    }

}

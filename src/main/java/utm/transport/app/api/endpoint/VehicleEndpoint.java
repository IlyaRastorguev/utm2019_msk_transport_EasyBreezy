package utm.transport.app.api.endpoint;


import com.google.gson.Gson;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import utm.transport.app.api.dto.location.VehicleDto;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/vehicle", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api("Locations information")
public class VehicleEndpoint {

    public VehicleEndpoint()
    {
    }

    @GetMapping("/info/{id}")
    public String getVehicleInfo (Long id) {
        List<String> predictedRoute = Arrays.asList("53.333|45.3343", "53.333|45.3343");
        return new Gson().toJson(VehicleDto.toDto("nest", id, predictedRoute, 24));
    }

}

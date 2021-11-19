package project.citiesapi.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.citiesapi.service.DistanceService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/distances")
public class DistanceResource {

    private final DistanceService distanceService;

    @GetMapping
    public ResponseEntity<String> getDistance(@RequestParam(name = "from") final Long idCity1,
                                              @RequestParam(name = "to") final Long idCity2) {
        return distanceService.distanceByCubeInkilometers(idCity1, idCity2);
    }

}

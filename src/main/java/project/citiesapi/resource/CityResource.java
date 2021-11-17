package project.citiesapi.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.citiesapi.service.CityService;
import project.citiesapi.entity.City;

@RestController
@RequestMapping("/cities")
@RequiredArgsConstructor
public class CityResource {

    private final CityService cityService;

    @GetMapping
    public Page<City> getCities(Pageable page) {
        return cityService.getCities(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable Long id) {
        return cityService.getCityById(id);
    }
}

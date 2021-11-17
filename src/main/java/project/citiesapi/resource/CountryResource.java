package project.citiesapi.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.citiesapi.entity.Country;
import project.citiesapi.service.CountryService;

@RestController
@RequestMapping("/countries")
@RequiredArgsConstructor
public class CountryResource {

    private final CountryService countryService;

    @GetMapping
    public Page<Country> getCountries(Pageable page) {
        return countryService.getCountries(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable Long id) {
        return countryService.getCountryById(id);
    }
}

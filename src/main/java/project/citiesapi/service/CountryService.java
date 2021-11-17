package project.citiesapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import project.citiesapi.entity.Country;
import project.citiesapi.repository.CountryRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public Page<Country> getCountries(Pageable page) {
        return countryRepository.findAll(page);
    }

    public ResponseEntity<Country> getCountryById(Long id) {
        Optional<Country> optionalCountry = countryRepository.findById(id);

        if (optionalCountry.isPresent()) {
            return ResponseEntity.ok().body(optionalCountry.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

package project.citiesapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import project.citiesapi.entity.City;
import project.citiesapi.repository.CityRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public Page<City> getCities(Pageable page) {
        return cityRepository.findAll(page);
    }

    public ResponseEntity<String> getCityById(Long id) {
        Optional<City> optionalCity = cityRepository.findById(id);

        if (optionalCity.isPresent()) {
            return ResponseEntity.ok().body(optionalCity.get().toString());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id inválido!");
        }
    }

}

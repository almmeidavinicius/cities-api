package project.citiesapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.geo.Point;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import project.citiesapi.entity.City;
import project.citiesapi.repository.CityRepository;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DistanceService {

    private final CityRepository cityRepository;

    public ResponseEntity<String> distanceByCubeInkilometers(Long idCity1, Long idCity2) {
        List<City> cities = cityRepository.findAllById(Arrays.asList(idCity1, idCity2));
        if (cities.size() < 2) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível realizar o cálculo! Informe Id's válidos.");
        }

        Point point1 = cities.get(0).getLocation();
        Point point2 = cities.get(1).getLocation();
        double distance = cityRepository.distanceByCube(point1.getX(), point1.getY(), point2.getX(), point2.getY());
        String response = String.format("%.2f", distance / 1000).replace(",", ".");

        return ResponseEntity.ok().body("Distância: " + response + "Km");
    }
}

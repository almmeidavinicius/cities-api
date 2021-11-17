package project.citiesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.citiesapi.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}

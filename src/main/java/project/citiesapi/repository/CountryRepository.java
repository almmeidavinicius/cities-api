package project.citiesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.citiesapi.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}

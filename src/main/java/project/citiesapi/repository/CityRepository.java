package project.citiesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.citiesapi.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Query(value = "SELECT earth_distance(ll_to_earth(?1,?2), ll_to_earth(?3,?4)) AS distance", nativeQuery = true)
    Double distanceByCube(final Double latitude1, final Double longitude1, final Double latitude2, final Double longitude2);
}

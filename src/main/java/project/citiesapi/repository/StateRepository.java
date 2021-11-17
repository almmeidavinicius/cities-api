package project.citiesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.citiesapi.entity.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
}

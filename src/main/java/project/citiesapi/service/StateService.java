package project.citiesapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import project.citiesapi.entity.State;
import project.citiesapi.repository.StateRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StateService {

    private final StateRepository stateRepository;

    public Page<State> getStates(Pageable page) {
        return stateRepository.findAll(page);
    }

    public ResponseEntity<State> getStateById(Long id) {
        Optional<State> optionalState = stateRepository.findById(id);

        if (optionalState.isPresent()) {
            return ResponseEntity.ok().body(optionalState.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

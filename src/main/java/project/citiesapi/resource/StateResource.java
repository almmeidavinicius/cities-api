package project.citiesapi.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.citiesapi.entity.State;
import project.citiesapi.service.StateService;

@RestController
@RequestMapping("/states")
@RequiredArgsConstructor
public class StateResource {

    private final StateService stateService;

    @GetMapping
    public Page<State> getStates(Pageable page) {
        return stateService.getStates(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getStateById(@PathVariable Long id) {
        return stateService.getStateById(id);
    }
}

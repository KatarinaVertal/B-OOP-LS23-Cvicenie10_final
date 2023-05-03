package sk.stuba.fei.uim.oop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    private IAnimalService animalService;

    @GetMapping
    public List<AnimalResponse> getAllAnimals() {
        return this.animalService.getAll().stream().map(AnimalResponse::new).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<AnimalResponse> createAnimal(@RequestBody AnimalRequest body) {
        return new ResponseEntity<>(new AnimalResponse(this.animalService.createAnimal(body)), HttpStatus.CREATED);
    }
}

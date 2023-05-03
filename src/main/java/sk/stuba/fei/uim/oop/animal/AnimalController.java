package sk.stuba.fei.uim.oop.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.exceptions.NotFoundException;

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

    @GetMapping("/{name}")
    public List<AnimalResponse> getByName(@PathVariable("name") String name) {
        return this.animalService.getByName(name).stream().map(AnimalResponse::new).collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public AnimalResponse addPersonToAnimal(@PathVariable("id") Long id, @RequestParam("person") Long personId) throws NotFoundException {
        return new AnimalResponse(this.animalService.addPersonToAnimal(id, personId));
    }
}

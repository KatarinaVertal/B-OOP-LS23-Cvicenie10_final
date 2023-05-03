package sk.stuba.fei.uim.oop.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.stuba.fei.uim.oop.animal.AnimalResponse;
import sk.stuba.fei.uim.oop.animal.AnimalService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private IPersonService personService;

    @GetMapping
    public List<PersonResponse> getAllAnimals() {
        return this.personService.getAll().stream().map(PersonResponse::new).collect(Collectors.toList());
    }
}

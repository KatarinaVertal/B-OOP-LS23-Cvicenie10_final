package sk.stuba.fei.uim.oop.animal;

import lombok.Getter;
import sk.stuba.fei.uim.oop.person.Person;

@Getter
public class AnimalResponse {
    private Long id;
    private String species;
    private String name;
    private Person person;

    public AnimalResponse(Animal animal) {
        this.id = animal.getId();
        this.species = animal.getSpecies();
        this.name = animal.getName();
        this.person = animal.getPerson();
    }
}

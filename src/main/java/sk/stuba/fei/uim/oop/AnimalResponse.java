package sk.stuba.fei.uim.oop;

import lombok.Getter;

@Getter
public class AnimalResponse {
    private Long id;
    private String species;

    public AnimalResponse(Animal animal) {
        this.id = animal.getId();
        this.species = animal.getSpecies();
    }
}

package sk.stuba.fei.uim.oop.animal;

import sk.stuba.fei.uim.oop.exceptions.NotFoundException;

import java.util.List;

public interface IAnimalService {
    List<Animal> getAll();

    Animal createAnimal(AnimalRequest body);

    List<Animal> getByName(String name);

    Animal addPersonToAnimal(Long id, Long personId) throws NotFoundException;
}

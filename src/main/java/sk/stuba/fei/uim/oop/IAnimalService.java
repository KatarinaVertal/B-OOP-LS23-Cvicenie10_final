package sk.stuba.fei.uim.oop;

import java.util.List;

public interface IAnimalService {
    List<Animal> getAll();

    Animal createAnimal(AnimalRequest body);
}

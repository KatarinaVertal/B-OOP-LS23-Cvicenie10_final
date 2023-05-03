package sk.stuba.fei.uim.oop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService implements IAnimalService {

    private IAnimalRepository repository;

    public AnimalService(IAnimalRepository repository) {
        this.repository = repository;
        Animal a1 = new Animal();
        a1.setSpecies("dog");
        Animal a2 = new Animal();
        a2.setSpecies("cat");
        this.repository.save(a1);
        System.out.println(a2);
        this.repository.save(a2);
        System.out.println(a2);
        this.repository.delete(a2);
    }

    public List<Animal> getAll() {
        return this.repository.findAll();
    }

    public Animal createAnimal(AnimalRequest body) {
        Animal a = new Animal();
        a.setSpecies(body.getSpecies());
        return this.repository.save(a);
    };
}

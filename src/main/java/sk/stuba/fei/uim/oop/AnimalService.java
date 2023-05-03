package sk.stuba.fei.uim.oop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AnimalService implements IAnimalService {

    private IAnimalRepository repository;

    public AnimalService(IAnimalRepository repository) {
        this.repository = repository;
        Animal a1 = new Animal();
        a1.setSpecies("dog");
        a1.setName("luna");
        Animal a2 = new Animal();
        a2.setSpecies("cat");
        a2.setName("murko");
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
        a.setName(body.getName());
        return this.repository.save(a);
    }

    @Override
    public List<Animal> getByName(String name) {
        return this.repository.findAllByName(name);
    }
}

package sk.stuba.fei.uim.oop;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> findAll();

    List<Animal> findAllByName(String name);
}

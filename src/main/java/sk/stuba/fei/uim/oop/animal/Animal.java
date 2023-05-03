package sk.stuba.fei.uim.oop.animal;

import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.uim.oop.person.Person;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String species;

    private String name;

    @OneToMany
    private List<Person> person;

    public Animal(String species, String name) {
        this();
        this.species = species;
        this.name = name;
    }

    public Animal() {
        this.person = new ArrayList<>();
    }
}

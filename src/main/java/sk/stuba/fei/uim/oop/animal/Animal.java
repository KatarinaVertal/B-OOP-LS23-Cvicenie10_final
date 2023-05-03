package sk.stuba.fei.uim.oop.animal;

import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.uim.oop.person.Person;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String species;

    private String name;

    @OneToOne
    private Person person;

    public Animal(String species, String name) {
        this.species = species;
        this.name = name;
    }
}

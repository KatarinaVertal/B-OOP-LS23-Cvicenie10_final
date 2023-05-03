package sk.stuba.fei.uim.oop.person;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {

    private IPersonRepository repository;

    public PersonService(IPersonRepository repository) {
        this.repository = repository;

        this.repository.save(new Person("Tomas"));
        this.repository.save(new Person("Jakub"));
        this.repository.save(new Person("Stanislav"));
    }

    public List<Person> getAll() {
        return this.repository.findAll();
    }

    public Person getById(Long id) {
        return this.repository.findById(id).get();
    }
}

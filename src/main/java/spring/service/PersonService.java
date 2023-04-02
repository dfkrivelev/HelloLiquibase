package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.domain.Person;
import spring.domain.Position;
import spring.repository.PersonRepository;
import spring.repository.PositionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PositionRepository positionRepository;

    @Autowired
    PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public void add(Person person) {
        Person newPerson = new Person(person.getFirstName(), person.getLastName());
        Optional<Position> position = positionRepository.findById(1);
        newPerson.setPosition(position.get());
        personRepository.save(newPerson);
    }

    public void delete(Integer id) {
        personRepository.deleteById(id);
    }

    public void update(Person person) {
        personRepository.save(person);
    }

    public Person getPersonById(Integer id) {
        return personRepository.findById(id).get();
    }
}
